package starter.Sirloin;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

import static groovyjarjarantlr4.runtime.Token.INVALID_TOKEN;

public class UsersSirloinAPI {

    public static String GET_VALIDUSER_TENANT = Constant.BASE_URL + "/users";
    public static String GET_INVALIDUSER_TENANT = Constant.BASE_URL + "/userss";
    public static String PUT_VALID_TENANT = Constant.BASE_URL + "/users";
    public static String PUT_INVALID_TENANT = Constant.BASE_URL + "/userss";

    public static String DELETE_INVALID_TENANT = Constant.BASE_URL + "/userss";


    //GET USER
    @Step("Get tenant with authorization valid bearer token")
    public void GetTenantWithToken(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get tenant with authorization invalid parameter")
    public void GetTenantWithInvalidParam(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get tenant with valid parameter")
    public void GetTenantWithValidParameter(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get tenant with invalid parameter")
    public void GetTenantWithInvalidParameter() {
        SerenityRest.given();
    }

    @Step("Update tenant with valid json")
    public void UpdateTenantWithJson(String token, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update tenant with invalid parameter")
    public void PutTenantWithInvalidParameter(String token, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete tenant with invalid parameter")
    public void DeleteTenantWithInvalid(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }
}
