package Steps;

import com.pages.DashboardPage;
import com.pages.Loginp;
import com.pages.Navigate;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import tests_.TestBaseCucumber;

import java.io.IOException;


public class NavigateSteps extends TestBaseCucumber {

    Loginp loginpobject;
    DashboardPage dashboardPageobject;
    Navigate navigate;


    public NavigateSteps() throws IOException {
    }

    @And("navigate to admin")
    public void navigate_to_admin()
    {
        Navigate navigate=new Navigate(driver);
        navigate.click_on_admin();
    }

    @And("navigate on user management to users")
    public void navigate_on_user_management_to_users() {
        Navigate navigate=new Navigate(driver);
        navigate.navigatetouserManagement();
        navigate.navigateToUsers();
    }



    @Then("users page open successfully")
    public void users_page_open_successfully()
    {
        Navigate navigate =new Navigate(driver);
        Assert.assertTrue(navigate.assertThatUserInUserPage());
        driver.quit();
    }
    }

