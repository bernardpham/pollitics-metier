package org.com.pollitics.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.com.pollitics.constante.Constante;
import org.com.pollitics.exception.FunctionnalException;
import org.com.pollitics.exception.TechnicalException;
import org.com.pollitics.model.jpa.Politician;
import org.com.pollitics.model.jpa.PoliticianGrade;
import org.com.pollitics.service.IPoliticianService;
import org.com.pollitics.service.IRatingService;
import org.com.pollitics.service.dao.PoliticianDAO;
import org.com.pollitics.service.dao.RatingDAO;
import org.com.pollitics.util.DateUtil;

public class PoliticianServiceImpl implements IPoliticianService {

	private static final Logger logger = Logger.getLogger(PoliticianServiceImpl.class);

	private IRatingService ratingService;
	
	public Politician getPoliticianFromId(Integer idPolitician) {
		logger.info("IN::getPoliticianFromId");

		Politician politician = PoliticianDAO.getInstance().getPoliticianFromId(idPolitician);

		logger.info("OUT::getPoliticianFromId");
		return politician;

	}

	public List<Politician> getPoliticianList(Integer userID, boolean random) {
		logger.info("IN::getPoliticianList");
		
		List<Politician> politicianList = PoliticianDAO.getInstance().getAllPolitician();
		
		logger.info("OUT::getPoliticianList");
		return politicianList;
	}

	public Politician getPoliticianFromNameOrParty(String lastName, String firstName, String party) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Politician> getPoliticianListService(Integer userID, boolean randomList) {
		logger.info("IN::getPoliticianListService");
		
		List<Politician> politicianList = PoliticianDAO.getInstance().getAllPolitician();
		Map<Integer, PoliticianGrade> politicianGrades = RatingDAO.getInstance().getPoliticianGradeMapFromUserId(userID);
		
		for(Politician politician: politicianList){
			
			PoliticianGrade grade = politicianGrades.get(politician.getIdPolitician());
			
			if(grade!=null){
				Set<PoliticianGrade> userPoliticianGrade = new HashSet<PoliticianGrade>();
				userPoliticianGrade.add(grade);
				politician.setPoliticianGrades(new ArrayList<PoliticianGrade>(userPoliticianGrade));
			}
		}
		
		if(randomList)
			Collections.shuffle(politicianList);
		
		logger.info("OUT::getPoliticianListService");
		
		return politicianList;
	}

	public Politician getPoliticianFromIdService(Integer idPolitician) {
		logger.info("IN::getPoliticianFromId");

		Politician politician = PoliticianDAO.getInstance().getPoliticianFromId(idPolitician);

		logger.info("OUT::getPoliticianFromId");
		return politician;
	}

	public Politician createPolitician(String lastName, String firstName, String birthdate, String party) {
		logger.info("IN::createPolitician");

		String returnMessage ="";
		Politician politician = null;
		
		try {
			
			if(StringUtils.isEmpty(firstName)){
				returnMessage = Constante.POLITICIAN_FIRSTNAME_MANDATORY;
				throw new FunctionnalException(returnMessage); 
			} else if(StringUtils.isEmpty(lastName)){
				returnMessage = Constante.POLITICIAN_LASTNAME_MANDATORY;
				throw new FunctionnalException(returnMessage);				
			} else if(StringUtils.isEmpty(birthdate)){
				returnMessage = Constante.POLITICIAN_BIRTHDATE_MANDATORY;
				throw new FunctionnalException(returnMessage);				
			}
			
			List<Politician> politicians = PoliticianDAO.getInstance().getPoliticianListFromFirstNameOrLastNameOrParty(firstName, lastName, null);
			if(!politicians.isEmpty()){
				returnMessage = Constante.POLITICIAN_EXISTS_ALREADY;
				throw new FunctionnalException(returnMessage);
			}
			
			politician = new Politician();
			politician.setLastName(lastName);
			politician.setFirstName(firstName);
			politician.setParty(party);

			Date birthDatePolitician = DateUtil.getDateFromString(birthdate);

			politician.setBirthDate(new Timestamp(birthDatePolitician.getTime()));

			PoliticianDAO.getInstance().createPolitician(politician);
			
			returnMessage = Constante.POLITICIAN_CREATION_SUCCESSUL;
			
		} catch (TechnicalException e) {
			logger.error(e.getMessage(), e);
			returnMessage = e.getMessage();
		} catch (FunctionnalException e) {
			logger.error(e.getMessage(), e);
			returnMessage = e.getMessage();
		}

		logger.info("OUT::createPolitician");
		return politician;
	}
}
