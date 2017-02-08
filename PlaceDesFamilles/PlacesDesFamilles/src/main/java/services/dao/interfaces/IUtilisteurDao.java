package main.java.services.dao.interfaces;

import java.util.List;

import main.java.modele.Utilisateur;
import main.java.services.dao.impl.UtilisateurDAO;



public interface IUtilisteurDao extends Dao<Utilisateur> {
	
	public List<UtilisateurDAO> findAllUtilisateur(); 
}
