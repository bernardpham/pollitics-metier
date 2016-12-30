package org.com.pollitics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//@Entity
@Table(name="RESPONSE")
public class ResponsePoll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_RESPONSE")
	private long idResponse;
	
	@Column(name="WORDING")
	private String responseWording;
	
	@ManyToOne
	@JoinColumn(name="ID_QUESTION")
	private Question question;
	
	public long getIdResponse() {
		return idResponse;
	}

	public void setIdResponse(long idResponse) {
		this.idResponse = idResponse;
	}

	public String getResponseWording() {
		return responseWording;
	}

	public void setResponseWording(String responseWording) {
		this.responseWording = responseWording;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
