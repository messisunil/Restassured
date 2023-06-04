package com.DDT;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JavaLibrary.JavaLibraries;
import com.pojoClassForDDT.RMGYantraDDT;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DDTYantra {

	@DataProvider
	public Object[][] provider(){
		Object[][] obj = new Object[2][4];
		obj[0][0] = "sun";obj[0][1] = "missionmoon";obj[0][2] = "planned";obj[0][3] = 10;
		obj[1][0] = "sun";obj[1][1] = "missionmoon";obj[1][2] = "on going";obj[1][3] = 5;
		return obj;
	}
	
	@Test(dataProvider = "provider")
	public void writedata(String createdBy, String projectName , String status, int teamSize) {
		JavaLibraries util = new JavaLibraries();
		RMGYantraDDT rmg = new RMGYantraDDT(createdBy,projectName+util.randomNumber(500),status,teamSize );
		
		baseURI="http://rmgtestingserver";port = 8084;
		
		given()
		.body(rmg)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS)
		.log().all();
	}
}
