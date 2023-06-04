package com.CRUDopsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

	@Test
	public void getRequest() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		System.out.println(response.prettyPeek());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		
	}
}
