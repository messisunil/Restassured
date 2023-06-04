package com.GenericLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class consists of all the methods related to WebDriver.
 * @author sunil
 *
 */
public class WebDriverLibraries {

	protected WebDriver driver;
	/**
	 * this method is used to select browser and launch the same browser.
	 * @param browser
	 * @return
	 */
	public WebDriver launchTheBrowser(String browser) {
		switch(browser)
		{
		case "chrome" : WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();break;
		case "firefox" : WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();break;
		case "edge" : WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();break;
		default : System.out.println("invalid browser");				
		}
		
		return driver;
	}
	/**
	 * this method is used for navigate to the application
	 * @param url
	 */
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	/**
	 * this method is used foe implicit wait.
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * this method is used for maximize the window
	 */
	public void maximizeTheWindow() {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used close the browser
	 */
	public void closeTheBrowser() {
		driver.quit();
	}
	/**
	 * this method is used to select the project status.
	 * @param element
	 * @param value
	 */
	public void selectProjectStatus(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
