package lesgoo.stepdef;

import io.cucumber.java.en.When;
import lesgoo.api.LesGooApi;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.JSONObject;

public class LocationsStepDef {

    @Steps
    LesGooApi lesGooApi;

    @When("add locations with groupId {string} and latitude {double} and longitude {double}")
    public void addLocationsWithGrubidAndLatitudeAndLongitude(String groupId, double latitude, double longitude) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", groupId);
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude);
        String locations = jsonObject.toString();

        lesGooApi.addLocations(locations);
    }

    @When("send request add locations")
    public void sendRequestAddLocations() {
        SerenityRest.when().post(LesGooApi.LOCATIONS);
    }

    @When("add locations with groupId {string} and latitude {double} and longitude {double} wihtout authorization")
    public void addLocationsWithGroup_idAndLatitudeAndLongitudeWihtoutAuthorization(String groupId, double latitude, double longitude) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("group_id", groupId);
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude);
        String locations = jsonObject.toString();

        lesGooApi.addLocationsWithoutAuthorization(locations);
    }
}
