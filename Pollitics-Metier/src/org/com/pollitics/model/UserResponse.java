package org.com.pollitics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
@Table(name="user_response")
public class UserResponse {

	@EmbeddedId
	private UserResponseID primaryKey;
	
	@ManyToOne
	@MapsId("responseID")
	@JoinColumn(name="ID_RESPONSE")
	private ResponsePoll response;
	
	@ManyToOne
	@MapsId("userID")
	@JoinColumn(name="ID_USER")
	private User user;
	
//	@Column(name="ID_RESPONSE")
//	private Long responseID;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;
	

	public UserResponseID getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(UserResponseID primaryKey) {
		this.primaryKey = primaryKey;
	}

//	public Question getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}

	public ResponsePoll getResponse() {
		return response;
	}

	public void setResponse(ResponsePoll response) {
		this.response = response;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Long getResponseID() {
//		return responseID;
//	}
//
//	public void setResponseID(Long responseID) {
//		this.responseID = responseID;
//	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
