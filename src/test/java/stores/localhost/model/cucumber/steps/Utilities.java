package stores.localhost.model.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import stores.localhost.model.swggerinfo.UtilitiesSteps;

public class Utilities {
    static ValidatableResponse response;
    @Steps
    UtilitiesSteps utilitiesSteps;
    @When("^User sends a GET request to Healthcheckdata Utilities endpoint$")
    public void userSendsAGETRequestToHealthcheckdataUtilitiesEndpoint() {
     response= utilitiesSteps.getHealthcheckdata();
    }

    @Then("^User get back a valid status code (\\d+) for Utilities$")
    public void userGetBackAValidStatusCodeForUtilities(int code) {
        response.log().all().statusCode(code);
    }

    @When("^User sends a GET request to versiondata Utilities endpoint$")
    public void userSendsAGETRequestToVersiondataUtilitiesEndpoint() {
        response=utilitiesSteps.getversiondata();
    }
}
