package com.FRAMEWORK;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericLibraries.APIBaseClass;
import com.GenericLibraries.Endpoints;
import static io.restassured.RestAssured.*;

public class Createprojectdeletereqvalidate extends APIBaseClass{

	@Test
	public void test() {
		//create project using GUI
		hPage.clickProjectsTab();
		dPage.clickCreateProject();
		cpPage.createProject("mission"+javalib.randomNumber(1000), "sun", webLib, "Completed");
		String pname = cpPage.getProjectName();
		String projectid =dPage.getProjectId(driver, pname);

		//Delete project using API
		given().spec(restLib.requestBuilder()).pathParam("pid", projectid)
		.when().delete(Endpoints.deleteProject+"{pid}")
		.then().spec(restLib.responseBuilderForDelete(204)).log().all();
		
		//Validate project using database
		String status = jlib.validateProject("select * from project", projectid);
		System.out.println(status);
		Assert.assertNotEquals(status, "verified");
		
		
	}
}
