package org.com.pollitics.service.impl;

import java.util.List;

import org.com.pollitics.model.jpa.PoliticianGrade;
import org.com.pollitics.service.IRatingService;
import org.com.pollitics.service.dao.RatingDAO;

public class RatingServiceImpl implements IRatingService {

	public List<PoliticianGrade> getPoliticianGradeFromUserID(Long userID) {
		
		List<PoliticianGrade> politicianGrades = RatingDAO.getInstance().getPoliticianGradeFromUserId(userID);
		
		return politicianGrades;
	}

}
