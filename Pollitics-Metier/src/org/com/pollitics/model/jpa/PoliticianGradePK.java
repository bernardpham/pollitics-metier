package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the politician_grade database table.
 * 
 */
@Embeddable
public class PoliticianGradePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_POLITICIAN", insertable=false, updatable=false)
	private int idPolitician;

	@Column(name="ID_USER", insertable=false, updatable=false)
	private int idUser;

	public PoliticianGradePK() {
	}
	public int getIdPolitician() {
		return this.idPolitician;
	}
	public void setIdPolitician(int idPolitician) {
		this.idPolitician = idPolitician;
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PoliticianGradePK)) {
			return false;
		}
		PoliticianGradePK castOther = (PoliticianGradePK)other;
		return 
			(this.idPolitician == castOther.idPolitician)
			&& (this.idUser == castOther.idUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPolitician;
		hash = hash * prime + this.idUser;
		
		return hash;
	}
}