package com.CRUDopsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostARequest {

	@Test
	public void postRequest() {
		JavaLibraries jlib = new JavaLibraries();
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "sun");
		obj.put("projectName","moonn"+jlib.randomNumber(1000));
		obj.put("status", "ongoing");
		obj.put("teamSize", 10);
		
		 RequestSpecification req = RestAssured.given();
		 req.body(obj);
		 req.contentType(ContentType.JSON);
		 
		 Response response = req.post("http://rmgtestingserver:8084/addProject");
		 System.out.println(response.contentType());
		 System.out.println(response.getStatusCode());
		 System.out.println(response.prettyPeek());
	}
}
