package lesgoo.api;

import io.restassured.http.ContentType;
import lesgoo.constants.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class LesGooApi {

    public static String ACCESS_TOKEN = "";

    // Register
    public static String REGISTER = Constants.URL+"/register";

    // Login
    public static String LOGIN = Constants.URL+"/login";

    // Group
    public static String CREATE_GROUP = Constants.URL+"/group";
    public static String GROUP = Constants.URL+"/group/{id}";
    public static String JOIN_GROUP = Constants.URL+"/group/join";
    public static String CHATS_GROUP = Constants.URL+"/group/chats";
    public static String LEAVE_GROUP = Constants.URL+"/group/leave";

    // Logout
    public static String LOGOUT = Constants.URL+"/logout";

    //User
    public static String USERS = Constants.URL+"/users";

    //Chat
    public static String CHATS = Constants.URL+"/chats";

    //Locations
    public static String LOCATIONS = Constants.URL+"/locations";

    @Step("Login user")
    public void loginUser(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Logout user")
    public void logoutUser() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN);
    }

    @Step("Logout user without authorization")
    public void logoutUserWithoutAuthorization() {
        SerenityRest.given();
    }

    @Step("Register user")
    public void registerUser(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create group")
    public void createGroup(File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("name", "qagroup")
                .multiPart("description", "ini deskripsi")
                .multiPart("start_dest", "Salatiga")
                .multiPart("final_dest", "Semarang")
                .multiPart("start_date", "Jumat")
                .multiPart("end_date", "Minggu")
                .multiPart("groupimg", new File("/home/dhandyjoe/Pictures/background/coding2.jpg"))
                .multiPart("longitude", "106.22")
                .multiPart("latitude", "60.33");
    }

    @Step("Detail group")
    public void detailGroup(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete group")
    public void deleteGroup(String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .pathParam("id", id);
    }

    @Step("Join group")
    public void joinGroup(String json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get chat + all participant location")
    public void getChatAndLocation(String json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Leave group")
    public void leaveGroup(String json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add Locations")
    public void addLocations(String json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add Locations without authorization")
    public void addLocationsWithoutAuthorization(String json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add Chats")
    public void addChats(String json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add Chats without authorization")
    public void addChatsWithoutAuthorization(String json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get user detail ")
    public void getUserDetail(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN);
    }

    @Step("Get user detail with invalid bearer token")
    public void getUserDetailWithoutAuthorization(){
        SerenityRest.given();
    }

    @Step("Put update user")
    public static void putUpdateUser(String json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + ACCESS_TOKEN);
    }
}
