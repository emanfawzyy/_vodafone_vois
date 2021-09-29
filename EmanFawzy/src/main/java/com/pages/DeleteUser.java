package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteUser extends PageBase {
    public DeleteUser(WebDriver driver) {
        super(driver);
    }


    @FindBy(name="chkSelectRow[]")
    WebElement Check;

    @FindBy(id="btnDelete")
    WebElement deleteButton;

    @FindBy(id="dialogDeleteBtn")
    WebElement okButton;

    public void CheckonUser(){
        Check.click();
    }
    public void delete_user()
    {
        deleteButton.click();
    }
    public void ok_Button(){okButton.click();}

}

