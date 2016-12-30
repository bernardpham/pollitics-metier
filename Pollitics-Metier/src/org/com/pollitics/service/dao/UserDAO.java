package org.com.pollitics.service.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.com.pollitics.model.jpa.User;

public class UserDAO extends AbstractDAO<User> {
	
	private static UserDAO instance;

	public static UserDAO getInstance() {
		
		if(instance == null){
			instance = new UserDAO();
		}
		return instance;
	}
	
	public void createUser(User user) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(user);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
	
	public List<User> selectUserFromLogin(String login) {
//		EntityManagerFactory emfactory = PoliticianDAO.getInstance().getEmfactory();
//
//		EntityManager entitymanager = emfactory.createEntityManager();
//		Query query = entitymanager.createQuery("Select u from User u where u.login=:login ");
//		
//		query.setParameter("login", login);
//		
//		List<User> users = query.getResultList();
//		
//		entitymanager.close();
////		emfactory.close();
		return null;
	}

	@Override
	public User findObject(EntityManager entitymanager, int IdObjet) {
		User object = entitymanager.find(User.class, IdObjet);
		return object;
	}

	@Override
	public void updateObject(User objectToUpdate, User object) {
		objectToUpdate.setFirstName(object.getFirstName());
		objectToUpdate.setLastName(object.getLastName());
		objectToUpdate.setLogin(object.getLogin());
		objectToUpdate.setUpdatedDate(new Timestamp(new Date().getTime()));
	}
}
