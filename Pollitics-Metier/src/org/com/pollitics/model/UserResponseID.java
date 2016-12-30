package org.com.pollitics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class UserResponseID implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USER")
	private Long userID;
	
	@Column(name="ID_RESPONSE")
	private Long responseID;

	public UserResponseID(){
	}
	
	public UserResponseID(Long userID, Long questionID) {
		super();
		this.userID = userID;
		this.responseID = questionID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getResponseID() {
		return responseID;
	}

	public void setResponseID(Long responseID) {
		this.responseID = responseID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((responseID == null) ? 0 : responseID.hashCode());
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
		UserResponseID other = (UserResponseID) obj;
		if (responseID == null) {
			if (other.responseID != null)
				return false;
		} else if (!responseID.equals(other.responseID))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
}
