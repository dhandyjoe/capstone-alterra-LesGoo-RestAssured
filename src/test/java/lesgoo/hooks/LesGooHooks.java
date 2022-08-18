package lesgoo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.http.ContentType;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;


public class LesGooHooks {

//    @Before(value = "@login")
//    public void login() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("username", "testingqa");
//        jsonObject.put("password", "qwerty");
//        jsonObject.put("fcm_token", "fcmtoken");
//        String login = jsonObject.toString();
//
//        LesGooApi.ACCESS_TOKEN = SerenityRest.given()
//                .contentType(ContentType.JSON)
//                .body(login)
//                .when()
//                .post(LesGooApi.LOGIN)
//                .body().jsonPath().getString("data.token");
//
//        System.out.println("ini token login : " + LesGooApi.ACCESS_TOKEN);
//    }

    @Before(value = "@logout")
    public void login() {
//        SerenityRest.given()
//                .headers("Authorization", "Bearer " + LesGooApi.ACCESS_TOKEN)
//                .when().post(LesGooApi.LOGOUT);

        System.out.println("before");
    }

    @After(value = "@logout")
    public void logout() {
//        SerenityRest.given()
//                .headers("Authorization", "Bearer " + LesGooApi.ACCESS_TOKEN)
//                .when().post(LesGooApi.LOGOUT);

        System.out.println("after");
    }
}
