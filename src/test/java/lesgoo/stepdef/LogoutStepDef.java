package lesgoo.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class LogoutStepDef {

    @Steps
    LesGooApi lesGooApi;

    @When("Logout with bearer token")
    public void getListUserWithParameter() {
        lesGooApi.logoutUser();
    }

    @When("Send request logout")
    public void sendRequestLogout() {
        SerenityRest.when().post(LesGooApi.LOGOUT);
    }

    @Given("Logout without bearer token")
    public void logoutWithoutBearerToken() {
        lesGooApi.logoutUserWithoutAuthorization();
    }
}
