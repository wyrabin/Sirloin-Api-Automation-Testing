package starter.Sirloin;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class AuthAPI {

    public static String POST_LOGIN = Constant.BASE_URL + "/login";
    public static String LOGIN_INVALID_PATH = Constant.BASE_URL + "/login/{id}";

    @Step("Login tenant valid email password")
    public void postLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Login invalid path")
    public void invalidLoginPath(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
