package main.java.web.services.rest;

import java.math.BigInteger;
import java.security.Principal;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import main.java.exception.ExceptionFonctionnelle;
import main.java.exception.ExceptionTechnique;
import main.java.modele.Utilisateur;
import main.java.services.interfaces.IUtilisateurService;
import main.java.utils.JavaToJsonUtils;
import main.java.web.services.authentification.Role;
import main.java.web.services.authentification.Secured;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Path("/utilisateur")
public class UtilisateurServiceRest {
	
	private static Logger logger = Logger.getLogger(UtilisateurServiceRest.class);
	
 	@Autowired
	private IUtilisateurService utilisateurService; 
 	
 	@Autowired
 	private MessageSource messageSource;
 	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response authentification(Utilisateur utilisateur){
		logger.info("UtilisateurServiceRest.authentification - IN ");
		
		String token ="";
		try {
			Utilisateur utilisateurAuthenfie = utilisateurService.authentifierUtilisateur(utilisateur);
			 
			if(utilisateurAuthenfie!=null){
				//returnMessage = messageSource.getMessage("authentification.ok", null, new Locale("fr"));
				token = genererToken(utilisateurAuthenfie);
				utilisateurService.mettreAJourTokenUtilisateur(utilisateurAuthenfie, token);
				
			}else {
				token = messageSource.getMessage("authentification.nok", null, new Locale("fr"));
			}
			
		} catch (ExceptionFonctionnelle e) {
			logger.error("Erreur fonctionnelle :" + e.getMessage());
			token = e.getMessage();
			e.printStackTrace();
		} catch (ExceptionTechnique e) {
			logger.error("Erreur technique :" + e.getMessage());
			token = e.getMessage();
			e.printStackTrace();
		}
		
		logger.info("UtilisateurServiceRest.authentification - OUT ");
		return Response.status(200).entity(token).build();
	}
	
	/**
	 * Méthode de génération d'un token aléatoire
	 * @param utilisateur
	 * @return
	 */
	private String genererToken(Utilisateur utilisateur) {
		Random random = new SecureRandom();
		String token = new BigInteger(130, random).toString(32);
		return token;
	}

	@GET
	@Path("/find/{param}")
	public Response chercherUtilisateur(@PathParam("param") Integer idUtilisateur) {
		logger.info("UtilisateurServiceRest.findUtilisateur - IN ");

		Utilisateur utilisateur = null;
		String returnMessage = "";

		try {
			if (idUtilisateur == null) {
				String erreur = messageSource.getMessage("utilisateur.identifiant.erreur", null, new Locale("fr"));
				throw new ExceptionFonctionnelle(erreur);
			}
			
			utilisateur = utilisateurService.chercherUtilisateur(idUtilisateur);
			returnMessage = JavaToJsonUtils.convertJavaToJson(utilisateur);

			if (utilisateur == null) {
				String erreur = messageSource.getMessage("utilisateur.recherche.erreur", 
						new String[]{idUtilisateur.toString()}, new Locale("fr"));
				logger.error("Exception fonctionnelle : " + erreur);
				throw new ExceptionFonctionnelle(erreur);
			}
			
		} catch (ExceptionFonctionnelle e) {
			logger.error("Erreur fonctionnelle :" + e.getMessage());
			returnMessage = e.getMessage();
			e.printStackTrace();
		} catch (ExceptionTechnique e) {
			logger.error("Erreur technique :" + e.getMessage());
			returnMessage = e.getMessage();
			// TODO : redirect a envisager ?
			e.printStackTrace();
		}

		logger.info("UtilisateurServiceRest.findUtilisateur - OUT ");
		return Response.status(200).entity(returnMessage).build();
	}
	
	@Secured({Role.ADMINISTRATEUR})
	@POST
	@Path("/create")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response creerUtilisateur(Utilisateur utilisateur, @Context SecurityContext securityContext) {
		logger.info("UtilisateurServiceRest.creerUtilisateur - IN ");
		
		Principal principal = securityContext.getUserPrincipal();
		String username = principal.getName();
		
		String returnMessage = "";
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			if (utilisateur == null) {
				String erreur = messageSource.getMessage("utilisateur.erreur", null, new Locale("fr"));
				throw new ExceptionFonctionnelle(erreur);
			} else{
				if (utilisateur.getCivilite() == null) {
					String erreur = messageSource.getMessage("utilisateur.civilite.erreur", null, new Locale("fr"));
					stringBuilder.append(erreur).append("\n");
				} 
				
				if (utilisateur.getNom() == null) {
					String erreur = messageSource.getMessage("utilisateur.nom.erreur", null, new Locale("fr"));
					stringBuilder.append(erreur).append("\n");
				} 
				
				if (utilisateur.getPrenom() == null) {
					String erreur = messageSource.getMessage("utilisateur.prenom.erreur", null, new Locale("fr"));
					stringBuilder.append(erreur).append("\n");
				} 
				
				if (utilisateur.getLogin() == null) {
					String erreur = messageSource.getMessage("utilisateur.mail.erreur", null, new Locale("fr"));
					stringBuilder.append(erreur).append("\n");
				} 
				
				if (utilisateur.getPassword() == null) {
					String erreur = messageSource.getMessage("utilisateur.motdepasse.erreur", null, new Locale("fr"));
					stringBuilder.append(erreur).append("\n");
				} 
				
				if(stringBuilder.length()!=0){
					throw new ExceptionFonctionnelle(stringBuilder.toString());
				}
			}
			
			utilisateurService.creerUtilisateur(utilisateur);
			
			returnMessage = messageSource.getMessage("utilisateur.creation.ok", null, new Locale("fr"));
		} catch (ExceptionFonctionnelle e) {
			logger.error("Erreur fonctionnelle :" + e.getMessage());
			returnMessage = e.getMessage();
			e.printStackTrace();
		} catch (ExceptionTechnique e) {
			logger.error("Erreur technique :" + e.getMessage());
			returnMessage = e.getMessage();
			// TODO : redirect a envisager ?
			e.printStackTrace();
		}

		logger.info("UtilisateurServiceRest.creerUtilisateur - OUT ");
		return Response.status(200).entity(returnMessage).build();
	}
	
	@Secured({Role.ADMINISTRATEUR, Role.CLIENT, Role.GESTIONNAIRE})
	@POST
	@Path("/test")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response test(Utilisateur utilisateur, @Context SecurityContext securityContext) {
		logger.info("UtilisateurServiceRest.creerUtilisateur - IN ");
		

		logger.info("UtilisateurServiceRest.creerUtilisateur - OUT ");
		return Response.status(200).entity("ok").build();
	}
}
