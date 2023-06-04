package com.requestSpecBuilderNResponseSpecB;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestNResponseSpecBuilder {

	@Test
	public void post() {
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");obj.put("job", "leader");
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.expectResponseTime(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).build();
		
		given().spec(req).body(obj)
		
		.when().post("/api/users")
		
		.then().spec(res).log().all();
	}
}
