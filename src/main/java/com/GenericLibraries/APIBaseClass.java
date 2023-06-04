package com.GenericLibraries;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.PomClasses.CreateProjectPage;
import com.PomClasses.DashboardPage;
import com.PomClasses.HomePage;
import com.PomClasses.SignInPage;

public class APIBaseClass {

	protected JDBCLibraries jlib;
	protected JavaLibraries javalib;
	protected RestassuredLibraries restLib;
	protected WebDriverLibraries webLib;
	protected WebDriver driver;
	protected CreateProjectPage cpPage ;
	protected DashboardPage dPage;
	protected HomePage hPage;
	protected SignInPage sPage;
	
	@BeforeSuite
	public void beforeSuiteSetup() {
		jlib = new JDBCLibraries();
		jlib.initializeDatabase();
		javalib = new JavaLibraries();
		restLib = new RestassuredLibraries();	
		webLib = new WebDriverLibraries();
		driver=webLib.launchTheBrowser("chrome");
	}
	
	@BeforeMethod
	public void beforeMethodSetup() {
		cpPage	= new CreateProjectPage(driver);
		dPage = new DashboardPage(driver);
		hPage = new HomePage(driver);
		sPage = new SignInPage(driver);
		webLib.navigateToApplication(IDatabaseConstants.URL);
		webLib.implicitWait();
		webLib.maximizeTheWindow();
		sPage.signInToApp("rmgyantra","rmgy@9999");
	}
	
	@AfterMethod
	public void afterMethodSetup() {
		dPage.clickLogout();
		webLib.closeTheBrowser();
	}
	
	@AfterSuite
	public void afterSuiteSetup() {
		jlib.closeDatabase();
	}
}

