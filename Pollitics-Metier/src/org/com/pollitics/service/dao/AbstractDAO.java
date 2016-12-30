package org.com.pollitics.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAO<T> {

	private EntityManagerFactory emfactory;
	
	protected EntityManagerFactory getEmfactory() {
		if(emfactory == null){
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pollitics");
			this.setEmfactory(emfactory);
		}
		return emfactory;
	}

	private void setEmfactory(EntityManagerFactory emfactory) {
		this.emfactory = emfactory;
	}
	
	public void createObject(T obj){
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(obj);
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}
	
	public void updateObjectById(int IdObjet, T obj){
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		T objectToUpdate = findObject(entitymanager, IdObjet);
		updateObject(objectToUpdate, obj);
		
//		Politician politicianUpdated = entitymanager.find(Politician.class, politician.getIdPolitician());
//		politicianUpdated.setFirstName(politician.getFirstName());
//		politicianUpdated.setLastName(politician.getLastName());
//		politicianUpdated.setBirthDate(politician.getBirthDate());
//		politicianUpdated.setPoliticalParty(politician.getPoliticalParty());
//		politicianUpdated.setProfilePictureUrl(politician.getProfilePictureUrl());
		
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}

	public T findObject(int IdObjet){
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		T objectToUpdate = findObject(entitymanager, IdObjet);
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		return objectToUpdate;
	}
	
	protected abstract T findObject(EntityManager entitymanager, int IdObjet);
	
	public abstract void updateObject(T objectToUpdate, T object);
}