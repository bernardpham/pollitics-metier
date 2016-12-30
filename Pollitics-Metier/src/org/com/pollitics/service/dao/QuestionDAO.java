package org.com.pollitics.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.com.pollitics.exception.FunctionnalException;
import org.com.pollitics.model.jpa.Question;

public class QuestionDAO extends AbstractDAO<Question> {

	private static QuestionDAO instance;

	public static QuestionDAO getInstance() {
		
		if(instance == null){
			instance = new QuestionDAO();
		}
		
		return instance;
	}
	
	public void createQuestion(Question question) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(question);
		entitymanager.getTransaction().commit();

		entitymanager.close();
	}
	
	public void createQuestionList(List<Question> questions) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		for(Question question : questions){
			entitymanager.persist(question);
		}
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public  void updateQuestion(Question question) {

		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Question questionUpdated = entitymanager.find(Question.class, question.getIdQuestion());
		questionUpdated.setDailyQuestion(question.getDailyQuestion());
		questionUpdated.setType(question.getType());
		questionUpdated.setWording(question.getWording());
		questionUpdated.setTotalResponseNumber(question.getTotalResponseNumber());
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
	}
	
	public  List<Question> selectAllQuestion() throws FunctionnalException {
		
		List<Question> questionList = null;
		
		try{
			
			EntityManagerFactory emfactory = getEmfactory();

			EntityManager entitymanager = emfactory.createEntityManager();
			Query query = entitymanager.createQuery("Select q from Question q");
			questionList = query.getResultList();
			
			entitymanager.close();
			
		} catch(NoResultException nre){
			throw new FunctionnalException("Aucune question quotidienne n'a été crééé.");
		} 
		
		return questionList;
	}
	
	public  Question selectDailyQuestion() throws FunctionnalException {
		
		Question question = null;
		
		try{
			
			EntityManagerFactory emfactory = getEmfactory();
			
			EntityManager entitymanager = emfactory.createEntityManager();
			
			Query query = entitymanager.createQuery("Select q from Question q where q.dailyQuestion='1'");
			
			question = (Question) query.getSingleResult();
			
			entitymanager.close();
			
		} catch(NoResultException nre){
			throw new FunctionnalException("Aucune question quotidienne n'a été crééé.");
		} catch(NonUniqueResultException nre){
			throw new FunctionnalException("Il existe plusieurs questions quotidienne, il ne devrait il y en avoir qu'une seule.");
		}
		
		return question;
	}

	@Override
	public Question findObject(EntityManager entitymanager, int IdObjet) {
		Question questionUpdated = entitymanager.find(Question.class, IdObjet);
		return questionUpdated;
	}

	@Override
	public void updateObject(Question objectToUpdate, Question object) {
		objectToUpdate.setDailyQuestion(object.getDailyQuestion());
		objectToUpdate.setType(object.getType());
		objectToUpdate.setWording(object.getWording());
		objectToUpdate.setTotalResponseNumber(object.getTotalResponseNumber());
		
	}
}
