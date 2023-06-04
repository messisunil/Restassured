package com.basicAuth;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SimpleBasicAuth {

	@Test
	public void loginApi() {
		baseURI = "http://rmgtestingserver";port = 8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then().assertThat().statusCode(202).log().all();
	
	}
}
