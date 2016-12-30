package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_response database table.
 * 
 */
@Embeddable
public class UserResponsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_USER", insertable=false, updatable=false)
	private int idUser;

	@Column(name="ID_RESPONSE", insertable=false, updatable=false)
	private int idResponse;

	public UserResponsePK() {
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdResponse() {
		return this.idResponse;
	}
	public void setIdResponse(int idResponse) {
		this.idResponse = idResponse;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserResponsePK)) {
			return false;
		}
		UserResponsePK castOther = (UserResponsePK)other;
		return 
			(this.idUser == castOther.idUser)
			&& (this.idResponse == castOther.idResponse);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.idResponse;
		
		return hash;
	}
}