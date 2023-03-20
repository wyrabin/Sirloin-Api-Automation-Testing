package starter.Sirloin.CustomersStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.CustomerAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class InputCustomerStepDef {

    @Steps
    CustomerAPI customerAPI;

    @Given("Post inputCustomer with valid json")
    public void postInputCustomerWithValidJson() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerValid.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @When("Send request inputCustomer")
    public void sendRequestInputCustomer() {
        SerenityRest.when().post(CustomerAPI.INPUT_CUSTOMER);
    }

    @Given("Post inputCustomer with invalid json")
    public void postInputCustomerWithInvalidJson() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerInvalid.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @Given("Post inputCustomer with registered email")
    public void postInputCustomerWithRegisteredEmail() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerRegisteredEmail.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @Given("Post inputCustomer with registered phone number")
    public void postInputCustomerWithRegisteredPhoneNumber() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerRegisteredPhone.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @Given("Post inputCustomer without email")
    public void postInputCustomerWithoutEmail() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerWithoutEmail.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @Given("Post inputCustomer without name")
    public void postInputCustomerWithoutName() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerWithoutName.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @Given("Post inputCustomer without address")
    public void postInputCustomerWithoutAddress() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerWithoutAddress.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }

    @Given("Post inputCustomer without phone number")
    public void postInputCustomerWithoutPhoneNumber() {
        File json = new File(Constant.inputCUSTOMER_JSON_REQUEST + "/inputCustomerWithoutPhone.json");
        customerAPI.inputCustomer(json, Constant.TOKEN);
    }
}
