package lesgoo.stepdef;

import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class LogoutStepDef {

    @Steps
    LesGooApi lesGooApi;

    @When("login with bearer token")
    public void getListUserWithParameter() {
        lesGooApi.logoutUser();
    }

    @When("Send request logout")
    public void sendRequestLogout() {
        SerenityRest.when().post(LesGooApi.LOGOUT);
    }
}
