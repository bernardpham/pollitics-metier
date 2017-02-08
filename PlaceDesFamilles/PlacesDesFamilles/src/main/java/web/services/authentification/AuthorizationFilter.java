package main.java.web.services.authentification;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

	/**
	 * Source : http://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
	 */
	
	@Context
    private ResourceInfo resourceInfo;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get the resource class which matches with the requested URL
        // Extract the roles declared by it
        Class<?> resourceClass = resourceInfo.getResourceClass();
        List<Role> classRoles = extractRoles(resourceClass);

        // Get the resource method which matches with the requested URL
        // Extract the roles declared by it
        Method resourceMethod = resourceInfo.getResourceMethod();
        List<Role> methodRoles = extractRoles(resourceMethod);
		
        SecurityContext securityContext = requestContext.getSecurityContext();
        
//        try {

            // Check if the user is allowed to execute the method
            // The method annotations override the class annotations
        
        	boolean roleAutorise = false;
        
            if (methodRoles.isEmpty()) {
            	roleAutorise = checkPermissions(classRoles, securityContext);
            } else {
            	roleAutorise = checkPermissions(methodRoles, securityContext);
            }

            if(!roleAutorise){
            	requestContext.abortWith(
                      Response.status(Response.Status.FORBIDDEN).build());
            }
//        } catch (Exception e) {
//            requestContext.abortWith(
//                Response.status(Response.Status.FORBIDDEN).build());
//        }
	}

    // Extract the roles from the annotated element
    private List<Role> extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return new ArrayList<Role>();
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return new ArrayList<Role>();
            } else {
                Role[] allowedRoles = secured.value();
                return Arrays.asList(allowedRoles);
            }
        }
    }
    
    private boolean checkPermissions(List<Role> allowedRoles, SecurityContext securityContext) {
        // Check if the user contains one of the allowed roles
        // Throw an Exception if the user has not permission to execute the method
    	
//    	for(Role role : allowedRoles){
//    		securityContext.isUserInRole(role.toString());
//    	}
    	
    	boolean roleAutorise = false;
    	Iterator<Role> itRole = allowedRoles.iterator();
    	
    	while(itRole.hasNext() && !roleAutorise){
    		Role role = itRole.next();
    		if(securityContext.isUserInRole(role.toString())){
    			roleAutorise = true;
    		}
    	}//fin while
    	
    	return roleAutorise;
    }
}
