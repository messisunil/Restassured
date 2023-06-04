package com.CRUDopsWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetAllProjects {

	@Test
	public void getProjects() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		when()
		.get("/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log()
		.all();
	}
}
