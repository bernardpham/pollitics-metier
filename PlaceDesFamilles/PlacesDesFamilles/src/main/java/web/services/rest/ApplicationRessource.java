package main.java.web.services.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class ApplicationRessource extends ResourceConfig {
	public ApplicationRessource() {
		System.out.println("MyApplication started!");

		// Turn on Jersery classpath scanning for providers and resources in the
		// given package directories
		packages("main.java");

		// Jackson JSON marshalling
		register(JacksonFeature.class);
	}
}
