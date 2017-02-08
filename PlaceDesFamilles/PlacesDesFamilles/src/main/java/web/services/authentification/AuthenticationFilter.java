package main.java.web.services.authentification;

import java.util.Locale;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import main.java.exception.ExceptionFonctionnelle;
import main.java.exception.ExceptionTechnique;
import main.java.modele.Utilisateur;
import main.java.services.interfaces.IUtilisateurService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	/**
	 * Source : http://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
	 */
	
	private static final Logger logger = Logger.getLogger(AuthenticationFilter.class);
	
 	@Autowired
 	private MessageSource messageSource;
	
	@Autowired
	private IUtilisateurService utilisateurService; 
	
	@Override
	public void filter(ContainerRequestContext requestContext) {
		
        // Get the HTTP Authorization header from the request
        String authorizationHeader =  
            requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        // Check if the HTTP Authorization header is present and formatted correctly 
        /**
         * Utilisation de l'attribut Bearer dans l'entête de sécurité  
         * http://security.stackexchange.com/questions/108662/why-is-bearer-required-before-the-token-in-authorization-header-in-a-http-re
         */
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
        	String messageErreur = messageSource.getMessage("authorizationHeader.header.error", null, new Locale("fr"));
        	logger.error(messageErreur);
            throw new NotAuthorizedException(messageErreur);
        }
        
        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {
        	String username = requestContext.getHeaderString("username");
        	
            // Validate the token
            Utilisateur utilisateur = verifierUtilisateurParToken(username, token);
        
            /** Permet de mettre en session le username avec le  token **/
            SecurityContext securityContext = getSecurityContext(utilisateur, username);
            requestContext.setSecurityContext(securityContext);
            
        } catch (ExceptionFonctionnelle e) {
        	logger.error("ExceptionFonctionnelle : " +e.getMessage() );
        	requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        } catch (ExceptionTechnique e) {
        	logger.error("ExceptionTechnique : " +e.getMessage() );
        	requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
	}

	private SecurityContext getSecurityContext(Utilisateur utilisateur, String username) {
		
		UtilisateurContext utilisateurCtx = new UtilisateurContext();
		utilisateurCtx.setUserName(username);
		utilisateurCtx.setRole(Role.valueOf(utilisateur.getRole()));
		
		SecurityContext securityCtx = new ApplicationSecurityContext(utilisateurCtx, "");
		
        return securityCtx;
	}

	private Utilisateur verifierUtilisateurParToken(String username, String token) throws ExceptionFonctionnelle, ExceptionTechnique {
		Utilisateur utilisateur = utilisateurService.verifierUtilisateurParToken(username, token);
		return utilisateur;
	}
}
