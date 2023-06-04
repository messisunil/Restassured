package com.CRUDopsWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ReqResPost {

	@Test
	public void reqRes() {
		
		baseURI = "https://reqres.in";
		
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus789");
		obj.put("job", "leader");
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/api/users")

		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS)
		.log().all();
		
	}
}

