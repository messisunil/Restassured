package com.CRUDopsWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteARequest {

	@Test
	public void deleteRequest() {
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_5041");
		
		response.then().log().all();
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, 204);
	}
}

