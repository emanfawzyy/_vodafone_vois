package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends PageBase {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "welcome")
public WebElement welcome;

    public Boolean assertThatWelcomeMessageIsDisplayedOrNot(){
        return welcome.isDisplayed();
    }
}
