package dataMasking;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;

public class DataMaskingConfig {

	@Test
	public void dataMask() {
		
		RestAssured.given().config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type","Connection")))
		.when().get("http://rmgtestingserver:8084/projects/TY_PROJ_6466")
		.then().log().all();

	}
	
}
