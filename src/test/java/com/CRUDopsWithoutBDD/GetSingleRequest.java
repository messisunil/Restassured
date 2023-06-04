package com.CRUDopsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleRequest {

	@Test
	
	public void getSingleReq() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_5071");
		response.then().log().all();
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
	}
}
