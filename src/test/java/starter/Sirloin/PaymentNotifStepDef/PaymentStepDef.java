package starter.Sirloin.PaymentNotifStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.CustomerAPI;
import starter.Sirloin.PaymentNotifAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class PaymentStepDef {

    @Steps
    PaymentNotifAPI paymentNotifAPI;

    @Given("Post paymentnotif with valid json")
    public void postPaymentnotifWithValidJson() {
        File json = new File(Constant.PAYMENTNOTIF_JSON_REQUEST + "/paymentNotif.json");
        paymentNotifAPI.paymentNotif(Constant.TOKEN, json);
    }

    @When("Send request paymentnotif")
    public void sendRequestPaymentnotif() {
        SerenityRest.when().post(PaymentNotifAPI.PAYMENT_NOTIFICATION);
    }

    @Given("Post paymentnotif with invalid json")
    public void postPaymentnotifWithInvalidJson() {
        File json = new File(Constant.PAYMENTNOTIF_JSON_REQUEST + "/paymentNotifInvalid.json");
        paymentNotifAPI.paymentNotif(Constant.TOKEN, json);
    }

    @Given("Post paymentnotif with token")
    public void postPaymentnotifWithToken() {
        File json = new File(Constant.PAYMENTNOTIF_JSON_REQUEST + "/paymentNotif.json");
        paymentNotifAPI.paymentNotif(Constant.TOKEN, json);
    }

    @Given("Post paymentnotif with invalid token")
    public void postPaymentnotifWithInvalidToken() {
        File json = new File(Constant.PAYMENTNOTIF_JSON_REQUEST + "/paymentNotif.json");
        paymentNotifAPI.paymentNotif(Constant.INVALIDTOKEN, json);
    }
}
