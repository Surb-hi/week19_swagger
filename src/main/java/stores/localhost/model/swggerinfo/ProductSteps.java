package stores.localhost.model.swggerinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import stores.localhost.model.constants.EndPoints;
import stores.localhost.model.model.ProductPojo;

import java.util.HashMap;

public class ProductSteps {
   @Step("Creating product with perameter")
    public ValidatableResponse createProduct( String name,String type,Object price,Object shipping,String upc,String description,String manufacturer,String model,String url,String image ){
        ProductPojo productDemo = new ProductPojo();
        productDemo.setName(name);
        productDemo.setType(type);
        productDemo.setPrice(price);
        productDemo.setUpc(upc);
        productDemo.setShipping(shipping);
        productDemo.setDescription(description );
        productDemo.setManufacturer(manufacturer);
        productDemo.setModel(model);
        productDemo.setUrl(url);
        productDemo.setImage(image);

       return SerenityRest.given().log().all()
               .contentType(ContentType.JSON)
               .body(productDemo)
               .when()
               .post(EndPoints.CREATE_PRODUCT)
               .then();
    }
    @Step("Getting the product information from Id")
    public HashMap<String, Object> getCreatedProductId(int productid) {
        HashMap<String, Object> productMap = SerenityRest.given().log().all()
                .when()
                .pathParam("productId",productid)
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        return productMap;
    }
    @Step("Update product with perameter")
    public ValidatableResponse updateProduct( int productid,String name,String type,Object price,Object shipping,String upc,String description,String manufacturer,String model,String url,String image ){
        ProductPojo productDemo = new ProductPojo();
        productDemo.setName(name);
        productDemo.setType(type);
        productDemo.setPrice(price);
        productDemo.setUpc(upc);
        productDemo.setShipping(shipping);
        productDemo.setDescription(description );
        productDemo.setManufacturer(manufacturer);
        productDemo.setModel(model);
        productDemo.setUrl(url);
        productDemo.setImage(image);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(productDemo)
                .when()
                .pathParam("productId",productid)
                .patch(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    } @Step("Deleting product information with product")
    public ValidatableResponse deleteproduct(int productid){
        return SerenityRest.given().log().all()
                .pathParam("productId", productid)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }
    @Step("Getting product information with productId")
    public ValidatableResponse getProductById(int productid){
        return SerenityRest.given().log().all()
                .pathParam("productId",productid)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then();
    }
    @Step("Getting All users information")
    public ValidatableResponse getAllproduct(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCT)
                .then();
    }


}
