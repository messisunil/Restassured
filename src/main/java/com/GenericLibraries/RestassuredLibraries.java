package com.GenericLibraries;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;

import com.POJOclassForRMG.AddProjectPojoClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * This class consists of methods related to Restassured.
 * @author sunil
 *
 */
public class RestassuredLibraries {

	/**
	 * this method is used to get the project id
	 * @param response
	 * @param jsonPath
	 * @return
	 */
	public String getProjectId(Response response , String jsonPath) {
		return response.jsonPath().get(jsonPath);
	}
	/**
	 * this method is used to get request builder.
	 * @return
	 */
	public RequestSpecification requestBuilder()
	{
		return new RequestSpecBuilder().setBaseUri(IDatabaseConstants.baseURI).setPort(IDatabaseConstants.port)
				.setContentType(ContentType.JSON).build();
	}
	/**
	 * this method is used to get response builder.
	 * @param statusCode
	 * @return
	 */
	public ResponseSpecification responseBuilder(int statusCode) {
		return new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON)
		.expectResponseTime(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).build();
	}
	/**
	 * this method is used to get response builder for delete.
	 * @param statusCode
	 * @return
	 */
	public ResponseSpecification responseBuilderForDelete(int statusCode) {
		return new ResponseSpecBuilder().expectStatusCode(statusCode)
				.expectResponseTime(Matchers.lessThan(2000l),TimeUnit.MILLISECONDS).build();
	}
}
