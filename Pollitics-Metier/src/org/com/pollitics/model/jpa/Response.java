package org.com.pollitics.model.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the response database table.
 * 
 */
@Entity
@NamedQuery(name="Response.findAll", query="SELECT r FROM Response r")
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RESPONSE")
	private int idResponse;

	@Column(name="ID_QUESTION")
	private int idQuestion;

	private String wording;

	//bi-directional many-to-one association to UserResponse
	@OneToMany(mappedBy="response")
	private List<UserResponse> userResponses;

	public Response() {
	}

	public int getIdResponse() {
		return this.idResponse;
	}

	public void setIdResponse(int idResponse) {
		this.idResponse = idResponse;
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getWording() {
		return this.wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public List<UserResponse> getUserResponses() {
		return this.userResponses;
	}

	public void setUserResponses(List<UserResponse> userResponses) {
		this.userResponses = userResponses;
	}

	public UserResponse addUserRespons(UserResponse userRespons) {
		getUserResponses().add(userRespons);
		userRespons.setResponse(this);

		return userRespons;
	}

	public UserResponse removeUserRespons(UserResponse userRespons) {
		getUserResponses().remove(userRespons);
		userRespons.setResponse(null);

		return userRespons;
	}

}