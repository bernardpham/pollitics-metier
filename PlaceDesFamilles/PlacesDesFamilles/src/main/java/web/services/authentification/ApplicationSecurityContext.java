package main.java.web.services.authentification;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class ApplicationSecurityContext implements SecurityContext {

	/** 
	 * source : https://simplapi.wordpress.com/2015/09/19/jersey-jax-rs-securitycontext-in-action/
	 * **/
	private UtilisateurContext utilisateurContexte;
	
	private String scheme;
	
	public ApplicationSecurityContext(UtilisateurContext utilisateurContexte, String scheme){
		this.utilisateurContexte = utilisateurContexte;
		this.scheme = scheme;
	}
	
	@Override
	public Principal getUserPrincipal() {
		return utilisateurContexte;
	}

	@Override
	public boolean isUserInRole(String role) {
		return Role.valueOf(role).equals(utilisateurContexte.getRole());
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	public UtilisateurContext getUtilisateurContexte() {
		return utilisateurContexte;
	}

	public void setUtilisateurContexte(UtilisateurContext utilisateurContexte) {
		this.utilisateurContexte = utilisateurContexte;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
}
