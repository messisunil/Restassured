package com.ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {

	@Test
	public void validation() {
		baseURI= "http://rmgtestingserver";
		port = 8084;
		String expData = "TY_PROJ_3632";
		boolean flag = false;
		
		Response res = when().get("/projects");
		
		List<String> ids=res.jsonPath().get("projectId");
		for (String id : ids) {
			if(id.equalsIgnoreCase(expData))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		res.then().log().all();
	}
}
