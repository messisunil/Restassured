package com.CRUDopsWithBDD;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetASingleRequest {

	@Test
	public void getASingleRequest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.get("/projects/TY_PROJ_5278")
		
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
