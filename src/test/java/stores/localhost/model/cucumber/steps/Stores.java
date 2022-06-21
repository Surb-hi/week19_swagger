package stores.localhost.model.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import stores.localhost.model.swggerinfo.StoreSteps;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class Stores {
    static String name = "name" + TestUtils.getRandomValue();
    static String type = "type" + TestUtils.getRandomValue();
    static String address = "address" + TestUtils.getRandomValue();
    static String city = "city" + TestUtils.getRandomValue();
    static String state = "state" + TestUtils.getRandomValue();
    static String zip = "zip" + TestUtils.getRandomValue();
    static Object lat = 00;
    static Object lng = 01;
    static String hours = "hours" + TestUtils.getRandomValue();
    static int storesId;
    static ValidatableResponse response;

    @Steps
    StoreSteps storeSteps;

    @When("^User sends a GET request to stores list endpoint$")
    public void userSendsAGETRequestToStoresListEndpoint() {
        storeSteps.getAllUsers();
    }

    @Then("^User get back a valid status code (\\d+) for stores$")
    public void userGetBackAValidStatusCodeForStores(int code) {
        response.log().all().statusCode(code);
    }

    @When("^User sends a Post request to stores endpoint$")
    public void userSendsAPostRequestToStoresEndpoint() {
        HashMap<Object,Object> services = new HashMap<>();

        response = storeSteps.createstore(name,type,address,city,state,zip,hours,lat,lng,services);
        storesId = response.log().all().extract().path("id");
    }

    @And("^Verify that stores created sucessfully$")
    public void verifyThatStoresCreatedSucessfully() {
        HashMap<String, Object> storeMap =storeSteps.getCreatedstoreId(storesId);
        Assert.assertThat(storeMap, hasValue(name));
        System.out.println(storesId);
    }

    @When("^User sends a patch request to stores endpoint$")
    public void userSendsAPatchRequestToStoresEndpoint() {
        HashMap<Object,Object> services = new HashMap<>();
        ValidatableResponse response =storeSteps.updatestore (storesId,name,type,address,city,state,zip,hours,lat,lng,services);
    }

    @And("^Verify that stores Updated sucessfully$")
    public void verifyThatStoresUpdatedSucessfully() {
        HashMap<String, Object> storeMap = storeSteps.getCreatedstoreId(storesId);
        Assert.assertThat(storeMap, hasValue(name));
        System.out.println(storesId);
    }

    @When("^User sends a delete request to stores list endpoint$")
    public void userSendsADeleteRequestToStoresListEndpoint() {
        storeSteps.deletestore(storesId);
        storeSteps.getstoreById(storesId);
    }
}
