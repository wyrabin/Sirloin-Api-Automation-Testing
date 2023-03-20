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

public class DeleteProductStepDef {

    @Steps
    ProductAPI productAPI;

    @Given("Delete product with valid parameter id {int}")
    public void deleteProductWithValidParameterId(int id) {
        productAPI.deleteProduct(Constant.TOKEN, id);
    }

    @When("Send request deleteProduct")
    public void sendRequestDeleteProduct() {
        SerenityRest.when().delete(ProductAPI.DELETE_PRODUCT);
    }

    @And("Validate json schema deleteProduct")
    public void validateJsonSchemaDeleteProduct() {
        File jsonSchema = new File(Constant.deletePRODUCT_JSON_SCHEMA + "/deleteProductSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Delete product with invalid parameter {string}")
    public void deleteProductWithInvalidParameter(String id) {
        productAPI.deleteProductInvalidID(Constant.TOKEN, id);
    }

    @Given("Delete product with invalid token with id {int}")
    public void deleteProductWithInvalidTokenWithId(int id) {
        productAPI.deleteProduct(Constant.INVALIDTOKEN, id);
    }
}
