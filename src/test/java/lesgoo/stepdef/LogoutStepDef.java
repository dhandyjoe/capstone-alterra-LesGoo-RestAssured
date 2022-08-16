package lesgoo.stepdef;

import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

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
        System.out.println("ini token logout : " + LesGooApi.ACCESS_TOKEN);
    }
}
