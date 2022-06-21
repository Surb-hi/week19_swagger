package stores.localhost.model.swaggerinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import stores.localhost.model.swggerinfo.StoreSteps;
import stores.localhost.model.testbase.TestBase;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class StoreCURDTestWithSteps extends TestBase {
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

    @Steps
    StoreSteps storeSteps;

    @Title("This will create a new store ")
    @Test
    public void test001() {
        HashMap<Object,Object> services = new HashMap<>();

        ValidatableResponse response = storeSteps.createstore(name,type,address,city,state,zip,hours,lat,lng,services);
        response.log().all().statusCode(201);
        storesId = response.log().all().extract().path("id");
    }

    @Title("Verify that the store added in to stack")
    @Test
    public void test002() {
        HashMap<String, Object> storeMap =storeSteps.getCreatedstoreId(storesId);
        Assert.assertThat(storeMap, hasValue(name));
        System.out.println(storesId);
    }

    @Title("This will Updated created id")
    @Test
    public void test003() {
        HashMap<Object,Object> services = new HashMap<>();
        ValidatableResponse response =storeSteps.updatestore (storesId,name,type,address,city,state,zip,hours,lat,lng,services);
        response.log().all().statusCode(200);
        HashMap<String, Object> storeMap = storeSteps.getCreatedstoreId(storesId);
        Assert.assertThat(storeMap, hasValue(name));
        System.out.println(storesId);
    }

    @Title("This will Delate created id")
    @Test
    public void test004() {
        storeSteps.deletestore(storesId).statusCode(200);
        storeSteps.getstoreById(storesId).statusCode(404);
    }
    }
