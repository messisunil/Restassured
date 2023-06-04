package com.FRAMEWORK;

import org.testng.annotations.Test;

import com.GenericLibraries.APIBaseClass;
import com.GenericLibraries.Endpoints;
import static io.restassured.RestAssured.*;

public class PostReqValidateInDBGetProjectDetails extends APIBaseClass{

	@Test
	public void test() {
		//create Project using GUI
		hPage.clickProjectsTab();
		dPage.clickCreateProject();
		cpPage.createProject("mission"+javalib.randomNumber(1000), "sun", webLib, "Completed");
		String pname = cpPage.getProjectName();
		String projectid =dPage.getProjectId(driver, pname);

		//validate project using Database
		String status = jlib.validateProject("select * from project", projectid);
		System.out.println(status);
		
		//get project details using API
		given().spec(restLib.requestBuilder()).pathParam("pid", projectid)		
		.when().get(Endpoints.getSingleProject)
		.then().spec(restLib.responseBuilder(200)).log().all();
		
	}
}
