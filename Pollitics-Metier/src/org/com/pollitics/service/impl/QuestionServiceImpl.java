package org.com.pollitics.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.com.pollitics.model.jpa.Question;
import org.com.pollitics.model.jpa.Response;
import org.com.pollitics.model.jpa.User;
import org.com.pollitics.model.jpa.UserResponse;
import org.com.pollitics.model.jpa.UserResponsePK;
import org.com.pollitics.service.IQuestionService;
import org.com.pollitics.service.dao.QuestionDAO;
import org.com.pollitics.service.dao.ResponseDAO;

public class QuestionServiceImpl implements IQuestionService {

	private static final Logger logger = Logger.getLogger(QuestionServiceImpl.class);

	public Question getDailyQuestion() {

		logger.info("IN::getDailyQuestion");
		Question question = null;

//		question = QuestionDAO.selectDailyQuestion();
//		List<QuestionResponse> questionResponses = QuestionDAO.selectResponseFromIDQuestion(question.getIdQuestion());

//		question.setResponseList(new ArrayList<QuestionResponse>());
//
//		for (QuestionResponse questionResponse : questionResponses) {
//			questionResponse.setQuestion(null);
//			question.getResponseList().add(questionResponse);
//
//		}

		logger.info("OUT::getDailyQuestion");
		return question;
	}

	public List<Question> getQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getQuestionListFromIdPolitician(Long idPolitician) {
		// TODO Auto-generated method stub
		return null;
	}

	public Question createQuestion(String wording, String questionType, Long idLinkedQuestion) {
		logger.info("IN::CreateQuestion");
		Question question = new Question();
		question.setType(questionType);
		question.setWording(wording);
		question.setTotalResponseNumber(0);
//		question.setIdLinkedQuestion(idLinkedQuestion);
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		question.setCreationDate(timestamp);

		QuestionDAO.getInstance().createQuestion(question);
		logger.info("OUT::CreateQuestion");
		return question;
	}

	public Boolean saveUserResponse(Integer idUser, Integer idQuestion, Integer idResponse) {
		logger.info("IN::saveUserResponse");

		String response = "";

		try {
			if (idUser == null) {
				response = "ID user est un paramètre obligatoire";
			} else if (idQuestion == null) {
				response = "ID question est un paramètre obligatoire";
			} else if (idResponse == null) {
				response = "ID response est un paramètre obligatoire";
			} else {
				Response responsePoll = new Response();
				responsePoll.setIdResponse(idResponse);

				User user = new User();
				user.setIdUser(idUser);

				UserResponse userResponse = new UserResponse();
				userResponse.setResponse(responsePoll);
				
				UserResponsePK primaryKey = new UserResponsePK();
				primaryKey.setIdUser(idUser);
				primaryKey.setIdResponse(idResponse);
				
				userResponse.setId(primaryKey);
//				userResponse.setQuestion(question);
				userResponse.setUser(user);
//				userResponse.setResponseID(idResponse);

				ResponseDAO.getInstance().saveUserResponse(userResponse);

				response = "La réponse a bien été enregistrée.";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			response = e.getMessage();
		}

		logger.info("OUT::saveUserResponse");
		return Boolean.valueOf(true);
	}

	public Question updateQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response createResponse(String wording) {
		logger.info("IN::createResponse");
//		ResponsePoll response = new ResponsePoll();
//
//		response.setResponseWording(wording);
//		QuestionDAO.createResponse(response);
		logger.info("OUT::createResponse");
//		return response;
		return null;
	}

	public Response updateResponse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveUserResponse(Long idUser, Long idQuestion, Long idResponse) {
		// TODO Auto-generated method stub
		return null;
	}
}