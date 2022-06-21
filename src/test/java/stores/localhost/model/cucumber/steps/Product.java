package stores.localhost.model.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import stores.localhost.model.swggerinfo.ProductSteps;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class Product {
    static String name = "Duracell - AA Batteries qe";
    static String type = "type" + TestUtils.getRandomValue();
    static Object price = 5.99;
    static Object shipping = 123;
    static String upc = "upc" + TestUtils.getRandomValue();
    static String description = "description" + TestUtils.getRandomValue();
    static String manufacturer = "manufacturer" + TestUtils.getRandomValue();
    static String model = "model" + TestUtils.getRandomValue();
    static String url = "url" + TestUtils.getRandomValue();
    static String image = "image" + TestUtils.getRandomValue();
    static int productId;
    static ValidatableResponse response;
    @Steps
    ProductSteps productSteps;

    @When("^User sends a GET request to list Product endpoint$")
    public void userSendsAGETRequestToListProductEndpoint() {
    response=productSteps.getAllproduct();
    }

    @Then("^User get back a valid status code (\\d+) for Products$")
    public void userGetBackAValidStatusCodeForProducts(int code) {
        response.log().all().statusCode(code);
    }

    @When("^User sends a Post request to Product endpoint$")
    public void userSendsAPostRequestToProductEndpoint() {
        ValidatableResponse response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(201);
        productId = response.log().all().extract().path("id");
    }

    @And("^Verify that user created sucessfully for Product$")
    public void verifyThatUserCreatedSucessfullyForProduct() {
        HashMap<String, Object> productMap = productSteps.getCreatedProductId(productId);
        Assert.assertThat(productMap, hasValue(name));
        System.out.println(productId);
    }

    @When("^User sends a patch request to Product endpoint$")
    public void userSendsAPatchRequestToProductEndpoint() {
        name = "name" + TestUtils.getRandomValue();
        response = productSteps.updateProduct(productId,name, type, price, shipping, upc, description, manufacturer, model, url, image);
    }

    @And("^Verify that Product Updated sucessfully$")
    public void verifyThatProductUpdatedSucessfully() {
        HashMap<String, Object> ProductMap = productSteps.getCreatedProductId(productId);
        Assert.assertThat(ProductMap, hasValue(name));
        System.out.println(productId);
    }

    @When("^User sends a delete request to Product  endpoint$")
    public void userSendsADeleteRequestToProductEndpoint() {
        productSteps.deleteproduct(productId);
        productSteps.getProductById(productId);
    }
}
