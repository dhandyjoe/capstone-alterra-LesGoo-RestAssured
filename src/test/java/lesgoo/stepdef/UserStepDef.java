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


}
