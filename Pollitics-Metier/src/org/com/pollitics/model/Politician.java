package org.com.pollitics.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//@Entity
@Table(name="politician")
public class Politician implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7880582833954330216L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_POLITICIAN")
	private Long idPolitician;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="PARTY")
	private String politicalParty;

	@Transient
	private AveragePoliticianGrade averagePoliticianGrade;

	@OneToMany(mappedBy="politician")
	private Set<PoliticianGrade> userPoliticianGrade;
	
	//TODO : ajouter insertion photo de profil
	@Transient
	private String profilePictureUrl;

	public Long getIdPolitician() {
		return idPolitician;
	}

	public void setIdPolitician(Long idPolitician) {
		this.idPolitician = idPolitician;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firtName) {
		this.firstName = firtName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	public AveragePoliticianGrade getAveragePoliticianGrade() {
		return averagePoliticianGrade;
	}

	public void setAveragePoliticianGrade(AveragePoliticianGrade averagePoliticianGrade) {
		this.averagePoliticianGrade = averagePoliticianGrade;
	}

	/**
	 * @return the profilePictureUrl
	 */
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	/**
	 * @param profilePictureUrl
	 *            the profilePictureUrl to set
	 */
	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPolitician == null) ? 0 : idPolitician.hashCode());
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
		Politician other = (Politician) obj;
		if (idPolitician == null) {
			if (other.idPolitician != null)
				return false;
		} else if (!idPolitician.equals(other.idPolitician))
			return false;
		return true;
	}

	public Set<PoliticianGrade> getUserPoliticianGrade() {
		return userPoliticianGrade;
	}

	public void setUserPoliticianGrade(Set<PoliticianGrade> userPoliticianGrade) {
		this.userPoliticianGrade = userPoliticianGrade;
	}

	@Override
	public String toString() {
		return "Politician [idPolitician=" + idPolitician + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", birthDate=" + birthDate + ", politicalParty=" + politicalParty + ", "
				+ profilePictureUrl + "]";
	}
}
