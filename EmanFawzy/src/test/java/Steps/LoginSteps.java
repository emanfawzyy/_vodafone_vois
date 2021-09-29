package Steps;

import com.pages.DashboardPage;
import com.pages.Loginp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tests_.TestBaseCucumber;

import java.io.IOException;


public class LoginSteps extends TestBaseCucumber {

    Loginp loginpobject;
    DashboardPage dashboardPageobject;


    public LoginSteps() throws IOException {
    }

    @Given("the user in home page")
    public void the_user_in_home_page()
    {
        loginpobject=new Loginp(driver);
    }

    @When("Enter {string} and {string} and click on login button")
    public void Enter_and_and_click_on_login_button(String username , String password) {
        startdriver();
        loginpobject=new Loginp(driver);
        loginpobject.enterLoginData(username, password);
        loginpobject.clickOnLogin();
    }

    @Then("user successfully login")
    public void user_successfully_login()
    {
        dashboardPageobject=new DashboardPage(driver);
        Assert.assertTrue(dashboardPageobject.assertThatWelcomeMessageIsDisplayedOrNot());
        driver.quit();

    }

//    @Then("user failed login")
//    public void user_failed_login()
//    {
//        Loginp loginp=new Loginp(driver);
//        Assert.assertFalse(loginpobject.assertThatErrorMsg());
//
//    }
}
