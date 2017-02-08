package main.java.services.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import main.java.services.dao.interfaces.Dao;

public abstract class JpaDao<E> implements Dao<E> {
	
	protected Class entityClass;

//	@PersistenceUnit(unitName="PlaceDesFamillesMetier")
	protected EntityManagerFactory emf;
	
	//EntityManager em = emf.createEntityManager();
	
//	@PersistenceContext//(unitName="PlaceDesFamillesMetier")
	protected EntityManager entityManager;

	public JpaDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[0];
		
		this.emf = Persistence.createEntityManagerFactory("PlaceDesFamillesMetier");
		this.entityManager = emf.createEntityManager();
	}

	public void persist(E entity) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.persist(entity);
		transac.commit();
	}

	public void remove(E entity) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.remove(entity);
		transac.commit();
	}

	public E findById(Integer id) {
		return (E) entityManager.find(entityClass, id);
	}
}
