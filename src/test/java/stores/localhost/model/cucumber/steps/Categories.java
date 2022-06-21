package stores.localhost.model.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import stores.localhost.model.swggerinfo.CategoriesSteps;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class Categories {
    static String name = "name" + TestUtils.getRandomValue();
    static String id = "00" + TestUtils.getRandomValue();
    static String categoriesid;
    static ValidatableResponse response;
    @Steps
    CategoriesSteps categoriesSteps;

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        categoriesSteps.getAllCategories();
    }

    @Then("^User get back a valid status code (\\d+)$")
    public void userGetBackAValidStatusCode(int code) {
        response.log().all().statusCode(code);
    }

    @When("^User sends a Post request to list endpoint$")
    public void userSendsAPostRequestToListEndpoint() {
        response = categoriesSteps.createcategories(name, id);
        response.log().all().statusCode(201);
        categoriesid = response.log().all().extract().path("id");
    }

    @And("^Verify that user created sucessfully$")
    public void verifyThatUserCreatedSucessfully() {
        HashMap<String, Object> categoriesMap = categoriesSteps.getCreatedcategoriesId(categoriesid);
        Assert.assertThat(categoriesMap, hasValue(name));
        System.out.println(categoriesid);
    }

    @When("^User sends a patch request to list endpoint$")
    public void userSendsAPatchRequestToListEndpoint() {
        response = categoriesSteps.updatecategories(categoriesid, name, id);
        response.log().all().statusCode(200);
    }

    @And("^Verify that user Updated sucessfully$")
    public void verifyThatUserUpdatedSucessfully() {
        HashMap<String, Object> categoriesMap = categoriesSteps.getCreatedcategoriesId(categoriesid);
        Assert.assertThat(categoriesMap, hasValue(name));
        System.out.println(categoriesid);
    }

    @When("^User sends a delete request to list endpoint$")
    public void userSendsADeleteRequestToListEndpoint() {
        categoriesSteps.deletecategories(categoriesid);
        categoriesSteps.getcategoriesById(categoriesid);
    }
}

