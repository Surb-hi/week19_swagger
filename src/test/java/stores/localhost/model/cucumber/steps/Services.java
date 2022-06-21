package stores.localhost.model.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import stores.localhost.model.swggerinfo.ServicesSteps;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class Services {
    static String name = "name" + TestUtils.getRandomValue();
    static int servicesId;
    static ValidatableResponse response;

    @Steps
    ServicesSteps servicesSteps;
    @When("^User sends a GET request to services  endpoint$")
    public void userSendsAGETRequestToServicesEndpoint() {
      response=servicesSteps.getAllservices();
    }

    @Then("^User get back a valid status code (\\d+) for services$")
    public void userGetBackAValidStatusCodeForServices(int code) {

        response.log().all().statusCode(code);
    }

    @When("^User sends a Post request to  services endpoint$")
    public void userSendsAPostRequestToServicesEndpoint() {
        response = servicesSteps.createServices(name);
        response.log().all().statusCode(201);
        servicesId = response.log().all().extract().path("id");
    }

    @And("^Verify that services created sucessfully$")
    public void verifyThatServicesCreatedSucessfully() {
        HashMap<String, Object> servicesMap = servicesSteps.getCreatedServicesId(servicesId);
        Assert.assertThat(servicesMap, hasValue(name));
        System.out.println(servicesId);
    }

    @When("^User sends a patch request to services endpoint$")
    public void userSendsAPatchRequestToServicesEndpoint() {
        name = "name" + TestUtils.getRandomValue();
        response = servicesSteps.updateServices(servicesId,name);
    }


    @And("^Verify that services Updated sucessfully$")
    public void verifyThatServicesUpdatedSucessfully() {
        HashMap<String, Object> servicesMap = servicesSteps.getCreatedServicesId(servicesId);
        Assert.assertThat(servicesMap, hasValue(name));
        System.out.println(servicesId);
    }

    @When("^User sends a delete request to services endpoint$")
    public void userSendsADeleteRequestToServicesEndpoint() {
        servicesSteps.deleteServices(servicesId);
        servicesSteps.getServicesById(servicesId);
    }
}
