package com.DifferentWaysOfPost;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJSONfile {

	@Test
	public void post() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		File file = new File(".\\src\\test\\resources\\data.json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l), TimeUnit.SECONDS)
		.log().all();
	}
}
