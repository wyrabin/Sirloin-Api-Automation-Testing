package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class RegisterSirloinAPI {

    public static String POST_REGISTER_USER = Constant.BASE_URL+"/register";
    public static String POST_REGISTERINVALID_USER =  Constant.BASE_URL+"/registers";

    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
