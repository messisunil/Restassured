package com.CRUDopsWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PutARequest {

	@Test
	public void putARequest() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JavaLibraries jlib = new JavaLibraries();
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName","moonn"+jlib.randomNumber(1000));
		obj.put("status", "ongoing");
		obj.put("teamSize", 10);
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("/projects/TY_PROJ_5278")
		
		.then()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
