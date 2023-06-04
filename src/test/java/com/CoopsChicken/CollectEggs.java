package com.CoopsChicken;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CollectEggs {

	@Test
	public void collectEggs() {
		baseURI = "http://coop.apps.symfonycasts.com";
 		Response res = given()
		.formParam("client_id","suntechs")
		.formParam("client_secret","b21171fb9e8d779b90e531bf7f3f78ab")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri","http://suntechs.com")
		.formParam("code","authorization_code")
		
		.when()
		.post("/token");

		res.then().log().all();
		String accesstoken = res.jsonPath().get("access_token");
		
		given()
		.auth().oauth2(accesstoken)
		.pathParam("user_id", 4506)
		
		.when()
		.post("/api/{user_id}/eggs-collect")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
}
