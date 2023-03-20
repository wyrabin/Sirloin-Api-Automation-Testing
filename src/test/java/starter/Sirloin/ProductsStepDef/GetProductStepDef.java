package starter.Sirloin.ProductsStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.ProductAPI;
import starter.Sirloin.Utils.Constant;
import starter.Sirloin.Utils.SirloinResponses;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class GetProductStepDef {

    @Steps
    ProductAPI productAPI;

    @Given("Get display all product")
    public void getDisplayAllProduct() {
        productAPI.getProduct(Constant.TOKEN);
    }

    @When("Send request getproduct")
    public void sendRequestGetproduct() {
        SerenityRest.when().get(ProductAPI.GET_PRODUCT);
    }

    @And("Validate json schema getProduct")
    public void validateJsonSchemaGetProduct() {
        File jsonSchema = new File(Constant.getPRODUCT_JSON_SCHEMA + "/getAllProductSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get display product by id {int}")
    public void getDisplayProductById(int id) {
        productAPI.getProductById(id, Constant.TOKEN);
    }

    @When("Send request getproduct by id")
    public void sendRequestGetproductById() {
        SerenityRest.when().get(ProductAPI.GET_PRODUCT_ByID);
    }

    @And("Validate json schema getProduct by id")
    public void validateJsonSchemaGetProductById() {
        File jsonSchema = new File(Constant.getPRODUCT_JSON_SCHEMA + "/getProductByIdSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get display product by invalid {string}")
    public void getDisplayProductByInvalid(String id) {
        productAPI.getProductInvalidID(id, Constant.TOKEN);
    }

    @When("Send request getproduct by invalid id")
    public void sendRequestGetproductByInvalidId() {
        SerenityRest.when().get(ProductAPI.GET_PRODUCT_INVALID_ID);
    }

    @And("Response body should be {string}")
    public void responseBodyShouldBe(String message) {
        SerenityRest.then()
                .body(containsString(message)); // response body not in json but just string
    }

    @Given("Get display all product with valid token")
    public void getDisplayAllProductWithValidToken() {
        productAPI.getProduct(Constant.TOKEN);

    }

    @Given("Get display all product with invalid token")
    public void getDisplayAllProductWithInvalidToken() {
        productAPI.getProduct(Constant.INVALIDTOKEN);
    }

    @And("Validate json schema getProduct negative case")
    public void validateJsonSchemaGetProductNegativeCase() {
        File jsonSchema = new File(Constant.getPRODUCT_JSON_SCHEMA + "/negativeCaseGetProductSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get display all product without token")
    public void getDisplayAllProductWithoutToken() {
        productAPI.getProduct(Constant.WITHOUTTOKEN);
    }
}
