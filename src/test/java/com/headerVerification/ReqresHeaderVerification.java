package com.headerVerification;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class ReqresHeaderVerification {

	@Test
//	public void test() {
//		baseURI = "https://reqres.in";
//		
//		String expStatusLine = "HTTP/1.1 200 OK";
//		String expContentType = "application/json; charset=utf-8";
//		String expConnection = "keep-alive";
//		
//		Response res = when().get("/api/users/2");
//		ResponseBody body = res.body();
//		System.out.println(body.asPrettyString());
//		
//		Headers headers = res.getHeaders();
//		System.out.println(headers);
//		
//		String status = res.statusLine();
//		System.out.println(status);
//		Assert.assertEquals(status, expStatusLine);
//		
//		String contentType = res.getHeader("Content-Type");
//		System.out.println(contentType);
//		Assert.assertEquals(contentType, expContentType);
//		
//		String connection=res.getHeader("Connection");
//		System.out.println(connection);
//		Assert.assertEquals(connection, expConnection);
//	}
	
	public void m2() {
		Response res = when().get("https://www.programiz.com/java-programming/online-compiler/assets/icons/close.svg");
		String val=res.getHeader("Content-Type");
		System.out.println(val);
	}
}
