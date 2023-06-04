package com.BearerToken;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class BearerTokensRMG {

	@Test
	public void loginApi() {
		baseURI = "http://rmgtestingserver";port = 8084;
		
		given()
		.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJybWd5YW50cmEiLCJleHAiOjE2ODM5MDQ2NjEsImlhdCI6MTY4Mzg2ODY2MX0.FXdBRtjvNaltxNY_84jGRIKG1BrA-mNZaMXbdAXL9Ok")
		
		.when()
		.get("/login")
		
		.then().assertThat().statusCode(202).log().all();
	
	}
}
