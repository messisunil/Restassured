package com.Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParameters {

	@Test
	public void getProject() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.pathParam("pid", "TY_PROJ_3632")
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
