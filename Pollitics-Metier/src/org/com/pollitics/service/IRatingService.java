package org.com.pollitics.service;

import java.util.List;

import org.com.pollitics.model.jpa.PoliticianGrade;

public interface IRatingService {

////	@GET
////	@Produces({ MediaType.APPLICATION_JSON })
////	@Path("/createpoliticianrating")
//	public Response createPoliticianRating(@QueryParam("idPolitician") Long idPolitician,
//			@QueryParam("rating") BigDecimal rating);
//	
////	@GET
////	@Produces({ MediaType.APPLICATION_JSON })
////	@Path("/getuserspoliticianrating")
//	public Response getUsersPoliticianRating(@QueryParam("idPolitician") Long idPolitician,
//			@QueryParam("ïdUser") Long idUser);
//
////	@GET
////	@Produces({ MediaType.APPLICATION_JSON })
////	@Path("/getaveragepoliticianrating")
//	public Response getAveragePoliticianRating(@QueryParam("idPolitician") Long idPolitician);
//	
	public List<PoliticianGrade> getPoliticianGradeFromUserID(Long userID);
}
