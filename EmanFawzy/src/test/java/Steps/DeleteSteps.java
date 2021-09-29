package Steps;

import com.pages.DeleteUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import tests_.TestBaseCucumber;

import java.io.IOException;

public class DeleteSteps extends TestBaseCucumber {
    DeleteUser deleteUserOpject;

    public DeleteSteps() throws IOException {
    }

    @And("Check on check box")
    public void Check_on_check_box(){
        deleteUserOpject=new DeleteUser(driver);
        deleteUserOpject.CheckonUser();
    }

    @And("Click on delete button")
    public void Click_on_delete_button(){
        deleteUserOpject.delete_user();
    }

    @Then("Click on ok button to delete")
    public void click_On_Ok_Button_To_Delete() {
        deleteUserOpject.ok_Button();
        driver.quit();
    }
}
