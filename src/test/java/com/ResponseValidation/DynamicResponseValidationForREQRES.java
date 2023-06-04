package com.ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidationForREQRES {

	@Test
	public void validation() {
		baseURI = "https://reqres.in";
		String expdata = "Lindsay";boolean flag = false;
		
		Response res = when().get("/api/users?page=2");
		
		List<String> names =res.jsonPath().get("data.first_name");
		
		for (String name : names) {
			if(name.equalsIgnoreCase(expdata))
			{
				flag = true;
			}
		}
		
		Assert.assertTrue(flag);
		res.then().log().all();
	}
}
