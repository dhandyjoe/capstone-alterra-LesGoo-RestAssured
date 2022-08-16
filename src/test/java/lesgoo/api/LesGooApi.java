package lesgoo.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;

public class LesGooApi {

    public static final String URL = "https://lesgoo.athaprojects.me/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MTF9.hGI6Ng0WWmd26DgWnljap7xdLdWtyZSXYPyRMVlCD6g";

    public static String ACCESS_TOKEN = "";

    // Register
    public static String REGISTER = URL+"register";

    // Login
    public static String LOGIN = URL+"login";

    // Group
    public static String CREATE_GROUP = URL+"group";
    public static String GROUP = URL+"group/{id}";
    public static String JOIN_GROUP = URL+"group/join";
    public static String CHATS_GROUP = URL+"group/chats";
    public static String LEAVE_GROUP = URL+"group/leave";

    // Logout
    public static String LOGOUT = URL+"logout";


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

    @Step("Register user")
    public void registerUser(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Create group")
    public void createGroup(File json) {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Detail group")
    public void detailGroup(String id) {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN)
                .pathParam("id", id);
    }

    @Step("Delete group")
    public void deleteGroup(String id) {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN)
                .pathParam("id", id);
    }

    @Step("Join group")
    public void joinGroup(String json) {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get chat + all participant location")
    public void getChatAndLocation(String json) {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Leave group")
    public void leaveGroup(String json) {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
