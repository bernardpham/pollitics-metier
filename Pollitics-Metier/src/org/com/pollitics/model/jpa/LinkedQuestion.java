package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the linked_question database table.
 * 
 */
@Entity
@Table(name="linked_question")
@NamedQuery(name="LinkedQuestion.findAll", query="SELECT l FROM LinkedQuestion l")
public class LinkedQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LinkedQuestionPK id;

	public LinkedQuestion() {
	}

	public LinkedQuestionPK getId() {
		return this.id;
	}

	public void setId(LinkedQuestionPK id) {
		this.id = id;
	}

}