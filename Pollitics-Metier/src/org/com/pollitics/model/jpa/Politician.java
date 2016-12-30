package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the politician database table.
 * 
 */
@Entity
@NamedQuery(name="Politician.findAll", query="SELECT p FROM Politician p")
public class Politician implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_POLITICIAN")
	private int idPolitician;

	@Column(name="BIRTH_DATE")
	private Timestamp birthDate;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String party;

	@Column(name="PROFILE_PICTURE")
	private String profilePicture;

	//bi-directional many-to-one association to PoliticianGrade
	@OneToMany(mappedBy="politician")
	private List<PoliticianGrade> politicianGrades;

	public Politician() {
	}

	public int getIdPolitician() {
		return this.idPolitician;
	}

	public void setIdPolitician(int idPolitician) {
		this.idPolitician = idPolitician;
	}

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getParty() {
		return this.party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getProfilePicture() {
		return this.profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public List<PoliticianGrade> getPoliticianGrades() {
		return this.politicianGrades;
	}

	public void setPoliticianGrades(List<PoliticianGrade> politicianGrades) {
		this.politicianGrades = politicianGrades;
	}

	public PoliticianGrade addPoliticianGrade(PoliticianGrade politicianGrade) {
		getPoliticianGrades().add(politicianGrade);
		politicianGrade.setPolitician(this);

		return politicianGrade;
	}

	public PoliticianGrade removePoliticianGrade(PoliticianGrade politicianGrade) {
		getPoliticianGrades().remove(politicianGrade);
		politicianGrade.setPolitician(null);

		return politicianGrade;
	}

}