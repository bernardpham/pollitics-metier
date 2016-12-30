package org.com.pollitics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class PoliticianGradeID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ID_POLITICIAN")
	private Long politicianID;
	@Column(name="ID_USER")
	private Long userID;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((politicianID == null) ? 0 : politicianID.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		PoliticianGradeID other = (PoliticianGradeID) obj;
		if (politicianID == null) {
			if (other.politicianID != null)
				return false;
		} else if (!politicianID.equals(other.politicianID))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	public Long getPoliticianID() {
		return politicianID;
	}
	public void setPoliticianID(Long politicianID) {
		this.politicianID = politicianID;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}

	
}
