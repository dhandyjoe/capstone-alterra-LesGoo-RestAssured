package lesgoo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import lesgoo.constants.Constants;
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

    @When("Send request user details")
    public void sendRequestUserDetails(){
      SerenityRest.when().get(LesGooApi.USERS);
    }

    @Given("Put update user with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile() {
        File jsonFiles = new File(Constants.JSON_BODY_REQ+"/users/updateuser.json");
        LesGooApi.putUpdateUser(jsonFiles);
    }

    @When("Send request user delete")
    public void sendRequestUserDelete(){
        SerenityRest.when().delete(LesGooApi.USERS);
    }

    @Given("Get user details without authorization")
    public void getUserDetailsWithInvalidBearerToken() {
        lesGooApi.getUserDetailWithoutAuthorization();
    }

    @Given("Delete users")
    public void deleteUsers() {
        lesGooApi.deleteUser();
    }
}
