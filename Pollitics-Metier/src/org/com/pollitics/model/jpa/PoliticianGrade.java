package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the politician_grade database table.
 * 
 */
@Entity
@Table(name="politician_grade")
@NamedQuery(name="PoliticianGrade.findAll", query="SELECT p FROM PoliticianGrade p")
public class PoliticianGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PoliticianGradePK id;

	@Column(name="CREATION_DATE")
	private Timestamp creationDate;

	private float value;

	//bi-directional many-to-one association to Politician
	@ManyToOne
	@JoinColumn(name="ID_POLITICIAN", insertable=false, updatable=false)
	private Politician politician;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ID_USER", insertable=false, updatable=false)
	private User user;

	public PoliticianGrade() {
	}

	public PoliticianGradePK getId() {
		return this.id;
	}

	public void setId(PoliticianGradePK id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Politician getPolitician() {
		return this.politician;
	}

	public void setPolitician(Politician politician) {
		this.politician = politician;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}