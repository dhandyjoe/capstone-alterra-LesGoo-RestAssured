package lesgoo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

public class LesGooHooks {

    @Before(value = "@access")
    public void login() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "jenny2");
        jsonObject.put("password", "qwerty");
        jsonObject.put("fcm_token", "fcmtoken");
        String login = jsonObject.toString();

        LesGooApi.ACCESS_TOKEN = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post(LesGooApi.LOGIN)
                .body().jsonPath().getString("data.token");

        System.out.println("Berhasil login");
    }

    @After(value = "@access")
    public void logout() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + LesGooApi.ACCESS_TOKEN)
                .when().post(LesGooApi.LOGOUT);

        System.out.println("Berhasil logout");
    }

    @Before(value = "@loginDefault")
    public void loginForLogoutAPI() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "jenny2");
        jsonObject.put("password", "qwerty");
        jsonObject.put("fcm_token", "fcmtoken");
        String login = jsonObject.toString();

        LesGooApi.ACCESS_TOKEN = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post(LesGooApi.LOGIN)
                .body().jsonPath().getString("data.token");

        System.out.println("ini token login : " + LesGooApi.ACCESS_TOKEN);
    }

    @After(value = "@logoutDefault")
    public void logoutForLoginAPI() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + LesGooApi.ACCESS_TOKEN)
                .when().post(LesGooApi.LOGOUT);

        System.out.println("logout");
    }
}
