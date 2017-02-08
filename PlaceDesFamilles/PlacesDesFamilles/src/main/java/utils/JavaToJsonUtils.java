package main.java.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.exception.ExceptionTechnique;


public class JavaToJsonUtils {

	public static String convertJavaToJson(Object object) throws ExceptionTechnique{
		String dataJson = "";

		ObjectMapper mapper = new ObjectMapper();
		
		try {
			dataJson = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new ExceptionTechnique(e);
		}
		
		return dataJson;
	}
}
