package lesgoo.api;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;

public class LesGooApi {

    public static final String URL = "https://lesgoo.athaprojects.me/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String BEARER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6MTF9.hGI6Ng0WWmd26DgWnljap7xdLdWtyZSXYPyRMVlCD6g";

    // Register

    // Login
    public static String LOGIN = URL+"login";

    // Group

    // Logout
    public static String LOGOUT = URL+"logout";

    //User
    public static String USERS = URL+"users";

    //Chat
    public static String CHATS = URL+"chats";

    //Locations
    public static String LOCATIONS = URL+"locations";


    @Step("Login user")
    public void loginUser(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Logout user")
    public void logoutUser() {
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN);
    }

    @Step("Get user detail ")
    public void getUserDetail(){
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN);
    }

    @Step("Edit User")
    public void editUser(String json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .headers("Authorization", BEARER_TOKEN);
    }

    @Step("Get Chat")
    public void getChats(){
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN);
    }

    @Step("Get Locations")
    public void getLocations(){
        SerenityRest.given()
                .headers("Authorization", BEARER_TOKEN);
    }

}
