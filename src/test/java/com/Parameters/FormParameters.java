package com.Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;



//DONT RUN



public class FormParameters {

	@Test
	public void postRequest() {
		baseURI = "https://reqres.in";
		
		given()
		.formParam("name","morphenus")
		.formParam("job", "president")
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}
}
