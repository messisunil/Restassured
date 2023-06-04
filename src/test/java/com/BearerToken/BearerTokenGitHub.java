package com.BearerToken;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class BearerTokenGitHub {

	@Test
	public void repocreation() {
		baseURI = "https://api.github.com";
		
		JSONObject obj = new JSONObject();
		obj.put("name", "demoRepo1");
		
		Response res = given()
		.auth().oauth2("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")
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/user/repos");
		
		String reponame = res.jsonPath().get("name");
		
		res.then().statusCode(201).contentType(ContentType.JSON).log().all();
		
		given()
		.auth().oauth2("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")
		.pathParam("name", reponame)
		.pathParam("owner", "messisunil")
		
		.when()
		.delete("/repos/{owner}/{name}")
		
		.then()
		.statusCode(204).log()
		.all();
	}
}
