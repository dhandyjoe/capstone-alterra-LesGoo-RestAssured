package lesgoo.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

import java.io.File;

public class GroupsStepDef {

    @Steps
    LesGooApi lesGooApi;

    @Given("Create a new group with valid req body")
    public void createANewGroupWithValidReqBody() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsValidData.json");
        lesGooApi.createGroup(jsonFile);
    }

    @When("Send request create group")
    public void getListUserWithParameter() {
        SerenityRest.when().post(LesGooApi.CREATE_GROUP);
    }

    @Given("Create a new group with invalid name")
    public void createANewGroupWithInvalidName() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidName.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid description")
    public void createANewGroupWithInvalidDescription() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidDescription.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid start_dest")
    public void createANewGroupWithInvalidStart_dest() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidStartDest.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("create a new group with invalid final_dest")
    public void createANewGroupWithInvalidFinal_dest() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidFinalDest.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid start_date")
    public void createANewGroupWithInvalidStart_date() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidStartDate.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid end_date")
    public void createANewGroupWithInvalidEnd_date() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidEndDate.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid groupimg")
    public void createANewGroupWithInvalidGroupimg() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidGroupImg.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid latitude")
    public void createANewGroupWithInvalidLatitude() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidLatitude.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with invalid longitude")
    public void createANewGroupWithInvalidLongitude() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsInvalidLongitude.json");
        lesGooApi.createGroup(jsonFile);
    }

    @Given("Create a new group with no body req")
    public void createANewGroupWithNoBodyReq() {
        File jsonFile = new File(LesGooApi.DIR+"/src/test/resources/json/requestbody/groups/CreateGroupsNoBodyReq.json");
        lesGooApi.createGroup(jsonFile);
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

    @Given("Get all chat + participant location with valid group_id")
    public void getAllChatParticipantLocationWithValidGroup_id() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", "qwfgiarig");
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
        jsonObject.put("group_id", "qwfgiarig");
        String leaveGroup = jsonObject.toString();

        lesGooApi.leaveGroup(leaveGroup);
    }

    @When("Send request leave group")
    public void sendRequestLeaveGroup() {
        SerenityRest.when().post(LesGooApi.LEAVE_GROUP);
    }
}
