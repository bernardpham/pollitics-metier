package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_USER")
	private int idUser;

	@Column(name="CREATION_DATE")
	private Timestamp creationDate;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String login;

	private String password;

	@Column(name="UPDATED_DATE")
	private Timestamp updatedDate;

	//bi-directional many-to-one association to PoliticianGrade
	@OneToMany(mappedBy="user")
	private List<PoliticianGrade> politicianGrades;

	//bi-directional many-to-one association to UserResponse
	@OneToMany(mappedBy="user")
	private List<UserResponse> userResponses;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<PoliticianGrade> getPoliticianGrades() {
		return this.politicianGrades;
	}

	public void setPoliticianGrades(List<PoliticianGrade> politicianGrades) {
		this.politicianGrades = politicianGrades;
	}

	public PoliticianGrade addPoliticianGrade(PoliticianGrade politicianGrade) {
		getPoliticianGrades().add(politicianGrade);
		politicianGrade.setUser(this);

		return politicianGrade;
	}

	public PoliticianGrade removePoliticianGrade(PoliticianGrade politicianGrade) {
		getPoliticianGrades().remove(politicianGrade);
		politicianGrade.setUser(null);

		return politicianGrade;
	}

	public List<UserResponse> getUserResponses() {
		return this.userResponses;
	}

	public void setUserResponses(List<UserResponse> userResponses) {
		this.userResponses = userResponses;
	}

	public UserResponse addUserRespons(UserResponse userRespons) {
		getUserResponses().add(userRespons);
		userRespons.setUser(this);

		return userRespons;
	}

	public UserResponse removeUserRespons(UserResponse userRespons) {
		getUserResponses().remove(userRespons);
		userRespons.setUser(null);

		return userRespons;
	}

}