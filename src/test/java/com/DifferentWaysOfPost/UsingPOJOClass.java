package com.DifferentWaysOfPost;


import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.ObjectMapper;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.POJOclassForRMG.AddProjectPojoClass;

import io.restassured.http.ContentType;

public class UsingPOJOClass {

	@Test
	public void postRequest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		AddProjectPojoClass add = new AddProjectPojoClass("sun","missionmarss","planned",5);
		
		given()
		.body(add)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l),TimeUnit.SECONDS)
		.log().all();
		
	}
}
