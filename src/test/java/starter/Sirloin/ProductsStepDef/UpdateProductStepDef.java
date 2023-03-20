package starter.Sirloin.ProductsStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.ProductAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class UpdateProductStepDef {

    @Steps
    ProductAPI productAPI;

    @Given("Put updateProduct with valid parameter {int}")
    public void putUpdateProductWithValidParameter(int id) {
        File json = new File(Constant.putPRODUCT_JSON_REQUEST + "/updateProductValid.json");
        productAPI.updateProduct(json, id, Constant.TOKEN);
    }

    @When("Send request updateProduct")
    public void sendRequestUpdateProduct() {
        SerenityRest.when().put(ProductAPI.PUT_PRODUCT);
    }

    @And("Validate json schema updateProduct")
    public void validateJsonSchemaUpdateProduct() {
        File jsonSchema = new File(Constant.putPRODUCT_JSON_SCHEMA + "/updateProductSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Put updateProduct with invalid parameter {string}")
    public void putUpdateProductWithInvalidParameter(String id) {
        File json = new File(Constant.putPRODUCT_JSON_REQUEST + "/updateProductValid.json");
        productAPI.updateProductInvalidID(json, id, Constant.TOKEN);
    }

    @Given("Put updateProduct with valid token and id {int}")
    public void putUpdateProductWithValidTokenAndId(int id) {
        File json = new File(Constant.putPRODUCT_JSON_REQUEST + "/updateProductValid.json");
        productAPI.updateProduct(json, id, Constant.TOKEN);
    }

    @Given("Put updateProduct with invalid token and id {int}")
    public void putUpdateProductWithInvalidTokenAndId(int id) {
        File json = new File(Constant.putPRODUCT_JSON_REQUEST + "/updateProductValid.json");
        productAPI.updateProduct(json, id, Constant.INVALIDTOKEN);
    }

    @Given("Put updateProduct with invalid json and id {int}")
    public void putUpdateProductWithInvalidJsonAndId(int id) {
        File json = new File(Constant.putPRODUCT_JSON_REQUEST + "/updateProductInvalid.json");
        productAPI.updateProduct(json, id, Constant.TOKEN);
    }

    @When("Send request updateProduct Invalid")
    public void sendRequestUpdateProductInvalid() {
        SerenityRest.when().put(ProductAPI.PUT_PRODUCT_INVALID_ID);
    }
}
