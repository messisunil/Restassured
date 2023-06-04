package com.PomClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	@FindBy(xpath = "//tbody/tr/td[1]") private List<WebElement> projects;
	@FindBy(xpath = "//span[.='Create Project']") private WebElement createProject;
	@FindBy(xpath = "//a[.='Logout']") private WebElement logout;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this method is used to validate the project is present in the database or not.
	 * @param projects
	 * @param projectId
	 */
	public void validateProjectInGUI(String projectId) {
		boolean flag = false;
		for (WebElement element : projects) {
			if(element.getText().equalsIgnoreCase(projectId)) {
				flag = true;break;
			}
		}
		if(flag)
			System.out.println("verified in GUI");
		else
			System.out.println("project not visible in GUI");
	}
	
	public void clickCreateProject() {
		createProject.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public String getProjectId(WebDriver driver, String projectName)
	{
		return driver.findElement(By.xpath("//tbody/tr/td[.='"+projectName+"']/preceding-sibling::td")).getText();
	}
}
