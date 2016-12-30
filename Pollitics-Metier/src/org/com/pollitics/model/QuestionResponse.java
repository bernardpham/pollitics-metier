package org.com.pollitics.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//@Entity
//@Table(name="question_response")
public class QuestionResponse{

	@EmbeddedId
	private QuestionResponseID primaryKey;
	
	@ManyToOne
	@MapsId("idQuestion")
	@JoinColumn(name="ID_QUESTION")
	private Question question;
	
	@ManyToOne
	@MapsId("idResponse")
	@JoinColumn(name="ID_RESPONSE")
	private ResponsePoll responsePoll;

	
	@Column(name="NUMBER_RESPONSE")
	private int totalResponseNumber;


	public QuestionResponseID getPrimaryKey() {
		return primaryKey;
	}


	public void setPrimaryKey(QuestionResponseID primaryKey) {
		this.primaryKey = primaryKey;
	}

//
	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public ResponsePoll getResponsePoll() {
		return responsePoll;
	}


	public void setResponsePoll(ResponsePoll responsePoll) {
		this.responsePoll = responsePoll;
	}


	public int getTotalResponseNumber() {
		return totalResponseNumber;
	}


	public void setTotalResponseNumber(int totalResponseNumber) {
		this.totalResponseNumber = totalResponseNumber;
	}


}
