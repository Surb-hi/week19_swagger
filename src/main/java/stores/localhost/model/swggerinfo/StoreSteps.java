package stores.localhost.model.swggerinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import stores.localhost.model.constants.EndPoints;
import stores.localhost.model.model.StorePojo;

import java.util.HashMap;

public class StoreSteps {
    @Step("Creating store with perameter")
    public ValidatableResponse createstore(String name,String type,String address,String city ,String state,String zip,String hours,Object lat,Object lng,HashMap<Object,Object> services) {
        HashMap<Object,Object> services1 = new HashMap<>();
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        storePojo.setServices(services1);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.CREATE_STORE)
                .then();
    }
    @Step("Getting the store information from Id")
    public HashMap<String, Object> getCreatedstoreId(int storesId) {
        HashMap<String, Object> storeMap = SerenityRest.given().log().all()
                .when()
                .pathParam("storesId",storesId)
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        return storeMap;
    }

    @Step("Update store with perameter")
    public ValidatableResponse updatestore(int storesId,String name,String type,String address,String city ,String state,String zip,String hours,Object lat,Object lng,HashMap<Object,Object> services) {
            HashMap<Object,Object> services1 = new HashMap<>();
            StorePojo storePojo = new StorePojo();
            storePojo.setName(name);
            storePojo.setType(type);
            storePojo.setAddress(address);
            storePojo.setCity(city);
            storePojo.setState(state);
            storePojo.setZip(zip);
            storePojo.setLat(lat);
            storePojo.setLng(lng);
            storePojo.setHours(hours);
            storePojo.setServices(services1);

            return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(storePojo)
                .when()
                .pathParam("storesId",storesId)
                .patch(EndPoints.UPDATE_STORE_BY_ID)
                .then();
    }

    @Step("Deleting store information with product")
    public ValidatableResponse deletestore(int storesId) {
        return SerenityRest.given().log().all()
                .pathParam("storesId", storesId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then();

    }

    @Step("Getting store information with productId")
    public ValidatableResponse getstoreById(int storesId) {
        return SerenityRest.given().log().all()
                .pathParam("storesId",storesId)
                .when()
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then();
    }@Step("Getting All users information")
    public ValidatableResponse getAllUsers(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORE)
                .then();
    }
}