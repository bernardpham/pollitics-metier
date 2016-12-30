package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the question_politician database table.
 * 
 */
@Entity
@Table(name="question_politician")
@NamedQuery(name="QuestionPolitician.findAll", query="SELECT q FROM QuestionPolitician q")
public class QuestionPolitician implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuestionPoliticianPK id;

	public QuestionPolitician() {
	}

	public QuestionPoliticianPK getId() {
		return this.id;
	}

	public void setId(QuestionPoliticianPK id) {
		this.id = id;
	}

}