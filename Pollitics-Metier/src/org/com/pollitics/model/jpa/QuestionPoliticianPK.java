package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the question_politician database table.
 * 
 */
@Embeddable
public class QuestionPoliticianPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_POLITICIAN")
	private int idPolitician;

	@Column(name="ID_QUESTION")
	private int idQuestion;

	public QuestionPoliticianPK() {
	}
	public int getIdPolitician() {
		return this.idPolitician;
	}
	public void setIdPolitician(int idPolitician) {
		this.idPolitician = idPolitician;
	}
	public int getIdQuestion() {
		return this.idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuestionPoliticianPK)) {
			return false;
		}
		QuestionPoliticianPK castOther = (QuestionPoliticianPK)other;
		return 
			(this.idPolitician == castOther.idPolitician)
			&& (this.idQuestion == castOther.idQuestion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPolitician;
		hash = hash * prime + this.idQuestion;
		
		return hash;
	}
}