package com.ResponseTypeObjectORArray;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class RMGYantra {

	@Test
	public void test()
	{
		baseURI = "http://rmgtestingserver";port = 8084;
		
		Response res = given().pathParam("projects", "projects")
		
		.when().get("{projects}/TY_PROJ_6466");
		
		 res.then().assertThat().body("",Matchers.instanceOf(Map.class)).log().all();
		
	}
}
