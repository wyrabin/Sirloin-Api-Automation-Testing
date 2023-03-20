package starter.Sirloin.AuthStepDef.RegisterStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.RegisterSirloinAPI;
import starter.Sirloin.Utils.Constant;
import starter.Sirloin.Utils.SirloinResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {
    @Steps
    RegisterSirloinAPI registerSirloinAPI;

    @Given("Post register tenant with valid json file")
    public void postRegisterTenantWithValidJsonFile() {
        File jsonFileRegisterValidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterTenantValid.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterValidTenant);
    }

    @When("Send request post register tenant")
    public void sendRequestPostRegisterTenant() {
        SerenityRest.when().post(RegisterSirloinAPI.POST_REGISTER_USER);
    }

    @Then("Response code should be {int} created")
    public void responseCodeShouldBeCreated(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain {int} and message {string}")
    public void responseBodyShouldContainsCodeAndMessage(int code, String message) {
        SerenityRest.then()
                .body(SirloinResponses.MESSAGE, equalTo(message))
                .body(SirloinResponses.CODE, equalTo(code));
    }

    @And("Validate json schema register tenant")
    public void validateJsonSchemaRegisterTenant() {
        File jsonSchema = new File(Constant.REGISTER_JSON_SCHEMA + "/RegisterValidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post register tenant without business name json file")
    public void postRegisterTenantWithInvalidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterTenantWithoutBusinessName.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Then("Response code should be {int} bad request")
    public void responseCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contains message {string}")
    public void responseBodyShouldContainsMessage(String message) {
        SerenityRest.then()
                .body(SirloinResponses.MESSAGE, equalTo(message));
    }

    @Given("Post register user already registered with valid json file")
    public void postRegisterUserAlreadyRegisteredWithValidJsonFile() {
        File jsonFileRegisterValidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterTenantValid.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterValidTenant);
    }

    @Given("Post register user with invalid format email on valid json file")
    public void postRegisterUserWithInvalidFormatEmailOnValidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterInvalidFormatEmail.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Given("Post register user with invalid format phone on valid json file")
    public void postRegisterUserWithInvalidFormatPhoneOnValidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterInvalidFormatPhone.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Given("Post register user with invalid Path")
    public void postRegisterUserWithInvalidPath() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterTenantValid.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @When("Send request post register user on invalid path")
    public void sendRequestPostRegisterUserOnInvalidPath() {
        SerenityRest.when().post(RegisterSirloinAPI.POST_REGISTERINVALID_USER);
    }

    @Then("API response status code should be {int} not found")
    public void apiResponseStatusCodeShouldBeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Post register user with invalid format password json file")
    public void postRegisterUserWithInvalidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterInvalidFormatPassword.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Given("Post register tenant without email invalid json file")
    public void postRegisterTenantWithoutEmailInvalidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterWithoutEmail.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Given("Post register tenant without password invalid json file")
    public void postRegisterTenantWithoutPasswordInvalidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterWithoutPassword.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Given("Post register tenant without phone invalid json file")
    public void postRegisterTenantWithoutPhoneInvalidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterWithoutPhone.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }

    @Given("Post register tenant without address invalid json file")
    public void postRegisterTenantWithoutAddressInvalidJsonFile() {
        File jsonFileRegisterInvalidTenant = new File(Constant.REGISTER_JSON_REQUEST + "/RegisterWithoutAddress.json");
        registerSirloinAPI.postRegisterUser(jsonFileRegisterInvalidTenant);
    }
}
