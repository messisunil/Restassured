
package com.RequestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.PojoClassForRequestChaining.RMGYantra;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class RMGYantraRequestingChaining {

	@Test
	public void requestChaining() {
		//to post a request
		RMGYantra yan = new RMGYantra("sun","moonsun321","ongoing",4);
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response res = given()
		.body(yan)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		String pid =res.jsonPath().get("projectId");
		System.out.println(pid);
		res
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS)
		.log().all();
		
		//to get the required project
		
		given()
		.pathParam("pid", pid)
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS)
		.log().all();
		
		//to delete the project
		given()
		.pathParam("pid", pid)
		
		.when()
		.delete("/projects/{pid}")
		
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
