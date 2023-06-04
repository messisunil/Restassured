package com.CRUDopsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {

	@Test
	public void patchRequest() {
	JavaLibraries jlib = new JavaLibraries();
	JSONObject obj = new JSONObject();
	obj.put("name", "morpheus"+jlib.randomNumber(1000));
	obj.put("job","zion resident");
	
	RequestSpecification req = RestAssured.given();
	req.body(obj);
	req.contentType(ContentType.JSON);
	
	Response res = req.patch("https://reqres.in/api/users/2");
	res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
	Assert.assertTrue(res.getStatusLine().contains("OK"));
	}
	
	
	
}
