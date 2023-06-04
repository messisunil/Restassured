package com.Parameters;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PathparameterForPut {

	@Test
	public void put() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName", "sunmon123");
		obj.put("status", "planned");
		obj.put("teamSize", 10);
		
		given()
		.pathParam("pid", "TY_PROJ_3643")
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
	
}
