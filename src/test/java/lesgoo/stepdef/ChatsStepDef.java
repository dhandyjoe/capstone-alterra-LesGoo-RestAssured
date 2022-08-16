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

import io.cucumber.java.en.When;

public class ChatsStepDef {
    @Steps
    LesGooApi lesGooApi;
    @When("add chats with group_id {string} and message {string} and isSOS {string}")
    public void addChatsWithGroup_idAndMessageAndIsSOS(String grub_id, String message, String isSOS) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grub_id", grub_id);
        jsonObject.put("Message", message);
        jsonObject.put("isSOS", isSOS);
        String chats = jsonObject.toString();
        lesGooApi.addChats(chats);}

    @When("send request add chats")
    public void sendRequestAddChats() { SerenityRest.when().post(LesGooApi.CHATS);
    }
}
