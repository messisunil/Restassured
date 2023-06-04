package com.DifferentWaysOfPost;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.http.ContentType;

public class UsingHashMap {

	@Test
	public void postrequest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		JavaLibraries jlib = new JavaLibraries();
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("createdBy", "sun");
		map.put("projectName", "mars"+jlib.randomNumber(1000));
		map.put("status", "planned");
		map.put("teamSize", 10);
		
		given()
		.body(map)
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
