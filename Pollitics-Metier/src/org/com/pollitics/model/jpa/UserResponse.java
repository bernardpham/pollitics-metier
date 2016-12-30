package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_response database table.
 * 
 */
@Entity
@Table(name="user_response")
@NamedQuery(name="UserResponse.findAll", query="SELECT u FROM UserResponse u")
public class UserResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserResponsePK id;

	@Column(name="CREATION_DATE")
	private Timestamp creationDate;

	//bi-directional many-to-one association to Response
	@ManyToOne
	@JoinColumn(name="ID_RESPONSE", insertable=false, updatable=false)
	private Response response;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ID_USER", insertable=false, updatable=false)
	private User user;

	public UserResponse() {
	}

	public UserResponsePK getId() {
		return this.id;
	}

	public void setId(UserResponsePK id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Response getResponse() {
		return this.response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}