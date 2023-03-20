package starter.Sirloin.AuthStepDef.LoginStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.AuthAPI;
import starter.Sirloin.Utils.Constant;
import starter.Sirloin.Utils.SirloinResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {

    @Steps
    AuthAPI authAPI;

    @Given("Post login with valid email and password")
    public void postLoginWithValidEmailAndPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/validEmailPass.json");
        authAPI.postLogin(json);
    }

    @When("Send request login")
    public void sendRequestLogin() {
        SerenityRest.when().post(AuthAPI.POST_LOGIN);

    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema login")
    public void validateJsonSchemaLogin() {
        File jsonSchema = new File(Constant.LOGIN_JSON_SCHEMA + "/validEmailPassSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post login with invalid email and password")
    public void postLoginWithInvalidEmailAndPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/invalidEmailValidPass.json");
        authAPI.postLogin(json);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBe(String message) {
        SerenityRest.then().body(SirloinResponses.MESSAGE, equalTo(message));
    }

    @And("Validate json schema login negative case")
    public void validateJsonSchemaLoginNegativeCase() {
        File jsonSchema = new File(Constant.LOGIN_JSON_SCHEMA + "/negativeCaseLoginSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post login with empty email and valid password")
    public void postLoginWithEmptyEmailAndValidPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/emptyEmailValidPass.json");
        authAPI.postLogin(json);
    }

    @Given("Post login with valid email and empty password")
    public void postLoginWithValidEmailAndEmptyPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/validEmailEmptyPass.json");
        authAPI.postLogin(json);
    }

    @Given("Post login with valid email and invalid password")
    public void postLoginWithValidEmailAndInvalidPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/validEmailInvalidPass.json");
        authAPI.postLogin(json);
    }

    @Given("Post login with empty email and password")
    public void postLoginWithEmptyEmailAndPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/emptyEmailPass.json");
        authAPI.postLogin(json);
    }

    @Given("Post login with wrong combination email and password")
    public void postLoginWithWrongCombinationEmailAndPassword() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/wrongCombinationEmailPass.json");
        authAPI.postLogin(json);
    }

    @Given("Post login with unregistered email")
    public void postLoginWithUnregisteredEmail() {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/unregisteredEmail.json");
        authAPI.postLogin(json);
    }

    @Given("Post login with invalid path {int}")
    public void postLoginWithInvalidPath(int id) {
        File json = new File(Constant.LOGIN_JSON_REQUEST + "/validEmailPass.json");
        authAPI.invalidLoginPath(id, json);
    }

    @When("Send request login invalid path")
    public void sendRequestLoginInvalidPath() {
        SerenityRest.when().post(AuthAPI.LOGIN_INVALID_PATH);

    }
}

