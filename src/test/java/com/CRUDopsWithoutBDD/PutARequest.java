package com.CRUDopsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutARequest {

	@Test
	public void putRequest() {
		JavaLibraries jlib = new JavaLibraries();
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName","moonn"+jlib.randomNumber(1000));
		obj.put("status", "ongoing");
		obj.put("teamSize", 10);
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_5041");
		
		System.out.println(response.prettyPeek());
		System.out.println(response.contentType());
		System.out.println(response.statusCode());
	}
}
