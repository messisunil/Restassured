package com.FRAMEWORK;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.GenericLibraries.APIBaseClass;
import com.GenericLibraries.Endpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequestusingGUI extends APIBaseClass{

	@Test
	public void postrequest() {
		//Create project using GUI
		hPage.clickProjectsTab();
		dPage.clickCreateProject();
		cpPage.createProject("mission"+javalib.randomNumber(1000), "sun", webLib, "Completed");
		String pname = cpPage.getProjectName();
		String projectid =dPage.getProjectId(driver, pname);
		
		//validate project using API
		Response res = given().spec(restLib.requestBuilder()).pathParam("pid", projectid)		
		.when().get(Endpoints.getSingleProject);
		String pid=restLib.getProjectId(res, "projectId");
		Assert.assertEquals(projectid, pid);
		
		//validate project using Database
		String status = jlib.validateProject("select * from project", pid);
		System.out.println(status);
	}
}
