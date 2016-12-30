package org.com.pollitics.service;

import org.com.pollitics.exception.FunctionnalException;
import org.com.pollitics.model.jpa.User;

public interface IUserService {

	public User login(String login, String password);

	public User createUser(String login, String password, String lastName,
			String firstName, String email) throws FunctionnalException;
}
