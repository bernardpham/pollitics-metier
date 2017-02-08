package main.java.services.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import main.java.exception.ExceptionFonctionnelle;
import main.java.exception.ExceptionTechnique;
import main.java.modele.Utilisateur;

import org.hibernate.exception.ConstraintViolationException;


public class UtilisateurDAO extends JpaDao<Utilisateur> {

	public void creerUtilisateur(Utilisateur utilisateur) throws ExceptionFonctionnelle, ExceptionTechnique {
		
		try{
			EntityTransaction transac = entityManager.getTransaction();
			transac.begin();
			
			entityManager.persist(utilisateur);
			transac.commit();
		} catch(ConstraintViolationException e){
			throw new ExceptionFonctionnelle("Utilisateur déjà existant en base : " + e.getMessage(), e);
		} 
	}
	
	public Utilisateur authentifierUtilisateur(Utilisateur utilisateur) throws ExceptionFonctionnelle, ExceptionTechnique {
		
		Utilisateur utilisateurBdd = null;
		
		try{

			Query query = entityManager.createQuery("SELECT u from utilisateur u WHERE u.login=:login AND u.password=:password", 
					Utilisateur.class);
			
			query.setParameter("login", utilisateur.getLogin());
			query.setParameter("password", utilisateur.getPassword());
			
			utilisateurBdd = (Utilisateur) query.getSingleResult();
			
		} catch(Exception e){
			throw new ExceptionTechnique(e);
		}
		
		return utilisateurBdd;
	}
	
	public Utilisateur miseAJourTokenUtilisateur(Utilisateur utilisateur, String token, 
			Date tokenExpirationTime) throws ExceptionFonctionnelle, ExceptionTechnique {
		
		Utilisateur utilisateurValid = null;
		
		try{

			Utilisateur utilisateurToUpdate = entityManager.find(Utilisateur.class, utilisateur.getId());
			
			entityManager.getTransaction().begin();
			
			utilisateurToUpdate.setToken(token);
			utilisateurToUpdate.setTokenExpirationTime(tokenExpirationTime);
			
			entityManager.getTransaction().commit();
			
		} catch(Exception e){
			throw new ExceptionTechnique(e);
		}
		
		return utilisateurValid;
	}
	
	public Utilisateur chercherUtilisateurParTokenEtMail(String login, String token) throws ExceptionFonctionnelle, ExceptionTechnique {
		
		Utilisateur utilisateurValid = null;
		
		try{

			Query query = entityManager.createQuery("SELECT u from utilisateur u WHERE u.login=:login AND u.token=:token", 
					Utilisateur.class);
			query.setParameter("login", login);
			query.setParameter("token", token);
			
			utilisateurValid = (Utilisateur) query.getSingleResult();
		} catch(NoResultException e){
			throw new ExceptionFonctionnelle("Aucun résultat n'a été trouvé.",e);
		} catch(Exception e){
			throw new ExceptionTechnique(e);
		}
		
		return utilisateurValid;
	}
}
