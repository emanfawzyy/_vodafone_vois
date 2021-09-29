package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginp extends PageBase {

	@FindBy(id = "txtUsername")
	WebElement txtUsername;
	@FindBy(id = "txtPassword")
	WebElement txtPassword;
	@FindBy(id = "btnLogin")
	WebElement btnLogin;

	@FindBy(id="spanMessage")
	WebElement errormsg;

	public Loginp(WebDriver driver) {
		super(driver);
	}

	public void enterLoginData(String UserName, String PassWord)
	{
		txtUsername.sendKeys(UserName);
		txtPassword.sendKeys(PassWord);
	}
	public void clickOnLogin()
	{
		btnLogin.click();
	}
	public boolean assertThatErrorMsg()
	{
		return errormsg.isDisplayed();
	}




}
