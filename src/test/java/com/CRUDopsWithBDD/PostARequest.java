package com.CRUDopsWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.http.ContentType;



public class PostARequest {

	@Test
	public void postARequest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		//Step1 : adding prerequisites
		JavaLibraries jlib = new JavaLibraries();
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName","moonn"+jlib.randomNumber(1000));
		obj.put("status", "ongoing");
		obj.put("teamSize", 10);
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		//Step2 : performing actions
		.when()
		.post("/addProject")
		
		//Step3 : validations
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	}
}
