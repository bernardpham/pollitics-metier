package main.java.services.interfaces;

import org.springframework.stereotype.Service;

import main.java.exception.ExceptionFonctionnelle;
import main.java.exception.ExceptionTechnique;
import main.java.modele.Utilisateur;

@Service
public interface IUtilisateurService {

	public void creerUtilisateur(Utilisateur utilisateur) throws ExceptionFonctionnelle, ExceptionTechnique;
	
	public boolean supprimerUtilisateur(Utilisateur utilisateur) throws ExceptionFonctionnelle, ExceptionTechnique;
	
	public Utilisateur chercherUtilisateur(Integer idUtilisateur) throws ExceptionFonctionnelle, ExceptionTechnique;
	
	public Utilisateur authentifierUtilisateur(Utilisateur idUtilisateur) throws ExceptionFonctionnelle, ExceptionTechnique;
	
	public void mettreAJourTokenUtilisateur(Utilisateur utilisateur, String token) throws ExceptionFonctionnelle, ExceptionTechnique;
	
	public Utilisateur verifierUtilisateurParToken(String userName, String token) throws ExceptionFonctionnelle, ExceptionTechnique;
}
