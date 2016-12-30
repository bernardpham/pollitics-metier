package org.com.pollitics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class QuestionResponseID  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ID_QUESTION")
	private Long idQuestion;
	
	@Column(name="ID_RESPONSE")
	private Long idResponse;

	public Long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public Long getIdResponse() {
		return idResponse;
	}

	public void setIdResponse(Long idResponse) {
		this.idResponse = idResponse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idQuestion == null) ? 0 : idQuestion.hashCode());
		result = prime * result + ((idResponse == null) ? 0 : idResponse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionResponseID other = (QuestionResponseID) obj;
		if (idQuestion == null) {
			if (other.idQuestion != null)
				return false;
		} else if (!idQuestion.equals(other.idQuestion))
			return false;
		if (idResponse == null) {
			if (other.idResponse != null)
				return false;
		} else if (!idResponse.equals(other.idResponse))
			return false;
		return true;
	}
}
