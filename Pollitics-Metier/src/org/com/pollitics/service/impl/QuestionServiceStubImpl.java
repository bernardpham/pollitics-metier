package org.com.pollitics.service.impl;

public class QuestionServiceStubImpl { 
//implements IQuestionService {
//
//	@Override
//	public Response getDailyQuestion() {
//
//		List<ResponsePoll> listeResponse = getResponseList();
//		
//		Question question = new Question();
//		question.setIdQuestion(1L);
//		question.setQuestionType(QuestionType.ECONOMIE);
//		question.setQuestionWording("Que pensez vous du bilan de Christiane Taubira ?");
//		question.setTotalResponseNumber(4596);
//		question.setIdLinkedQuestion(null);
//		question.setResponseList(listeResponse);
//		
//		return Response.ok(question).build();
//	}
//
//	@Override
//	public Response getQuestionList() {
//		
//		List<Question> listeQuestion = new ArrayList<Question>();
//		List<ResponsePoll> listeResponse = getResponseList();
//		
//		Question question = new Question();
//		question.setIdQuestion(4L);
//		question.setQuestionType(QuestionType.ECONOMIE);
//		question.setQuestionWording("Que pensez vous du bilan de Christiane Taubira ?");
//		question.setTotalResponseNumber(4596);
//		question.setIdLinkedQuestion(null);
//		question.setResponseList(listeResponse);
//		
//		Question question2 = new Question();
//		question2.setIdQuestion(2L);
//		question2.setQuestionType(QuestionType.ECONOMIE);
//		question2.setQuestionWording("Que pensez vous du bilan de François Hollande ?");
//		question2.setTotalResponseNumber(4596);
//		question2.setIdLinkedQuestion(null);
//		question.setResponseList(listeResponse);
//		
//		Question question3 = new Question();
//		question3.setIdQuestion(3L);
//		question3.setQuestionType(QuestionType.ECONOMIE);
//		question3.setQuestionWording("Que pensez vous du bilan de Nicolas Sarkozy ?");
//		question3.setTotalResponseNumber(4596);
//		question3.setIdLinkedQuestion(null);
//		question3.setResponseList(listeResponse);
//		
//		listeQuestion.add(question);
//		listeQuestion.add(question2);
//		listeQuestion.add(question3);
//		
//		return Response.ok(listeQuestion).build();
//	}
//
//	private List<ResponsePoll> getResponseList() {
//		List<ResponsePoll> listeResponse = new ArrayList<ResponsePoll>();
//		ResponsePoll reponse1 =  new ResponsePoll();
//		reponse1.setResponseWording("Très satisfaisant");
//		reponse1.setTotalResponseNumber(10000);
//
//		ResponsePoll reponse2 =  new ResponsePoll();
//		reponse2.setResponseWording("Satisfaisant");
//		reponse2.setTotalResponseNumber(5000);
//		
//		ResponsePoll reponse3 =  new ResponsePoll();
//		reponse3.setResponseWording("Pas très satisfaisant");
//		reponse3.setTotalResponseNumber(7000);
//		
//		ResponsePoll reponse4 =  new ResponsePoll();
//		reponse4.setResponseWording("Pas satisfaisant");
//		reponse4.setTotalResponseNumber(9000);
//		
//		listeResponse.add(reponse1);
//		listeResponse.add(reponse2);
//		listeResponse.add(reponse3);
//		listeResponse.add(reponse4);
//		
//		return listeResponse;
//	}
//
//	@Override
//	public Response getQuestionListFromIdPolitician(Long idPolitician) {
//		
//		Question question = new Question();
//		List<ResponsePoll> listeResponse = getResponseList();
//		
//		if(idPolitician == 1){
//			question.setIdQuestion(1L);
//			question.setQuestionType(QuestionType.ECONOMIE);
//			question.setQuestionWording("Que pensez vous du bilan de Jacques Chirac ?");
//			question.setTotalResponseNumber(4596);
//			question.setIdLinkedQuestion(null);
//			question.setResponseList(listeResponse);
//		} else if (idPolitician == 2){
//			question.setIdQuestion(1L);
//			question.setQuestionType(QuestionType.ECONOMIE);
//			question.setQuestionWording("Que pensez vous du bilan de François Hollande ?");
//			question.setTotalResponseNumber(45976);
//			question.setIdLinkedQuestion(null);
//			question.setResponseList(listeResponse);
//		} else if (idPolitician == 3){
//			question.setIdQuestion(1L);
//			question.setQuestionType(QuestionType.ECONOMIE);
//			question.setQuestionWording("Que pensez vous du bilan de Nicolas Sarkozy ?");
//			question.setTotalResponseNumber(4896);
//			question.setIdLinkedQuestion(null);
//			question.setResponseList(listeResponse);
//		} else if (idPolitician == 4){
//			question.setIdQuestion(1L);
//			question.setQuestionType(QuestionType.ECONOMIE);
//			question.setQuestionWording("Que pensez vous du bilan de Christiane Taubira ?");
//			question.setTotalResponseNumber(566);
//			question.setIdLinkedQuestion(null);
//			question.setResponseList(listeResponse);
//		} else {
//			return Response.status(Response.Status.BAD_REQUEST).build();
//		}	
//		return Response.ok(question).build();
//	}
//
//	@Override
//	public Response createQuestion() {
//		
//		
//		List<Question> listeQuestion = new ArrayList<Question>();
//		List<ResponsePoll> listeResponse = getResponseList();
//		
//		Question question = new Question();
//		question.setIdQuestion(4L);
//		question.setQuestionType(QuestionType.ECONOMIE);
//		question.setQuestionWording("Que pensez vous du bilan de Christiane Taubira ?");
//		question.setTotalResponseNumber(4596);
//		question.setIdLinkedQuestion(null);
//		question.setResponseList(listeResponse);
//		
//		Question question2 = new Question();
//		question2.setIdQuestion(2L);
//		question2.setQuestionType(QuestionType.ECONOMIE);
//		question2.setQuestionWording("Que pensez vous du bilan de François Hollande ?");
//		question2.setTotalResponseNumber(4596);
//		question2.setIdLinkedQuestion(null);
//		question.setResponseList(listeResponse);
//		
//		Question question3 = new Question();
//		question3.setIdQuestion(3L);
//		question3.setQuestionType(QuestionType.ECONOMIE);
//		question3.setQuestionWording("Que pensez vous du bilan de Nicolas Sarkozy ?");
//		question3.setTotalResponseNumber(4596);
//		question3.setIdLinkedQuestion(null);
//		question3.setResponseList(listeResponse);
//		
//		listeQuestion.add(question);
//		listeQuestion.add(question2);
//		listeQuestion.add(question3);
//		
//		QuestionDAO.createQuestionList(listeQuestion);
//		
//		return Response.ok(question).build();
//	}
//
//	@Override
//	public Response saveUserResponse(Long idUser, Long idQuestion, Long idResponse) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Response updateQuestion() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Response createResponse() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Response updateResponse() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
