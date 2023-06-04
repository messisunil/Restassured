package com.CRUDopsWithBDD;


import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DeleteRequest {

	@Test
	public void deleteRequest() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.delete("/projects/TY_PROJ_5278")
		
		.then()
		.assertThat()
		.statusCode(204)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
