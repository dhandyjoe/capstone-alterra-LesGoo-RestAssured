package lesgoo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import lesgoo.response.LesGooResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class UserStepDef {
    @Steps
    LesGooApi lesGooApi;

    @Given("Get user details")
    public void getUserDetails() {
        lesGooApi.getUserDetail();
    }

    @When("Send request user Details")
    public void SendRequestUserDetails(){
      SerenityRest.when().get(LesGooApi.USERS);
    }

    @When("Send request invalid user Details")
    public void SendRequestInvaildUserDetails(){
        SerenityRest.when().get(LesGooApi.USERS1);
    }

    @When("Send request not valid user Details")
    public void SendRequestNotVaildUserDetails(){
        SerenityRest.when().get(LesGooApi.USER);
    }
    @Given("Put update user with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile() {
        File jsonFiles = new File(LesGooApi.DIR+"/src/test/resources/Json/UpdateUser.json");
        LesGooApi.putUpdateUser(jsonFiles);
    }

    @When("Send request user Delete")
    public void SendRequestUserDelete(){
        SerenityRest.when().delete(LesGooApi.USERS);
    }

    @When("Send request invalid user Delete")
    public void SendRequestInvalidUserDelete(){
        SerenityRest.when().delete(LesGooApi.USERS1);
    }
    @When("Send request not valid user Delete")
    public void SendRequestNotValidUserDelete(){
        SerenityRest.when().delete(LesGooApi.USER);
    }
}
