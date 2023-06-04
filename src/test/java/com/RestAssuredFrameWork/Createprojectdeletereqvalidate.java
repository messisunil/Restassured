package com.RestAssuredFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericLibraries.APIBaseClass;
import com.GenericLibraries.Endpoints;
import com.GenericLibraries.IDatabaseConstants;

import io.github.bonigarcia.wdm.WebDriverManager;
import static io.restassured.RestAssured.*;

public class Createprojectdeletereqvalidate extends APIBaseClass{

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver:8084");
		driver.findElement(By.id("usernmae")).sendKeys(IDatabaseConstants.appUsername);
		driver.findElement(By.id("inputPassword")).sendKeys(IDatabaseConstants.appPassword);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String pname = "mission"+javalib.randomNumber(5000);
		driver.findElement(By.name("projectName")).sendKeys(pname);
		driver.findElement(By.name("createdBy")).sendKeys("sun");
		WebElement ele = driver.findElement(By.name("status"));
		Select sel = new Select(ele);
		sel.selectByValue("Completed");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		String projectid =	driver.findElement(By.xpath("//tbody/tr/td[.='"+pname+"']/preceding-sibling::td")).getText();
		System.out.println(projectid);
		driver.close();
		
		given().spec(restLib.requestBuilder()).pathParam("pid", projectid)
		.when().delete(Endpoints.deleteProject+"{pid}")
		.then().spec(restLib.responseBuilderForDelete(204)).log().all();
		
		String status = jlib.validateProject("select * from project", projectid);
		System.out.println(status);
		Assert.assertNotEquals(status, "verified");
		
		
	}
}
