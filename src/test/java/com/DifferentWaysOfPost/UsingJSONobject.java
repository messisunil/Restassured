package com.DifferentWaysOfPost;


import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.http.ContentType;

public class UsingJSONobject {

	@Test
	public void postreq(){
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		JavaLibraries jlib = new JavaLibraries();
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName", "mars"+jlib.randomNumber(1000));
		obj.put("status", "planned");
		obj.put("teamSize", 10);
		
		given()
		.body(obj)
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
