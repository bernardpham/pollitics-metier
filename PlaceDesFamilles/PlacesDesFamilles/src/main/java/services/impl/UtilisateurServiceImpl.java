package main.java.services.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.exception.ExceptionFonctionnelle;
import main.java.exception.ExceptionTechnique;
import main.java.modele.Utilisateur;
import main.java.services.dao.impl.UtilisateurDAO;
import main.java.services.interfaces.IUtilisateurService;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
	
	private static final Logger logger = Logger.getLogger(UtilisateurServiceImpl.class);
	
	@Autowired
	private UtilisateurDAO utilisateurDao;

	public void creerUtilisateur(Utilisateur utilisateur) throws ExceptionFonctionnelle, ExceptionTechnique {
		logger.debug("UtilisateurServiceImpl.creerUtilisateur - IN");
		
		if (utilisateur == null) {
			String erreur = "L'utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		utilisateurDao.creerUtilisateur(utilisateur);
		logger.debug("UtilisateurServiceImpl.creerUtilisateur - OUT");
	}

	public Utilisateur chercherUtilisateur(Integer idUtilisateur) throws ExceptionFonctionnelle, ExceptionTechnique {
		logger.debug("UtilisateurServiceImpl.chercherUtilisateur - IN");
		
		if(idUtilisateur==null){
			String erreur = "L'id utilisateur ne peut être nul";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		Utilisateur utilisateur = utilisateurDao.findById(idUtilisateur);
	
		logger.debug("UtilisateurServiceImpl.chercherUtilisateur - OUT");
		return utilisateur;
	}

	@Override
	public boolean supprimerUtilisateur(Utilisateur utilisateur)
			throws ExceptionFonctionnelle, ExceptionTechnique {
		logger.debug("UtilisateurServiceImpl.supprimerUtilisateur - IN");
		
		if (utilisateur == null) {
			String erreur = "L'utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		utilisateurDao.remove(utilisateur);
		
		logger.debug("UtilisateurServiceImpl.supprimerUtilisateur - OUT");
		return false;
	}

	public Utilisateur authentifierUtilisateur(Utilisateur utilisateur) throws ExceptionFonctionnelle, ExceptionTechnique{
		logger.debug("UtilisateurServiceImpl.authentifierUtilisateur - IN");
		
		if (utilisateur == null) {
			String erreur = "L'utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		} else if (utilisateur.getLogin() == null) {
			String erreur = "L'adresse mail ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		} else if (utilisateur.getPassword() == null) {
			String erreur = "Le mot de passe utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		Utilisateur utilisateurBdd = utilisateurDao.authentifierUtilisateur(utilisateur);
		
		logger.debug("UtilisateurServiceImpl.authentifierUtilisateur - OUT");
		return utilisateurBdd;
	}
	
	public void mettreAJourTokenUtilisateur(Utilisateur utilisateur, String token) throws ExceptionFonctionnelle, ExceptionTechnique{
		logger.debug("UtilisateurServiceImpl.mettreAJourTokenUtilisateur - IN");
		
		if (utilisateur == null) {
			String erreur = "L'utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		if (utilisateur.getId() == null) {
			String erreur = "L'identifiant de l'utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		if (token == null) {
			String erreur = "Le token ne peut pas être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		/** mise à jour de la date d'expiration du token à X minutes **/
		Date expirationDate = new Date(System.currentTimeMillis() + 20 *60*1000);
		
		utilisateurDao.miseAJourTokenUtilisateur(utilisateur, token, expirationDate);
		
		logger.debug("UtilisateurServiceImpl.mettreAJourTokenUtilisateur - OUT");
//		return authentificationValid;
	}

	@Override
	public Utilisateur verifierUtilisateurParToken(String utilisateur, String token)
			throws ExceptionFonctionnelle, ExceptionTechnique {
		logger.debug("UtilisateurServiceImpl.mettreAJourTokenUtilisateur - IN");
		
		if (utilisateur == null) {
			String erreur = "L'utilisateur ne peut être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		if (token == null) {
			String erreur = "Le token ne peut pas être nul.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		Utilisateur utilisateurBDD = utilisateurDao.chercherUtilisateurParTokenEtMail(utilisateur, token);
		
		if(utilisateurBDD!=null){
			/** Si le token associé à l'utilisateur a été retrouvé **/
			Date dateExpiration = utilisateurBDD.getTokenExpirationTime(); 
			Date heureActuelle = new Date();
			
			if (heureActuelle.compareTo(dateExpiration) <= 0) {
				/** heureActuelle < dateExpiration **/
				/** mise à jour de la date d'expiration du token **/
				mettreAJourTokenUtilisateur(utilisateurBDD, token);
			} else {
				/** heureActuelle > dateExpiration **/
				/** renvoie null => utilisateur non valide **/
				utilisateurBDD = null;
				String erreur = "Le token a expiré.";
				logger.error("Exception fonctionnelle : " + erreur);
				throw new ExceptionFonctionnelle(erreur);
			}
		} else {
			String erreur = "Le token n'est pas valide.";
			logger.error("Exception fonctionnelle : " + erreur);
			throw new ExceptionFonctionnelle(erreur);
		}
		
		logger.debug("UtilisateurServiceImpl.mettreAJourTokenUtilisateur - OUT");
		return utilisateurBDD;
	}
}
