package starter.Sirloin.UserTenant;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.RegisterSirloinAPI;
import starter.Sirloin.UsersSirloinAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class UserTenantStepDef {

    @Steps
    UsersSirloinAPI usersSirloinAPI;

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjUyfQ.5oXTsr3g2Uc_OGuVU05t8ZTwXw8KtIwAm0hFYcy7m9Q";

    @Given("Get users tenant with valid path")
    public void getUsersTenantWithValidPath() {
        usersSirloinAPI.GetTenantWithValidParameter(token);
    }

    @When("Send request get users tenant with valid path")
    public void sendRequestGetUsersTenantWithValidPath() {
        SerenityRest.when().get(UsersSirloinAPI.GET_VALIDUSER_TENANT);

    }

    @Then("Response code should be {int} OK")
    public void responseCodeShouldBeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema get user tenant")
    public void validateJsonSchemaGetUserTenant() {
        File jsonSchema = new File(Constant.USERS_JSON_SCHEMA + "/GetUserValidParamSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get users tenant with invalid path")
    public void getUsersTenantWithInvalidPath() {
        usersSirloinAPI.GetTenantWithInvalidParameter();
    }

    @When("Send request get users tenant with invalid path")
    public void sendRequestGetUsersTenantWithInvalidPath() {
        SerenityRest.when().get(UsersSirloinAPI.GET_INVALIDUSER_TENANT);
    }

    @Given("authorization valid bearer token")
    public void authorizationValidBearerToken() {
        usersSirloinAPI.GetTenantWithToken(token);
    }

    @When("Send request get users tenant")
    public void sendRequestGetUsersTenant() {
        SerenityRest.when().get(UsersSirloinAPI.GET_VALIDUSER_TENANT);
    }

    @Given("authorization invalid bearer token")
    public void authorizationInvalidBearerToken() {
        String invalidToken = "123";
        usersSirloinAPI.GetTenantWithToken(invalidToken);
    }

    @Then("Response code should be {int} Unauthorized")
    public void responseCodeShouldBeUnauthorized(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("unauthorized without bearer token")
    public void unauthorizedWithoutBearerToken() {
        String withoutToken = "";
        usersSirloinAPI.GetTenantWithToken(withoutToken);
    }

    @Given("Get users tenant valid bearer token with invalid path")
    public void getUsersTenantValidBearerTokenWithInvalidPath() {
        usersSirloinAPI.GetTenantWithInvalidParam(token);
    }


    @Given("Put update tenant with valid json")
    public void putUpdateTenantWithValidJson() {
        File json = new File(Constant.USERS_JSON_REQUEST + "/PutUpdateValid.json");
        usersSirloinAPI.UpdateTenantWithJson(token, json);
    }

    @When("Send request update tenant")
    public void sendRequestUpdateTenant() {
        SerenityRest.when().put(UsersSirloinAPI.PUT_VALID_TENANT);
    }

    @Given("Put update tenant with invalid email json file")
    public void putUpdateTenantWithInvalidEmailJsonFile() {
        File json = new File(Constant.USERS_JSON_REQUEST + "/PutUpdateInvalidEmail.json");
        usersSirloinAPI.UpdateTenantWithJson(token, json);
    }


    @Given("Put update tenant with invalid phone number json file")
    public void putUpdateTenantWithInvalidPhoneNumberJsonFile() {
        File json = new File(Constant.USERS_JSON_REQUEST + "/PutUpdateInvalidPhone.json");
        usersSirloinAPI.UpdateTenantWithJson(token, json);
    }


    @Given("Put update tenant with invalid password json file")
    public void putUpdateTenantWithInvalidPasswordJsonFile() {
        File json = new File(Constant.USERS_JSON_REQUEST + "/PutInvalidPassword.json");
        usersSirloinAPI.UpdateTenantWithJson(token, json);
    }


    @Given("Put update tenant with valid json file on invalid path")
    public void putUpdateTenantWithValidJsonFileOnInvalidPath() {
        File json = new File(Constant.USERS_JSON_REQUEST + "/PutUpdateValid.json");
        usersSirloinAPI.PutTenantWithInvalidParameter(token, json);
    }

    @When("Send request update tenant with invalid path")
    public void sendRequestPutUsersTenantWithInvalidPath() {
        SerenityRest.when().put(UsersSirloinAPI.PUT_INVALID_TENANT);
    }

    @Given("Delete tenant with valid token on invalid path")
    public void deleteTenantWithValidTokenOnInvalidParam() {
        usersSirloinAPI.DeleteTenantWithInvalid(token);
    }

    @When("Send request delete tenant")
    public void sendRequestDeleteTenant() {
        SerenityRest.when().delete(UsersSirloinAPI.DELETE_INVALID_TENANT);
    }
}