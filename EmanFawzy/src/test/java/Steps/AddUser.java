package Steps;

import Data.JsonReader;
import com.pages.AddUserPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import tests_.TestBaseCucumber;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddUser extends TestBaseCucumber {
    AddUserPage addUseropject;

    public AddUser() throws IOException {
    }


    @And("click on add button")
    public void click_on_add_button() {
       addUseropject=new AddUserPage(driver);
        addUseropject.add_click();
    }

    @And("User Enter Data")
    public void User_Enter_Data() throws FileNotFoundException {
        JSONObject jsonObject = JsonReader.parseJson("Data\\data.json");

        String Ename=jsonObject.get("EmployeeName").toString();
        System.out.println(Ename);
        String UName=jsonObject.get("UserName").toString();
        System.out.println(UName);

        String Pass=jsonObject.get("Password").toString();
        System.out.println(Pass);

        String Confpass=jsonObject.get("ConfirmPassword").toString();
        System.out.println(Confpass);

        addUseropject=new AddUserPage(driver);
        addUseropject.AddNewUser(Ename,UName,Pass,Confpass);
        driver.quit();

    }

    @Then("user Click on save button")
    public void user_Click_on_save_button() {
        addUseropject.clickOnSave();
    }
}
