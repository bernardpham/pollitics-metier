package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the linked_question database table.
 * 
 */
@Embeddable
public class LinkedQuestionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_CURRENT_QUESTION")
	private int idCurrentQuestion;

	@Column(name="ID_LINKED_QUESTION")
	private int idLinkedQuestion;

	public LinkedQuestionPK() {
	}
	public int getIdCurrentQuestion() {
		return this.idCurrentQuestion;
	}
	public void setIdCurrentQuestion(int idCurrentQuestion) {
		this.idCurrentQuestion = idCurrentQuestion;
	}
	public int getIdLinkedQuestion() {
		return this.idLinkedQuestion;
	}
	public void setIdLinkedQuestion(int idLinkedQuestion) {
		this.idLinkedQuestion = idLinkedQuestion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LinkedQuestionPK)) {
			return false;
		}
		LinkedQuestionPK castOther = (LinkedQuestionPK)other;
		return 
			(this.idCurrentQuestion == castOther.idCurrentQuestion)
			&& (this.idLinkedQuestion == castOther.idLinkedQuestion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCurrentQuestion;
		hash = hash * prime + this.idLinkedQuestion;
		
		return hash;
	}
}