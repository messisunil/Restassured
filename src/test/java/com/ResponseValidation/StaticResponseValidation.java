package com.ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void getProjectId() {
		baseURI= "http://rmgtestingserver";
		port = 8084;
		String expData = "TY_PROJ_3632";
		
		Response res = when().get("/projects");
		
		String projectId = res.jsonPath().get("[1].projectId");
		Assert.assertEquals(projectId, expData);
		res.then().log().all();
		
	}
}
