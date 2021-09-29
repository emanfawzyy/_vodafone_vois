package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigate extends PageBase {


	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement Admin;
	
	@FindBy(id="menu_admin_UserManagement")
	public WebElement UserManagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public WebElement Users;

	@FindBy(id = "search_form")
	public WebElement SuccessUserPage;

	public Navigate(WebDriver driver) {
		super(driver);
	}


	public void click_on_admin()
	{
		Admin.click();
	}


//	public void selectUsersmanagementthenUsersFromDropDownList()  {
//		Action.moveToElement(UserManagement).moveToElement(Users);
//	}
	public void navigateToUsers(){Users.click();}
	public void navigatetouserManagement(){UserManagement.click();}

	public boolean assertThatUserInUserPage()
	{
		return SuccessUserPage.isDisplayed();
	}

}
