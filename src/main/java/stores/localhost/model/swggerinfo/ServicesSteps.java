package stores.localhost.model.swggerinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import stores.localhost.model.constants.EndPoints;
import stores.localhost.model.model.ServicesPojo;

import java.util.HashMap;

public class ServicesSteps {

    @Step("Creating Services with perameter")
    public ValidatableResponse createServices(String name) {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .post(EndPoints.CREATE_SERVICES)
                .then();
    }

    @Step("Getting the Services information from Id")
    public HashMap<String, Object> getCreatedServicesId(int servicesId) {

        HashMap<String, Object> servicesMap = SerenityRest.given().log().all()
                .when()
                .pathParam("servicesId",servicesId)
                .get(EndPoints.GET_SINGLE_SERVICES_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        return servicesMap;
    }

    @Step("Update Services with perameter")
    public ValidatableResponse updateServices(int servicesId,String name) {
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .pathParam("servicesId",servicesId)
                .patch(EndPoints.UPDATE_SERVICES_BY_ID)
                .then();
    }

    @Step("Deleting services information with services")
    public ValidatableResponse deleteServices(int servicesId) {
        return SerenityRest.given().log().all()
                .pathParam("servicesId",servicesId)
                .when()
                .delete(EndPoints.DELETE_SERVICES_BY_ID)
                .then();
    }

    @Step("Getting services information with Id")
    public ValidatableResponse getServicesById(int servicesId) {
        return SerenityRest.given().log().all()
                .pathParam("servicesId",servicesId)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICES_BY_ID)
                .then();
    }
    @Step("Getting All users information")
    public ValidatableResponse getAllservices(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_SERVICES_ALL_)
                .then();
    }
}
