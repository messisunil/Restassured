package com.PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy(id = "usernmae") private WebElement username;
	@FindBy(id = "inputPassword") private WebElement password;
	@FindBy(xpath = "//button[.='Sign in']") private WebElement signinButton;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signInToApp(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.signinButton.click();
	}
}
