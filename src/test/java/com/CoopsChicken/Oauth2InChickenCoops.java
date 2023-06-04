package com.CoopsChicken;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2InChickenCoops {

	@Test
	public void postdata() {
		baseURI = "http://coop.apps.symfonycasts.com";
		//to capture token
		Response res = given()
		.formParam("client_id", "suntechs")
		.formParam("client_secret", "b21171fb9e8d779b90e531bf7f3f78ab")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://suntechs.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("/token");
		
		res.then().log().all();
		
		String token  = res.jsonPath().get("access_token");
		System.out.println(token);
		
		//to get eggs count
		given()
		.auth().oauth2(token)
		.pathParam("user_id", 4506)
		
		
		.when()
		.post("/api/{user_id}/eggs-count")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}
}
