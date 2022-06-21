package stores.localhost.model.swggerinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import stores.localhost.model.constants.EndPoints;

public class UtilitiesSteps{
    @Step("")
        public ValidatableResponse getHealthcheckdata() {
            return SerenityRest.given().log().all()
                    .when()
                    .get(EndPoints.GET_UTILITIES_HEALTHCHECK)
                    .then();
        }
    @Step("")
    public ValidatableResponse getversiondata() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_UTILITIES_VERSION)
                .then();
    }
    }

