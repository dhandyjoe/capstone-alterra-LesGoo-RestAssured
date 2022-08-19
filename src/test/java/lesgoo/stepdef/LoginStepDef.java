package lesgoo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import lesgoo.response.LesGooResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {

    @Steps
    LesGooApi lesGooApi;

    @When("login with username {string} and password {string}")
    public void getListUserWithParameter(String username, String password) {
//        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/login/LoginWithValidData.json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("fcm_token", "fcmtoken");
        String login = jsonObject.toString();

        lesGooApi.loginUser(login);
    }

    @When("Send request login")
    public void sendRequestLogin() {
        LesGooApi.ACCESS_TOKEN = SerenityRest.when().post(LesGooApi.LOGIN)
                .body().jsonPath().getString("data.token");

        System.out.println("ini token login : " + LesGooApi.ACCESS_TOKEN);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then().body(LesGooResponse.MESSAGE, equalTo(message));
    }
}
