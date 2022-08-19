package lesgoo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import lesgoo.response.LesGooResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

public class RegisterStepDef {

    @Steps
    LesGooApi lesGooApi;

    @When("register with username {string} and email {string} phone {string} and password {string}")
    public void getListUserWithParameter(String username, String email, String phone, String password) {
//        File jsonFile = new File(Constants.JSON_BODY_REQ+register/RegisterWithValidData.json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("email", email);
        jsonObject.put("phone", phone);
        jsonObject.put("password", password);
        jsonObject.put("fcm_token", "fcmtoken");
        String register = jsonObject.toString();

        lesGooApi.registerUser(register);
    }

    @When("Send request register")
    public void sendRequestRegister() {
        SerenityRest.when().post(LesGooApi.REGISTER);
    }
}
