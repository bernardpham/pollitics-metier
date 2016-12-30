package org.com.pollitics.service.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.com.pollitics.model.jpa.PoliticianGrade;
import org.com.pollitics.model.jpa.Response;

public class RatingDAO extends AbstractDAO<PoliticianGrade> {

	private static RatingDAO instance;

	private RatingDAO() {

	}

	public static RatingDAO getInstance() {
		if (instance == null) {
			instance = new RatingDAO();
		}
		return instance;
	}

	public List<PoliticianGrade> getPoliticianGradeFromUserId(Long userID) {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("Select p from PoliticianGrade p where p.user.idUser = :idUser "); //where p.idUser ="+userID);
		query.setParameter("idUser", userID);

		List<PoliticianGrade> politicianGrades = query.getResultList();
		return politicianGrades;
	}
	
	public Map<Integer, PoliticianGrade> getPoliticianGradeMapFromUserId(Integer userID) {
		EntityManagerFactory emfactory = getEmfactory();

		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createQuery("Select p from PoliticianGrade p where p.user.idUser = :idUser "); //where p.idUser ="+userID);
		query.setParameter("idUser", userID);

		List<PoliticianGrade> politicianGrades = query.getResultList();
		
		Map<Integer, PoliticianGrade> mapGrades = new HashMap<Integer, PoliticianGrade>();
		
		for(PoliticianGrade grade : politicianGrades){
			mapGrades.put(grade.getId().getIdPolitician(), grade);
		}
		
		return mapGrades;
	}

	@Override
	public PoliticianGrade findObject(EntityManager entitymanager, int IdObjet) {
		PoliticianGrade object = entitymanager.find(PoliticianGrade.class, IdObjet);
		return object;
	}

	@Override
	public void updateObject(PoliticianGrade objectToUpdate, PoliticianGrade object) {
		objectToUpdate.setId(object.getId());
		objectToUpdate.setValue(object.getValue());
	}
	
}
