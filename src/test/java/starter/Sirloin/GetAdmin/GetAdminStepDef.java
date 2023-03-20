package starter.Sirloin.GetAdmin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.GetAdminSirloinAPI;
import starter.Sirloin.UsersSirloinAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class GetAdminStepDef {

    @Steps
    GetAdminSirloinAPI getAdminSirloinAPI;

    // /products/admin
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjUyfQ.5oXTsr3g2Uc_OGuVU05t8ZTwXw8KtIwAm0hFYcy7m9Q";

    @Given("Get Product Admin With Bearer Token on valid Path")
    public void getProductAdminWithBearerTokenOnValidPath() {
        getAdminSirloinAPI.GetProductAdminWithToken(token);
    }

    @When("Send request get product admin on valid path")
    public void sendRequestGetProductAdminOnValidPath() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_VALID_ADMIN);
    }

    @And("Validate json schema get product admin")
    public void validateJsonSchemaGetProductAdmin() {
        File jsonSchema = new File(Constant.ADMIN_JSON_SCHEMA + "/GetUserValidParamSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get Product Admin with Bearer Token on invalid Path")
    public void getProductAdminWithBearerTokenTokenOnInvalidPath() {
        getAdminSirloinAPI.GetProductAdminWithInvalidPath(token);
    }

    @When("Send request get product admin with invalid path")
    public void sendRequestGetProductAdminWithInvalidPath() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_INVALID_ADMIN);
    }

    @Given("Get Product Admin without Bearer Token on valid path")
    public void getProductAdminWithoutBearerTokenOnValidPath() {
        String withoutToken = "";
        getAdminSirloinAPI.GetProductAdminWithToken(withoutToken);
    }


    //     /transactions/admin
    @Given("Get Transaction Admin with Bearer Token on valid path")
    public void getTransactionAdminWithBearerTokenOnValidPath() {
        getAdminSirloinAPI.GetTransactionAdminWithToken(token);
    }

    @When("Send request get transaction admin with valid path")
    public void sendRequestGetTransactionAdminWithValidPath() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_VALID_TRANSACTION);
    }

    @Given("Get Transaction Admin with Bearer Token on invalid path")
    public void getTransactionAdminWithBearerTokenOnInvalidPath() {
        getAdminSirloinAPI.GetTransactionAdminOnInvalidPath(token);
    }

    @When("Send request get transaction admin with invalid path")
    public void sendRequestGetTransactionAdminWithInvalidPath() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_INVALID_TRANSACTION);
    }

    @Given("Get Transaction Admin without Bearer Token on valid path")
    public void getTransactionAdminWithoutBearerTokenOnValidPath() {
        String withoutToken = "";
        getAdminSirloinAPI.GetTransactionAdminWithToken(withoutToken);
    }


    // /Transaction/id/admin
    @Given("Get admin Transaction history with valid id {int} on valid path")
    public void getAdminTransactionHistoryWithValidIdOnValidPath(int id) {
        getAdminSirloinAPI.GetTransactionHistoryValidID(token, id);
    }

    @When("Send request get admin transaction history on valid path")
    public void sendRequestGetAdminTransactionHistoryOnValidPath() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_VALID_TRANSACTION_HISTORY);
    }

    @Given("Get admin Transaction history with invalid id {string} on invalid path")
    public void getAdminTransactionHistoryWithInvalidIdOnInvalidPath(String id) {
        getAdminSirloinAPI.GetTransactionHistoryInvalidID(token, id);
    }

    @When("Send request get admin transaction history on invalid path")
    public void sendRequestGetAdminTransactionHistoryOnInvalidPath() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_INVALID_TRANSACTION_HISTORY);
    }

    @Given("Get admin Transaction history with empty {string} on valid path")
    public void getAdminTransactionHistoryWithEmptyIdOnValidPath(String id) {
        getAdminSirloinAPI.GetTransactionHistoryEmptyID(token, id);
    }

    @Given("Get admin Transaction history with valid id {int} on invalid path")
    public void getAdminTransactionHistoryWithValidIdOnInvalidPath(int id) {
        getAdminSirloinAPI.GetTransactionHistoryValidID(token, id);
    }


    @When("Send request get admin transaction history on empty id")
    public void sendRequestGetAdminTransactionHistoryOnEmptyId() {
        SerenityRest.when().get(GetAdminSirloinAPI.GET_EMPTYID_TRANSACTION_HISTORY);
    }
}