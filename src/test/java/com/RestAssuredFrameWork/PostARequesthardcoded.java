package com.RestAssuredFrameWork;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericLibraries.APIBaseClass;
import com.GenericLibraries.Endpoints;
import com.GenericLibraries.IDatabaseConstants;
import com.GenericLibraries.StatusCodes;
import com.POJOclassForRMG.AddProjectPojoClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class PostARequesthardcoded extends APIBaseClass{

	@Test
	public void postRequest() {
		AddProjectPojoClass add = new AddProjectPojoClass("sun","missionsunn"+javalib.randomNumber(5000),"planned",10);
		
		Response res=given().spec(restLib.requestBuilder()).body(add)
		
		.when().post(Endpoints.addProject);
		
		String projectid = restLib.getProjectId(res, "projectId");
		
		res.then().spec(restLib.responseBuilder(StatusCodes.post)).log().all();
		
		String status=jlib.validateProject("select * from project", projectid);
		
		System.out.println(status);
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver:8084");
		driver.findElement(By.id("usernmae")).sendKeys(IDatabaseConstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(IDatabaseConstants.appPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projects=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		boolean flag = false;
		for (WebElement element : projects) {
			if(element.getText().equalsIgnoreCase(projectid)) {
				flag = true;break;
			}
		}
		if(flag)
			System.out.println("verified in GUI");
		else
			System.out.println("project not visible in GUI");
		driver.close();
		
			
	}
	
}
