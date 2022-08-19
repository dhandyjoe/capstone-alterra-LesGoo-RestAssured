package lesgoo.stepdef;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

public class ChatsStepDef {

    @Steps
    LesGooApi lesGooApi;

    @When("add chats with groupId {string} and message {string} and isSOS {string}")
    public void addChatsWithGroup_idAndMessageAndIsSOS(String grub_id, String message, String isSOS) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grub_id", grub_id);
        jsonObject.put("Message", message);
        jsonObject.put("isSOS", Boolean.parseBoolean(isSOS));
        String chats = jsonObject.toString();

        lesGooApi.addChats(chats);
    }

    @When("send request add chats")
    public void sendRequestAddChats() {
        SerenityRest.when().post(LesGooApi.CHATS);
    }

    @When("add chats with groupId {string} and message {string} and isSOS {string} without authorization")
    public void addChatsWithGroupIdAndMessageAndIsSOSWithoutAuthorization(String grub_id, String message, String isSOS) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grub_id", grub_id);
        jsonObject.put("Message", message);
        jsonObject.put("isSOS", Boolean.parseBoolean(isSOS));
        String chats = jsonObject.toString();

        lesGooApi.addChatsWithoutAuthorization(chats);
    }
}
