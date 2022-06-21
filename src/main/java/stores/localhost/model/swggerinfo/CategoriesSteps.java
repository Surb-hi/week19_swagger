package stores.localhost.model.swggerinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import stores.localhost.model.constants.EndPoints;
import stores.localhost.model.model.CategoriesPojo;

import java.util.HashMap;

public class CategoriesSteps {
    @Step("Creating categories with perameter")
    public ValidatableResponse createcategories(String name,String id) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId(id);
        categoriesPojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(EndPoints.CREATE_CATEGORIES)
                .then();
    }

    @Step("Getting the categories information from Id")
    public HashMap<String, Object> getCreatedcategoriesId(String categoriesid) {

        HashMap<String, Object> categoriesMap = SerenityRest.given().log().all()
                  .when()
                .pathParam("categoriesid",categoriesid)
                .get(EndPoints.GET_SINGLE_CATEGORIES_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        return categoriesMap;
    }

    @Step("Update categories with perameter")
    public ValidatableResponse updatecategories(String categoriesid,String name,String id) {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId(id);
        categoriesPojo.setName(name);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .pathParam("categoriesid",categoriesid)
                .patch(EndPoints.UPDATE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Deleting categories information with product")
    public ValidatableResponse deletecategories(String categoriesid) {
        return SerenityRest.given().log().all()
                .pathParam("categoriesid",categoriesid )
                .when()
                .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("Getting categories information with productId")
    public ValidatableResponse getcategoriesById(String categoriesid) {
        return SerenityRest.given().log().all()
                .pathParam("categoriesid",categoriesid)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES_BY_ID)
                .then();
    }
    @Step("Getting All users information")
    public ValidatableResponse getAllCategories(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_CATEGORIES_ALL)
                .then();
    }
}
