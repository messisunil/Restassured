package com.FRAMEWORK;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericLibraries.APIBaseClass;
import com.GenericLibraries.Endpoints;
import com.GenericLibraries.StatusCodes;
import com.POJOclassForRMG.AddProjectPojoClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class PostARequest extends APIBaseClass{

	@Test
	public void postRequest() {
		AddProjectPojoClass add = new AddProjectPojoClass("sun","missionsunn"+javalib.randomNumber(5000),"planned",10);
		
		Response res=given().spec(restLib.requestBuilder()).body(add)
		
		.when().post(Endpoints.addProject);
		
		String projectid = restLib.getProjectId(res, "projectId");
		
		res.then().spec(restLib.responseBuilder(StatusCodes.post)).log().all();
		
		String status=jlib.validateProject("select * from project", projectid);
		
		System.out.println(status);
		
		
		
			
	}
	
}
