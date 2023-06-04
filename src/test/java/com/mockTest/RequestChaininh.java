package com.mockTest;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.GenericLibraries.JavaLibraries;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class RequestChaininh {

	@Test
	public void test() {
		
		JavaLibraries jlib = new JavaLibraries();
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName", "moonnn"+jlib.randomNumber(5000));
		obj.put("status", "ongoing");
		obj.put("teamSize", 10);
		
		baseURI = "http://rmgtestingserver";port = 8084;
		
		Response res = given().body(obj).contentType(ContentType.JSON)
		.when().post("/addProject");
		
		String pid=res.jsonPath().get("projectId");
		System.out.println(pid);
		
//		given().pathParam("pid", pid)
		
		when().get("/projects/"+pid)
		
		.then().assertThat().statusCode(200).contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS);
		
	}
	
	
}
