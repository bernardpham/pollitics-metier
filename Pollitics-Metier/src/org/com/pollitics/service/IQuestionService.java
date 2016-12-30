package org.com.pollitics.service;

import java.util.List;

import org.com.pollitics.model.jpa.Question;
import org.com.pollitics.model.jpa.Response;

public interface IQuestionService {

	public Question getDailyQuestion();

	public List<Question> getQuestionList();

	public List<Question> getQuestionListFromIdPolitician(Long idPolitician);
	
	public Boolean saveUserResponse(Long idUser, Long idQuestion, Long idResponse);
	
	/**
	 * Partie Admin
	 */
	
	
	public Question createQuestion(String wording, String questionType, Long idLinkedQuestion);
	
	public Question updateQuestion();
	
	public Response createResponse(String wording);
	
	public Response updateResponse();
}
