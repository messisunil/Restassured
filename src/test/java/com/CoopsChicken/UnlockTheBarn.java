package com.CoopsChicken;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UnlockTheBarn {

	@Test
	public void unlock() {
		baseURI = "http://coop.apps.symfonycasts.com";
		
		Response res = given()
		.formParam("client_id","suntechs")
		.formParam("client_secret","b21171fb9e8d779b90e531bf7f3f78ab")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri","http://suntechs.com")
		.formParam("code","authorization_code")
		
		.when()
		.post("/token");
		
		String accesstoken = res.jsonPath().get("access_token");
		
		res.then().statusCode(200);
		
		given()
		.auth().oauth2(accesstoken)
		.pathParam("user_id", 4506)
		
		.when()
		.post("/api/{user_id}/barn-unlock")
		
		.then()
		.statusCode(200).log().all();
	}
}
