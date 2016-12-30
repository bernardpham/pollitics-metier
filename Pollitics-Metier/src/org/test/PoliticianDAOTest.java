package org.test;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.com.pollitics.model.jpa.Politician;
import org.com.pollitics.service.dao.PoliticianDAO;

import junit.framework.TestCase;

public class PoliticianDAOTest extends TestCase {

	private static final Logger logger = Logger.getLogger(PoliticianDAOTest.class);
		
	public void testCreatePoliliticianTest(){
		
		try{
			String firstName = "create_pol_FirstName_" + Math.random();
			String lastName = "create_pol_LastName_" + Math.random();
			String politicalParty = "create_pol_PoliticalParty_" + Math.random();
			String profilePictureUrl = "create_pol_ProfilePicture_" + Math.random();
			
			Politician politicianToCreate =  new Politician();
			
			politicianToCreate.setFirstName(firstName);
			politicianToCreate.setLastName(lastName);
			politicianToCreate.setParty(politicalParty);
			politicianToCreate.setProfilePicture(profilePictureUrl);
			
			/** Test de la création d'un politicien **/
//			PoliticianDAO.getInstance().createPolitician(politicianToCreate);
			PoliticianDAO.getInstance().createObject(politicianToCreate);
		}catch(Exception e){
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}
	}
	
	public void testUpdatePoliliticianTest(){
		
		try{
			
			String prefixe = "update_pol";
			
			String firstName = prefixe + "_FirstName_" + Math.random();
			String lastName = prefixe + "_LastName_" + Math.random();
			String politicalParty = prefixe + "_PoliticalParty_" + Math.random();
			String profilePictureUrl = prefixe + "_ProfilePicture_" + Math.random();
			
			Politician politicianToCreate =  new Politician();
			
			politicianToCreate.setFirstName(firstName);
			politicianToCreate.setLastName(lastName);
			politicianToCreate.setParty(politicalParty);
			politicianToCreate.setProfilePicture(profilePictureUrl);
			
			/** Test de la création d'un politicien **/
//			PoliticianDAO.getInstance().createPolitician(politicianToCreate);
			PoliticianDAO.getInstance().createObject(politicianToCreate);
			
			/** Test de l'update d'un politicien **/
			String prefixe_update = "update_bis";
			
			firstName = prefixe_update + "_FirstName_" + Math.random();
			lastName = prefixe_update + "_LastName_" + Math.random();
			politicalParty = prefixe_update + "_PoliticalParty_" + Math.random();
			profilePictureUrl = prefixe_update + "_ProfilePicture_" + Math.random();
			
			politicianToCreate.setFirstName(firstName);
			politicianToCreate.setLastName(lastName);
			politicianToCreate.setParty(politicalParty);
			politicianToCreate.setProfilePicture(profilePictureUrl);
			
//			PoliticianDAO.getInstance().updatePolitician(politicianToCreate);
			PoliticianDAO.getInstance().updateObjectById(politicianToCreate.getIdPolitician(), politicianToCreate);
			
			Politician politicianFromDb = PoliticianDAO.getInstance().findObject(politicianToCreate.getIdPolitician());
			
			assertNotNull(politicianFromDb);
			assertEquals(firstName, politicianFromDb.getFirstName());
			assertEquals(lastName, politicianFromDb.getLastName());
			assertEquals(politicalParty, politicianFromDb.getParty());
			assertEquals(profilePictureUrl, politicianFromDb.getProfilePicture());
			
		}catch(Exception e){
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}
	}
	
	public void testPoliliticianListTest(){
		
		String firstName = "getAllTest_FirstName_" + Math.random();
		String lastName = "getAllTest_LastName_" + Math.random();
		String politicalParty = "getAllTest_PoliticalParty_" + Math.random();
		String profilePictureUrl = "getAllTest_ProfilePicture_" + Math.random();
		
		Politician politicianToCreate =  new Politician();
		
		politicianToCreate.setFirstName(firstName);
		politicianToCreate.setLastName(lastName);
		politicianToCreate.setParty(politicalParty);
		politicianToCreate.setProfilePicture(profilePictureUrl);
		
		/** Test de la création d'un politicien **/
		PoliticianDAO.getInstance().createPolitician(politicianToCreate);
		
		List<Politician> politicians = PoliticianDAO.getInstance().getAllPolitician();

		assertNotNull(politicians);
		assertFalse(politicians.isEmpty());
	}
	
	public void testSelectPoliticianTest(){
		
		try{
			String firstName = "SelectTest_FirstName_" + Math.random();
			String lastName = "SelectTest_LastName_" + Math.random();
			String politicalParty = "SelectTest_PoliticalParty_" + Math.random();
			String profilePictureUrl = "SelectTest_ProfilePicture_" + Math.random();
			
			Politician politicianToCreate =  new Politician();
			
			politicianToCreate.setFirstName(firstName);
			politicianToCreate.setLastName(lastName);
			politicianToCreate.setParty(politicalParty);
			politicianToCreate.setProfilePicture(profilePictureUrl);
			
			/** Test de la création d'un politicien **/
			PoliticianDAO.getInstance().createPolitician(politicianToCreate);
			
			/** Test de la recherche de politicien par ID **/
			Politician politicianCreated = PoliticianDAO.getInstance().getPoliticianFromId(politicianToCreate.getIdPolitician()); 
			
			assertNotNull(politicianCreated);
			assertEquals(firstName, politicianCreated.getFirstName());
			assertEquals(lastName, politicianCreated.getLastName());
			assertEquals(politicalParty, politicianCreated.getParty());
			assertEquals(profilePictureUrl, politicianCreated.getProfilePicture());
			
			/** Test de la recherche de politicien par prenom/nom/parti**/
			List<Politician> listPolitician = 
					PoliticianDAO.getInstance().getPoliticianListFromFirstNameOrLastNameOrParty(firstName, lastName, politicalParty); 
			
			assertNotNull(listPolitician);
			assertFalse(listPolitician.isEmpty());
			
			Politician politicianFromList = listPolitician.get(0);
			assertEquals(firstName, politicianFromList.getFirstName());
			assertEquals(lastName, politicianFromList.getLastName());
			assertEquals(politicalParty, politicianFromList.getParty());
			assertEquals(profilePictureUrl, politicianFromList.getProfilePicture());
			
			/** Test de la recherche de politicien par prenom**/
			List<Politician> listPoliticianByFirstName = 
					PoliticianDAO.getInstance().getPoliticianListFromFirstNameOrLastNameOrParty(firstName, null, null); 
			
			assertNotNull(listPoliticianByFirstName);
			assertFalse(listPoliticianByFirstName.isEmpty());
			
			Politician politicianFromListByFirstName = listPoliticianByFirstName.get(0);
			assertEquals(firstName, politicianFromListByFirstName.getFirstName());
			assertEquals(lastName, politicianFromListByFirstName.getLastName());
			assertEquals(politicalParty, politicianFromListByFirstName.getParty());
			assertEquals(profilePictureUrl, politicianFromListByFirstName.getProfilePicture());
			
			/** Test de la recherche de politicien par prenom**/
			List<Politician> listPoliticianByLastName = 
					PoliticianDAO.getInstance().getPoliticianListFromFirstNameOrLastNameOrParty(null, lastName, null); 
			
			assertNotNull(listPoliticianByLastName);
			assertFalse(listPoliticianByLastName.isEmpty());
			
			Politician politicianFromListByLastName = listPoliticianByLastName.get(0);
			assertEquals(firstName, politicianFromListByLastName.getFirstName());
			assertEquals(lastName, politicianFromListByLastName.getLastName());
			assertEquals(politicalParty, politicianFromListByLastName.getParty());
			assertEquals(profilePictureUrl, politicianFromListByLastName.getProfilePicture());
			
		}catch(Exception e){
			assertFalse(e.getMessage(), true);
		}
	}
}
