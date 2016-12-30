package org.com.pollitics.model;

import java.util.Date;
import java.util.List;

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
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USER")
	private long idUser;
	
	private String login;
	
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	@Transient
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="UPDATED_DATE")
	private Date updateDate;
	
	@Transient
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<PoliticianGrade> politicianGradeList;
	
	@OneToMany(mappedBy="user")
	private List<UserResponse> userResponseList;

	/**
	 * @return the idUser
	 */
	public long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the politicianGradeList
	 */
	public List<PoliticianGrade> getPoliticianGradeList() {
		return politicianGradeList;
	}

	/**
	 * @param politicianGradeList the politicianGradeList to set
	 */
	public void setPoliticianGradeList(List<PoliticianGrade> politicianGradeList) {
		this.politicianGradeList = politicianGradeList;
	}

	/**
	 * @return the userResponseList
	 */
	public List<UserResponse> getUserResponseList() {
		return userResponseList;
	}

	/**
	 * @param userResponseList the userResponseList to set
	 */
	public void setUserResponseList(List<UserResponse> userResponseList) {
		this.userResponseList = userResponseList;
	}

	
	
}
