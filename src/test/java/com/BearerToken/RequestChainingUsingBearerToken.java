package com.BearerToken;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChainingUsingBearerToken {

	@Test
	public void getNDeleteRepo() {
	
		baseURI = "https://api.github.com";
		String expdata = "demorepo";
		
		Response res = given()
		.pathParam("username", "messisunil")
		
		.when()
		.get("/users/{username}/repos");
		
		List<String> repos = res.jsonPath().get("name");
		String  repo = "";
		
		for (String eachrepo : repos) {
			if(eachrepo.equalsIgnoreCase(expdata))
			{
				repo = eachrepo;
			}
		}
		
		given()
		.auth().oauth2("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")
		.pathParam("repo", repo)
		.pathParam("owner", "messisunil")
		
		.when()
		.delete("/repos/{owner}/{repo}")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}
	
}
