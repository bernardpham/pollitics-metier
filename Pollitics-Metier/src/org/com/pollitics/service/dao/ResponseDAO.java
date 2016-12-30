package org.com.pollitics.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.com.pollitics.model.QuestionResponse;
import org.com.pollitics.model.ResponsePoll;
import org.com.pollitics.model.jpa.Politician;
import org.com.pollitics.model.jpa.Response;
import org.com.pollitics.model.jpa.UserResponse;

public class ResponseDAO extends AbstractDAO<Response> {

	private static ResponseDAO instance;

	public static ResponseDAO getInstance() {
		
		if(instance == null){
			instance = new ResponseDAO();
		}
		return instance;
	}
	
	public void createResponse(ResponsePoll response) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(response);
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}
	
	public void createResponse(org.com.pollitics.model.jpa.Response response) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(response);
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}
	
	public  void saveUserResponse(UserResponse userResponse) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(userResponse);
		
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}
	
	public  List<QuestionResponse> selectResponseFromIDQuestion(long idQuestion) {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();

		Query query = entitymanager.createQuery("Select qr from QuestionResponse qr where qr.primaryKey.idQuestion=:idQuestion");
		query.setParameter("idQuestion", idQuestion);
		
		List<QuestionResponse> questionResponses = query.getResultList();
		
		entitymanager.close();
		emfactory.close();
		
		return questionResponses;
	}

	@Override
	public Response findObject(EntityManager entitymanager, int IdObjet) {
		Response object = entitymanager.find(Response.class, IdObjet);
		return object;
	}

	@Override
	public void updateObject(Response objectToUpdate, Response object) {
		objectToUpdate.setIdQuestion(object.getIdQuestion());
		objectToUpdate.setWording(object.getWording());
		objectToUpdate.setUserResponses(object.getUserResponses());
	}
}
