package stores.localhost.model.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import stores.localhost.model.utils.PropertyReader;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
    }

}
