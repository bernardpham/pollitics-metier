package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_QUESTION")
	private int idQuestion;

	@Column(name="CREATION_DATE")
	private Timestamp creationDate;

	@Column(name="DAILY_QUESTION")
	private String dailyQuestion;

	@Column(name="TOTAL_RESPONSE_NUMBER")
	private int totalResponseNumber;

	private String type;

	@Lob
	private String wording;

	public Question() {
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getDailyQuestion() {
		return this.dailyQuestion;
	}

	public void setDailyQuestion(String dailyQuestion) {
		this.dailyQuestion = dailyQuestion;
	}

	public int getTotalResponseNumber() {
		return this.totalResponseNumber;
	}

	public void setTotalResponseNumber(int totalResponseNumber) {
		this.totalResponseNumber = totalResponseNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

}