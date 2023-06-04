package com.Parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathParameterForDelete {

	@Test
	public void deleteRequest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.pathParam("pid", "TY_PROJ_3638")
		
		.when()
		.delete("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
