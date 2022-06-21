package stores.localhost.model.swaggerinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import stores.localhost.model.swggerinfo.ServicesSteps;
import stores.localhost.model.testbase.TestBase;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class ServicesCURDTestWithSteps extends TestBase {
    static String name = "name" + TestUtils.getRandomValue();
    static int servicesId;

    @Steps
    ServicesSteps servicesSteps;

    @Title("This will create a services new ")
    @Test
    public void test001() {
        ValidatableResponse response = servicesSteps.createServices(name);
        response.log().all().statusCode(201);
        servicesId = response.log().all().extract().path("id");
    }

    @Title("Verify that the services added in to stack")
    @Test
    public void test002() {
        HashMap<String, Object> servicesMap = servicesSteps.getCreatedServicesId(servicesId);
        Assert.assertThat(servicesMap, hasValue(name));
        System.out.println(servicesId);
    }

    @Title("This will Updated created id")
    @Test
    public void test003() {
        ValidatableResponse response = servicesSteps.updateServices(servicesId,name);
        response.log().all().statusCode(200);
        HashMap<String, Object> servicesMap = servicesSteps.getCreatedServicesId(servicesId);
        Assert.assertThat(servicesMap, hasValue(name));
        System.out.println(servicesId);
    }

    @Title("This will Delate created id")
    @Test
    public void test004() {
        servicesSteps.deleteServices(servicesId).statusCode(200);
        servicesSteps.getServicesById(servicesId).statusCode(404);
    }
}
