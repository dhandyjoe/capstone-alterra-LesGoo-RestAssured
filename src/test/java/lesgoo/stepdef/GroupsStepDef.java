package lesgoo.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import lesgoo.constants.Constants;
import lesgoo.response.LesGooResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class GroupsStepDef {

    @Steps
    LesGooApi lesGooApi;

    @Given("Create a new group with valid req body")
    public void createANewGroupWithValidReqBody() {
        lesGooApi.createGroupWithValidData();
    }

    @When("Send request create group")
    public void getListUserWithParameter() {
        SerenityRest.when().post(LesGooApi.CREATE_GROUP);
    }

    @Given("Create a new group with invalid name")
    public void createANewGroupWithInvalidName() {
        lesGooApi.createGroupWithInvalidName();
    }

    @Given("Create a new group with invalid description")
    public void createANewGroupWithInvalidDescription() {
        lesGooApi.createGroupWithInvalidDescription();
    }

    @Given("Create a new group with invalid start_dest")
    public void createANewGroupWithInvalidStart_dest() {
        lesGooApi.createGroupWithInvalidStartDest();
    }

    @Given("create a new group with invalid final_dest")
    public void createANewGroupWithInvalidFinal_dest() {
        lesGooApi.createGroupWithInvalidFinalDest();
    }

    @Given("Create a new group with invalid start_date")
    public void createANewGroupWithInvalidStart_date() {
        lesGooApi.createGroupWithInvalidStartDate();
    }

    @Given("Create a new group with invalid end_date")
    public void createANewGroupWithInvalidEnd_date() {
        lesGooApi.createGroupWithInvalidEndDate();
    }

    @Given("Create a new group with invalid groupimg")
    public void createANewGroupWithInvalidGroupimg() {
        lesGooApi.createGroupWithInvalidGroupImage();
    }

    @Given("Create a new group with invalid latitude")
    public void createANewGroupWithInvalidLatitude() {
        lesGooApi.createGroupWithInvalidLatitude();
    }

    @Given("Create a new group with invalid longitude")
    public void createANewGroupWithInvalidLongitude() {
        lesGooApi.createGroupWithInvalidLongitude();
    }

    @Given("Create a new group with no body req")
    public void createANewGroupWithNoBodyReq() {
        lesGooApi.createGroupWithNoBodyRequest();
    }

    @Given("Get detail group with valid id {string}")
    public void getDetailGroupWithValidId(String id) {
        lesGooApi.detailGroup(id);
    }

    @When("Send request get detail group")
    public void sendRequestGetDetailGroup() {
        SerenityRest.when().get(LesGooApi.GROUP);
    }

    @Given("Get detail group with invalid id {string}")
    public void getDetailGroupWithInvalidId(String id) {
        lesGooApi.detailGroup(id);
    }

    @Given("Post join group by valid data")
    public void postJoinGroupByValidData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", "asdunavr");
        jsonObject.put("latitude", -6.2424);
        jsonObject.put("longitude", 105.424);
        String joinGroup = jsonObject.toString();

        lesGooApi.joinGroup(joinGroup);
    }

    @When("Send request post join group")
    public void sendRequestPostJoinGroup() {
        SerenityRest.when().post(LesGooApi.JOIN_GROUP);
    }

    @Given("Post join group by invalid data")
    public void postJoinGroupByInvalidData() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", "");
//        jsonObject.put("latitude", 0);
//        jsonObject.put("longitude", 0);
        String joinGroup = jsonObject.toString();

        lesGooApi.joinGroup(joinGroup);
    }

    @Given("Delete group with valid id {string}")
    public void deleteGroupWithValidId(String id) {
        lesGooApi.deleteGroup(id);
    }

    @When("Send request delete group")
    public void sendRequestDeleteGroup() {
        SerenityRest.when().delete(LesGooApi.GROUP);
    }

    @Given("Delete group with invalid id {string}")
    public void deleteGroupWithInvalidId(String id) {
        lesGooApi.deleteGroup(id);
    }

    @Given("Get all chat + participant location with valid groupId {string}")
    public void getAllChatParticipantLocationWithValidGroup_id(String groupId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", groupId);
        String getChatAndLocation = jsonObject.toString();

        lesGooApi.getChatAndLocation(getChatAndLocation);
    }

    @When("Send request get chats")
    public void sendRequestGetChats() {
        SerenityRest.when().post(LesGooApi.CHATS_GROUP);
    }

    @Given("Leave group")
    public void leaveGroup() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", "a38a98ca-4552-49cd-93a4-c1637c809d10");
        String leaveGroup = jsonObject.toString();

        lesGooApi.leaveGroup(leaveGroup);
    }

    @When("Send request leave group")
    public void sendRequestLeaveGroup() {
        SerenityRest.when().post(LesGooApi.LEAVE_GROUP);
    }

    @And("Response body should contain group name {string}")
    public void responseBodyShouldContainGroupName(String groupName) {
        SerenityRest.then().body(LesGooResponse.GROUP_NAME, equalTo(groupName));
    }

    @Given("Get all chat + participant location with invalid groupId")
    public void getAllChatParticipantLocationWithInvalidGroupId() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", "qwfgiarig");
        String getChatAndLocation = jsonObject.toString();

        lesGooApi.getChatAndLocation(getChatAndLocation);
    }

    @Given("Leave group with invalid groupId")
    public void leaveGroupWithInvalidGroupId() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", "a38a98ca-4552-49cd-93a4-c1637c809d10");
        String leaveGroup = jsonObject.toString();

        lesGooApi.leaveGroup(leaveGroup);
    }
}
