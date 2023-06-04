package com.requestSpecBuilderNResponseSpecB;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.POJOclassForRMG.AddProjectPojoClass;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RnRspecBuilderInRMG {

	@Test
	public void postt() {
		AddProjectPojoClass add = new AddProjectPojoClass("sun","moonsunn","planned",10);
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver").setContentType(ContentType.JSON).setPort(8084).build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON)
				.expectResponseTime(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).build();
		
		given()
		.spec(req).body(add).pathParam("addProject", "addProject")
		
		.when().post("/{addProject}")
		
		.then().spec(res).log().all();
		
		
	}
}
