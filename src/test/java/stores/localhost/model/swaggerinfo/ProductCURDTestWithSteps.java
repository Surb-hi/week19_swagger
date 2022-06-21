package stores.localhost.model.swaggerinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import stores.localhost.model.swggerinfo.ProductSteps;
import stores.localhost.model.testbase.TestBase;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductCURDTestWithSteps extends TestBase {
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
    @Steps
    ProductSteps productSteps;

    @Title("This will create a new product")
    @Test
    public void test001() {
        ValidatableResponse response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(201);
        productId = response.log().all().extract().path("id");
    }

    @Title("Verify that the product added in to stack")
    @Test
    public void test002() {
        HashMap<String, Object> productMap = productSteps.getCreatedProductId(productId);
        Assert.assertThat(productMap, hasValue(name));
        System.out.println(productId);
    }
    @Title("This will Updated created id")
    @Test
    public void test003(){
        ValidatableResponse response = productSteps.updateProduct(productId,name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(201);
        HashMap<String, Object> ProductMap = productSteps.getCreatedProductId(productId);
        Assert.assertThat(ProductMap, hasValue(name));
        System.out.println(productId);
    }
    @Title("This will Delate created id")
    @Test
    public void test004(){
            productSteps.deleteproduct(productId).statusCode(200);
            productSteps.getProductById(productId).statusCode(404);
        }
    }
