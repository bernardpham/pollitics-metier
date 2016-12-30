package org.test;

import org.com.pollitics.model.jpa.Question;
import org.com.pollitics.model.jpa.Response;
import org.com.pollitics.model.jpa.User;
import org.com.pollitics.model.jpa.UserResponse;
import org.com.pollitics.model.jpa.UserResponsePK;
import org.com.pollitics.service.dao.QuestionDAO;
import org.com.pollitics.service.dao.ResponseDAO;

import junit.framework.TestCase;

public class ResponseDAOTest extends TestCase {

	public void testCreateResponsePoll(){
		
		try{
			
			Question question = new Question();
			question.setDailyQuestion("0");
			question.setType("JUNIT creation reponse test- type");
			question.setWording("JUNIT creation reponse test- libelle");
			
			QuestionDAO.getInstance().createQuestion(question);
			
			Response reponsePoll1 = new Response();
			reponsePoll1.setWording("Test reponse 1");
			reponsePoll1.setIdQuestion(question.getIdQuestion());
			
			Response reponsePoll2 = new Response();
			reponsePoll2.setWording("Test reponse 2");
			reponsePoll2.setIdQuestion(question.getIdQuestion());
			
			ResponseDAO.getInstance().createResponse(reponsePoll1);
			ResponseDAO.getInstance().createResponse(reponsePoll2);
			
			
		}catch (Exception e){
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}
	}
	
	public void testSaveUserResponse(){
		try{
			
			Question question = new Question();
			question.setIdQuestion(55);
			
//			QuestionDAO.getInstance().createQuestion(question);
			
			Response reponsePoll1 = new Response();
			reponsePoll1.setIdResponse(38);
			
//			ResponseDAO.getInstance().createResponse(reponsePoll1);
			
			User user = new User();
			user.setIdUser(3);
			user.setFirstName("JUNIT - Save user response test first name");
			user.setLastName("JUNIT - Save user response test last name");
			user.setLogin("JUNIT - Save user response test login");
			user.setPassword("JUNIT - Save user response test pass");
			
//			UserDAO.getInstance().createUser(user);
			
			UserResponsePK primaryKey = new UserResponsePK();
			primaryKey.setIdUser(user.getIdUser());
			primaryKey.setIdResponse(reponsePoll1.getIdResponse());
			
			UserResponse userResponse = new UserResponse();
			userResponse.setUser(user);
			userResponse.setResponse(reponsePoll1);
			userResponse.setId(primaryKey);
			
//			ResponseDAO.getInstance().saveUserResponse(userResponse);
			
		} catch(Exception e){
			e.printStackTrace();
			assertFalse(e.getMessage(), true);			
		}
	}
}
