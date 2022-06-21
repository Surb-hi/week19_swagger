package stores.localhost.model.swaggerinfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import stores.localhost.model.swggerinfo.UtilitiesSteps;
import stores.localhost.model.testbase.TestBase;
@RunWith(SerenityRunner.class)
public class UtilitiesCURDTestWithSteps extends TestBase {

    @Steps
    UtilitiesSteps utilitiesSteps;

    @Title("")
    @Test
    public void test001() {
        utilitiesSteps.getHealthcheckdata().statusCode(200);
        utilitiesSteps.getversiondata().statusCode(200);
    }
}
