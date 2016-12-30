package org.com.pollitics.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.com.pollitics.constante.Constante;
import org.com.pollitics.exception.FunctionnalException;
import org.com.pollitics.model.jpa.User;
import org.com.pollitics.service.IUserService;
import org.com.pollitics.service.dao.UserDAO;

public class UserServiceImpl implements IUserService {

	private static final Logger logger = Logger.getLogger(QuestionServiceImpl.class);

	public User login(String login, String password) {
		if ("admin".equals(login) && "admin".equals(password)) {
			return new User();
		}

		return new User();
	}

	public User createUser(String login, String password, String lastName, String firstName, String email) throws FunctionnalException {
		logger.info("IN::createUser");
		User user = new User();

		String returnMessage = "";

		if (StringUtils.isEmpty(firstName)) {
			returnMessage = Constante.USER_FIRSTNAME_MANDATORY;
			throw new FunctionnalException(returnMessage);
		} else if (StringUtils.isEmpty(lastName)) {
			returnMessage = Constante.USER_LASTNAME_MANDATORY;
			throw new FunctionnalException(returnMessage);
		} else if (StringUtils.isEmpty(login)) {
			returnMessage = Constante.USER_LOGIN_MANDATORY;
			throw new FunctionnalException(returnMessage);
		} else if (StringUtils.isEmpty(email)) {
			returnMessage = Constante.USER_EMAIL_MANDATORY;
			throw new FunctionnalException(returnMessage);
		} else if (StringUtils.isEmpty(password)) {
			returnMessage = Constante.USER_PASSWORD_MANDATORY;
			throw new FunctionnalException(returnMessage);
		}

		List<User> users = UserDAO.getInstance().selectUserFromLogin(login);

		if (!users.isEmpty()) {
			returnMessage = Constante.USER_EXISTS_ALREADY;
			throw new FunctionnalException(returnMessage);
		}

		user.setLogin(login);
		user.setFirstName(firstName);
		user.setLastName(lastName);
//		user.setEmail(email);
		user.setCreationDate(new Timestamp(new Date().getTime()));
		user.setPassword(password);
		UserDAO.getInstance().createUser(user);

		returnMessage = Constante.USER_CREATION_SUCCESSUL;

		logger.info("OUT::createUser");
		return user;
	}
}
