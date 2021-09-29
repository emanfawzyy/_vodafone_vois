package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage extends PageBase {

	public AddUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "btnAdd")
	WebElement AddButton;

	@FindBy(id = "systemUser_userType")
	WebElement UserRole;

	@FindBy(id = "systemUser_employeeName_empName")
	WebElement EmployeeName;

	@FindBy(id = "systemUser_userName")
	WebElement UserName;

	@FindBy(id = "systemUser_status")
	WebElement Status;

	@FindBy(id = "systemUser_password")
	WebElement Password;

	@FindBy(id = "systemUser_confirmPassword")
	WebElement ConfirmPassword;

	@FindBy(id = "btnSave")
	WebElement SaveButton;


	public void add_click() {
		AddButton.click();
	}

	public void AddNewUser(String Ename, String userName, String pass, String confirmPassword) {

		Select userRole = new Select(UserRole);
		UserRole.click();
		userRole.selectByIndex(1);

		EmployeeName.sendKeys(Ename);
		UserName.sendKeys(userName);

		Select stat = new Select(Status);
		Status.click();
		stat.selectByIndex(1);

		Password.sendKeys(pass);
		ConfirmPassword.sendKeys(confirmPassword);
		SaveButton.click();
	}

	public void clickOnSave() {
		SaveButton.click();
	}

}
