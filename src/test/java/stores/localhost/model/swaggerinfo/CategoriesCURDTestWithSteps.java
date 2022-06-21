package stores.localhost.model.swaggerinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import stores.localhost.model.swggerinfo.CategoriesSteps;
import stores.localhost.model.testbase.TestBase;
import stores.localhost.model.utils.TestUtils;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class CategoriesCURDTestWithSteps extends TestBase {
    static String name = "name" + TestUtils.getRandomValue();
    static String id = "00" + TestUtils.getRandomValue();
    static String categoriesid;
    @Steps
    CategoriesSteps categoriesSteps;

    @Title("This will create Categories new ")
    @Test
    public void test001() {
        ValidatableResponse response = categoriesSteps.createcategories(name, id);
        response.log().all().statusCode(201);
        categoriesid = response.log().all().extract().path("id");
    }

    @Title("Verify that the Categories added in to stack")
    @Test
    public void test002() {
        HashMap<String, Object> categoriesMap = categoriesSteps.getCreatedcategoriesId(categoriesid);
        Assert.assertThat(categoriesMap, hasValue(name));
        System.out.println(categoriesid);
    }

    @Title("This will Updated created id")
    @Test
    public void test003() {
        ValidatableResponse response = categoriesSteps.updatecategories(categoriesid, name, id);
        response.log().all().statusCode(200);
        HashMap<String, Object> categoriesMap = categoriesSteps.getCreatedcategoriesId(categoriesid);
        Assert.assertThat(categoriesMap, hasValue(name));
        System.out.println(categoriesid);
    }

    @Title("This will Delate created id")
    @Test
    public void test004() {
        categoriesSteps.deletecategories(categoriesid).statusCode(200);
        categoriesSteps.getcategoriesById(categoriesid).statusCode(404);
    }
}
