package com.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLibraries.WebDriverLibraries;

public class CreateProjectPage {

	private String pName;
	@FindBy(name = "projectName") private WebElement projectName;
	@FindBy(name = "createdBy") private WebElement createdBy;
	@FindBy(name = "status") private WebElement status;
	@FindBy(xpath = "//input[@value='Add Project']") private WebElement addProject;
	//WebElement element = driver.findElement(By.xpath("//div[@role='alert']"))
	@FindBy(xpath = "//div[@role='alert']") private WebElement alert;
	
	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProjectName() {
		return pName;
	}
	public void createProject(String projectName, String createdBy, WebDriverLibraries webLib , String status) {
		pName = projectName;
		this.projectName.sendKeys(projectName);
		this.createdBy.sendKeys(createdBy);
		webLib.selectProjectStatus(this.status, status);
		this.addProject.click();
		webLib.explicitWait(alert);
		
	}
	
	
}
