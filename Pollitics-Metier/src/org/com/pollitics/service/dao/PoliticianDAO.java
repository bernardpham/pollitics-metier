package org.com.pollitics.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.com.pollitics.model.jpa.Politician;

public class PoliticianDAO extends AbstractDAO<Politician> {
	
	private static PoliticianDAO instance;

	public static PoliticianDAO getInstance() {
		
		if(instance == null){
			instance = new PoliticianDAO();
		}
		
		return instance;
	}
	
	public void createPolitician(Politician politician) {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(politician);
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}

	public void updatePolitician(Politician politician) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Politician politicianUpdated = entitymanager.find(Politician.class, politician.getIdPolitician());
		politicianUpdated.setFirstName(politician.getFirstName());
		politicianUpdated.setLastName(politician.getLastName());
		politicianUpdated.setBirthDate(politician.getBirthDate());
		politicianUpdated.setParty(politician.getParty());
//		politicianUpdated.setProfilePictureUrl(politician.getProfilePictureUrl());
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}
	
	public Politician getPoliticianFromId(Integer idPoliticianBG) {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		Politician politician = entitymanager.find(Politician.class, idPoliticianBG);

		entitymanager.close();
		return politician;
	}

	public List<Politician> getPoliticianListFromFirstNameOrLastNameOrParty(String firstName, String lastName, String politicalParty) {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("Select p from Politician p where p.firstName like :firstName and p.lastName like :lastName "
				+ " and p.party like :party");
		
//		String whereClause = " where ";
//		boolean addAndClause = false;
//		
//		if(!StringUtils.isEmpty(firstName)){
//			whereClause = whereClause + "p.firstName = :firstName ";
//			addAndClause = true;
//		}
//		
//		if(!StringUtils.isEmpty(lastName)){
//			if(addAndClause){
//				whereClause = whereClause + " and ";
//			}
//			whereClause = whereClause + "p.lastName = :lastName ";
//			addAndClause = true;
//		}
		
		if(StringUtils.isEmpty(firstName)){
			query.setParameter("firstName", "%");
		}else{
			query.setParameter("firstName", firstName);
		}
		
		if(StringUtils.isEmpty(lastName)){
			query.setParameter("lastName", "%");
		}else{
			query.setParameter("lastName", lastName);
		}
		
		if(StringUtils.isEmpty(politicalParty)){
			query.setParameter("party", "%");
		}else{
			query.setParameter("party", politicalParty);
		}
		
		List<Politician> politicians = query.getResultList();
		
		entitymanager.close();
		return politicians;
	}
	
	public List<Politician> getAllPolitician() {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("Select p from Politician p");
		List<Politician> politicians = query.getResultList();
		
		entitymanager.close();
		return politicians;
	}

	@Override
	public Politician findObject(EntityManager entitymanager, int IdObjet) {
		Politician politicianUpdated = entitymanager.find(Politician.class, IdObjet);
		return politicianUpdated;
	}

	@Override
	public void updateObject(Politician objectToUpdate, Politician object) {
		objectToUpdate.setFirstName(object.getFirstName());
		objectToUpdate.setLastName(object.getLastName());
		objectToUpdate.setBirthDate(object.getBirthDate());
		objectToUpdate.setParty(object.getParty());
		objectToUpdate.setProfilePicture(object.getProfilePicture());
	}
}
