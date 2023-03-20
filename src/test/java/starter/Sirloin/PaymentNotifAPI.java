package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class PaymentNotifAPI {

    public static String PAYMENT_NOTIFICATION = Constant.BASE_URL +"/paymentnotification";

    @Step("Post payment notification")
    public void paymentNotif(String token, File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
