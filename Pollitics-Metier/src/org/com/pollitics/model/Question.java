package org.com.pollitics.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity
@Table(name="QUESTION")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_QUESTION")
	private long idQuestion;
	
	@Column(name="WORDING")
	private String questionWording;
	
	@Column(name="TOTAL_RESPONSE_NUMBER")
	private long totalResponseNumber;
	
	@Column(name="TYPE")
	private String questionType;
	
	@Column(name="CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Transient
	private Long idLinkedQuestion;
	
//	@OneToMany(mappedBy="question")
//	private List<QuestionResponse> responseList;

	@Column(name="DAILY_QUESTION")
	private boolean isDailyQuestion;
	
	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQuestionWording() {
		return questionWording;
	}

	public void setQuestionWording(String questionWording) {
		this.questionWording = questionWording;
	}

	public long getTotalResponseNumber() {
		return totalResponseNumber;
	}

	public void setTotalResponseNumber(long totalResponseNumber) {
		this.totalResponseNumber = totalResponseNumber;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getIdLinkedQuestion() {
		return idLinkedQuestion;
	}

	public void setIdLinkedQuestion(Long idLinkedQuestion) {
		this.idLinkedQuestion = idLinkedQuestion;
	}

//	public List<QuestionResponse> getResponseList() {
//		return responseList;
//	}
//
//	public void setResponseList(List<QuestionResponse> responseList) {
//		this.responseList = responseList;
//	}

	public boolean isDailyQuestion() {
		return isDailyQuestion;
	}

	public void setDailyQuestion(boolean isDailyQuestion) {
		this.isDailyQuestion = isDailyQuestion;
	}
	
}
