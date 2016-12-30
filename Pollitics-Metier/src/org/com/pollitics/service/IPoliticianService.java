package org.com.pollitics.service;

import java.util.List;

import org.com.pollitics.model.jpa.Politician;

public interface IPoliticianService {

	public Politician getPoliticianFromId(Integer idPolitician);

	public List<Politician> getPoliticianList(Integer userID, boolean randomList);

	public Politician getPoliticianFromNameOrParty(String lastName, String firstName, String party);

	public List<Politician> getPoliticianListService(Integer userID, boolean randomList);

	public Politician getPoliticianFromIdService(Integer idPolitician);
	
	public Politician createPolitician(String lastName, String firstName, String birthdate, String party);
}
