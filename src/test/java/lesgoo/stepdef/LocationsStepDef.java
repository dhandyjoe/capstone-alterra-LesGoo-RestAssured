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


public class LocationsStepDef {

    @Steps
    LesGooApi lesGooApi;
    @When("add locations with grubid {string} and latitude {double} and longitude {double}")
    public void addLocationsWithGrubidAndLatitudeAndLongitude(String grubId, double latitude, double longitude) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grub ID", grubId);
        jsonObject.put("Latitude", latitude);
        jsonObject.put("Longitude", longitude);
        String locations = jsonObject.toString();

        lesGooApi.addLocations(locations);}

    @When("send request add locations")
    public void sendRequestAddLocations() {SerenityRest.when().post(LesGooApi.LOCATIONS);
    }
}
