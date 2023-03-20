package starter.Sirloin.Transactions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.GetAdminSirloinAPI;
import starter.Sirloin.RegisterSirloinAPI;
import starter.Sirloin.TransactionSirloinAPI;
import starter.Sirloin.UsersSirloinAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class TransactionsStepDef {

    @Steps
    TransactionSirloinAPI transactionSirloinAPI;

    String tokenuser = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjI4fQ.0V4q0hauXP9H92SpeNell2RA4pRayvLpLxXAe2lsqRQ";


//    POST Transaction Create New User

    @Given("Post create new transaction unauthorized with valid json file")
    public void postCreateNewTransactionUnauthorizedWithValidJsonFile() {
        String withoutToken = "";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserValid.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(withoutToken, json);
    }

    @When("Send request post create new transaction")
    public void sendRequestPostCreateNewTransaction() {
        SerenityRest.when().post(TransactionSirloinAPI.POST_CREATE_VALID_TRANSACTION);
    }

    @Given("Post create new transaction authorized with valid bearer token user and valid json file")
    public void postCreateNewTransactionAuthorizedWithValidBearerTokenUserAndValidJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserValid.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    @And("Validate json schema post create new transaction")
    public void validateJsonSchemaPostCreateNewTransaction() {
        File jsonSchema = new File(Constant.POST_TRANSACTION_JSON_SCHEMA + "/PostTransactionUserValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post create new transaction authorized with invalid bearer token user")
    public void postCreateNewTransactionAuthorizedWithInvalidBearerTokenUser() {
        String invalidToken = "123";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserValid.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(invalidToken, json);
    }

    @Given("Post create new transaction authorized with valid bearer token super admin and valid json file")
    public void postCreateNewTransactionAuthorizedWithValidBearerTokenSuperAdminAndValidJsonFile() {
        String tokenSuperAdmin = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjF9.brX2nhQI3q12Vdid6TSD-NJc99O4t0bd08iXZ0_z5Do";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserValid.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenSuperAdmin, json);

    }

    @Given("Post Create new transaction Authorized with invalid path")
    public void postCreateNewTransactionAuthorizedWithInvalidPath() {
        transactionSirloinAPI.PostCreateNewTransactionWithInvalidPath(tokenuser);
    }

    @When("Send request post create new transaction invalid path")
    public void sendRequestPostCreateNewTransactionInvalidPath() {
        SerenityRest.when().post(TransactionSirloinAPI.POST_CREATE_INVALID_TRANSACTION);
    }

    @Given("Post Create new transaction authorized with not enough products json file")
    public void postCreateNewTransactionAuthorizedWithNotEnoughProductsJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserNotEnoughProducts.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    @Given("Post Create new transaction Authorized with invalid id products json file")
    public void postCreateNewTransactionAuthorizedWithInvalidIdProductsJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserInvalidProd.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    @Given("Post Create new transaction Authorized with invalid id customer json file")
    public void postCreateNewTransactionAuthorizedWithInvalidIdCustomerJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserInvalidIdCust.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    @Given("Post Create new transaction Authorized with empty products json file")
    public void postCreateNewTransactionAuthorizedWithEmptyProductsJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserEmptyProd.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    @Given("Post Create new transaction Authorized with empty quantity json file")
    public void postCreateNewTransactionAuthorizedWithEmptyQuantityJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserEmptyQuantity.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    @Given("Post Create new transaction Authorized with null payment method json file")
    public void postCreateNewTransactionAuthorizedWithNullPaymentMethodJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionUserEmptyPayMethod.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(tokenuser, json);
    }

    //    Get Sell/Buy History

    @Given("Get transaction sell order history with valid path")
    public void getTransactionSellOrderHistoryWithValidPath() {
        transactionSirloinAPI.GetHistoryTransactionWithValidParam(tokenuser);
    }

    @When("Send request get transaction sell order history valid path")
    public void sendRequestGetTransactionSellOrderHistory() {

        SerenityRest.when().get(TransactionSirloinAPI.GET_TRXVALID);

    }

    @Given("Get transaction sell order history with invalid path")
    public void getTransactionSellOrderHistoryWithInvalidPath() {
        transactionSirloinAPI.GetHistoryTransactionWithInvalidParam(tokenuser);
    }

    @When("Send request get transaction sell order history invalid path")
    public void sendRequestGetTransactionSellOrderHistoryInvalidPath() {
        SerenityRest.when().get(TransactionSirloinAPI.GET_TRXINVALID);
    }

//    PUT UPDATE TRANSACTION

    @Given("Put update transaction history with valid id {int} and valid bearer token")
    public void putUpdateTransactionHistoryWithValidIdAndValidBearerToken(int id) {
        transactionSirloinAPI.PutHistoryTransactionWithValidIdAndToken(tokenuser, id);
    }

    @When("Send request update transaction history")
    public void sendRequestUpdateTransactionHistory() {
        SerenityRest.when().put(TransactionSirloinAPI.PUT_TRANSACTION_HISTORY);
    }

    @Given("Put update transaction history with invalid id {string} and valid bearer token")
    public void putUpdateTransactionHistoryWithInvalidIdAndValidBearerToken(String id) {
        transactionSirloinAPI.PutHistoryTransactionWithInvalidIdAndToken(tokenuser, id);
    }

    @Given("Put update transaction history with valid id {int} and invalid bearer token")
    public void putUpdateTransactionHistoryWithValidIdAndInvalidBearerToken(int id) {
        String invalidToken = "123";
        transactionSirloinAPI.PutHistoryTransactionWithValidIdAndToken(invalidToken, id);
    }

    @Given("Put update transaction history without id {string} and valid bearer token")
    public void putUpdateTransactionHistoryWithoutAndValidBearerToken(String id) {
        transactionSirloinAPI.PutHistoryTransactionWithInvalidIdAndToken(tokenuser, id);
    }

    // POST /transactions/buy

    @Then("Response code should be {int}")
    public void responseCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Post transaction buy with valid authorized bearer token user and valid json file")
    public void postTransactionBuyWithValidAuthorizedBearerTokenUserAndValidJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyUserValid.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenuser, json);
    }

    @When("Send request post create transaction buy")
    public void sendRequestPostCreateTransactionBuy() {
        SerenityRest.when().post(TransactionSirloinAPI.POST_TRANSACTION_BUY_VALID);
    }

    @And("Validate json schema post create transaction buy user")
    public void validateJsonSchemaPostCreateTransactionBuyUser() {
        File jsonSchema = new File(Constant.POST_TRANSACTION_JSON_SCHEMA + "/PostTransactionBuyUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post transaction buy with valid authorized bearer token super admin and valid json file")
    public void postTransactionBuyWithValidAuthorizedBearerTokenSuperAdminAndValidJsonFile() {
        String tokenSuperAdmin = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjF9.brX2nhQI3q12Vdid6TSD-NJc99O4t0bd08iXZ0_z5Do";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyValidSA.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenSuperAdmin, json);
    }

    @And("Validate json schema post create transaction buy super admin")
    public void validateJsonSchemaPostCreateTransactionBuySuperAdmin() {
        File jsonSchema = new File(Constant.POST_TRANSACTION_JSON_SCHEMA + "/PostTransactionBuySASchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post transaction buy with invalid authorized bearer token user and valid json file")
    public void postTransactionBuyWithInvalidAuthorizedBearerTokenUserAndValidJsonFile() {
        String invalidTokenUser = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjF9.brX2nhQI3q12Vdid6TSD-NJc99O4t0bd08iXZ0_z5Do123";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyValidSA.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(invalidTokenUser, json);
    }

    @Given("Post transaction buy with invalid authorized bearer token super admin and valid json file")
    public void postTransactionBuyWithInvalidAuthorizedBearerTokenSuperAdminAndValidJsonFile() {
        String InvalidtokenSuperAdmin = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjF9.brX2nhQI3q12Vdid6TSD-NJc99O4t0bd08iXZ0_z5Do123";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyValidSA.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(InvalidtokenSuperAdmin, json);
    }

    @Given("Post transaction buy with valid authorized bearer token user and invalid product id json file")
    public void postTransactionBuyWithValidAuthorizedBearerTokenUserAndInvalidProductIdJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyInvalidIDProd.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenuser, json);
    }

    @Given("Post transaction buy with valid authorized bearer token super admin and invalid product id json")
    public void postTransactionBuyWithValidAuthorizedBearerTokenSuperAdminAndInvalidProductIdJson() {
        String tokenSuperAdmin = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjF9.brX2nhQI3q12Vdid6TSD-NJc99O4t0bd08iXZ0_z5Do";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyInvalidIDProd.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenSuperAdmin, json);
    }

    @Given("Post transaction buy with invalid authorized bearer token user and too much quantity product json file")
    public void postTransactionBuyWithInvalidAuthorizedBearerTokenUserAndTooMuchQuantityProductJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyOverQuantity.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenuser, json);

    }

    @Given("Post transaction buy with invalid authorized bearer token super admin and too much quantity product json file")
    public void postTransactionBuyWithInvalidAuthorizedBearerTokenSuperAdminAndTooMuchQuantityProductJsonFile() {
        String tokenSuperAdmin = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjF9.brX2nhQI3q12Vdid6TSD-NJc99O4t0bd08iXZ0_z5Do";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyOverQuantity.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenSuperAdmin, json);
    }

    @Given("Post transaction but with unauthorized bearer token user and valid json file")
    public void postTransactionButWithUnauthorizedBearerTokenUserAndValidJsonFile() {
        String withoutToken = "";
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyUserValid.json");
        transactionSirloinAPI.PostCreateNewTransactionWithToken(withoutToken, json);
    }

    @Given("Post transaction buy with valid authorized bearer token user and with null product json file")
    public void postTransactionBuyWithValidAuthorizedBearerTokenUserAndWithNullProductJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyNullProd.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenuser, json);

    }

    @Given("Post transaction buy with valid authorized bearer token user and invalid customer id json file")
    public void postTransactionBuyWithValidAuthorizedBearerTokenUserAndInvalidCustomerIdJsonFile() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyInvalidIDCust.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenuser, json);
    }

    @Given("Post transaction buy with valid authorized bearer token user and empty product id")
    public void postTransactionBuyWithValidAuthorizedBearerTokenUserAndEmptyProductId() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionEmptyIDProd.json");
        transactionSirloinAPI.PostHistoryTransactionBuyWithAuthorizedBearerToken(tokenuser, json);
    }

    @Given("Post transaction buy with valid authorized bearer token user and valid json file with invalid path")
    public void postTransactionBuyWithValidAuthorizedBearerTokenUserAndWithInvalidPath() {
        File json = new File(Constant.POST_TRANSACTION_JSON_REQUEST + "/PostTransactionBuyUserValid.json");
        transactionSirloinAPI.GetHistoryTransactionWithInvalidParam(tokenuser);
    }

    @When("Send request post create invalid transaction buy")
    public void sendRequestPostCreateInvalidTransactionBuy() {
        SerenityRest.when().post(TransactionSirloinAPI.POST_TRANSACTION_BUY_INVALID);
    }
}
