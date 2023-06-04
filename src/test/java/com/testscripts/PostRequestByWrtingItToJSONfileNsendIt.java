package com.testscripts;


import static io.restassured.RestAssured.*;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.POJOclassForRMG.AddProjectPojoClass;

import io.restassured.http.ContentType;

public class PostRequestByWrtingItToJSONfileNsendIt {

	@Test
	public void postreq() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		AddProjectPojoClass add = new AddProjectPojoClass("sun","missionKashmir","planned",5);
		
		ObjectMapper objm = new ObjectMapper();
		try {
			objm.writeValue(new File(".\\json\\combi.json"), add);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		given()
		.body(new File(".\\json\\combi.json"))
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000L),TimeUnit.SECONDS)
		.log().all();
		
	}
}
