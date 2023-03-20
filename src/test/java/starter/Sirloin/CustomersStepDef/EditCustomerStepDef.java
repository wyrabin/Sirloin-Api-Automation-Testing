package starter.Sirloin.CustomersStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Sirloin.AuthStepDef.LoginStepDef.LoginStepDef;
import starter.Sirloin.CustomerAPI;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class EditCustomerStepDef {

    @Steps
    CustomerAPI customerAPI;

    @Given("Put editCustomer with valid id {int}")
    public void putEditCustomerWithValidId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(Constant.TOKEN, id, json);
    }

    @When("Send request editCustomer")
    public void sendRequestEditCustomer() {
        SerenityRest.when().put(CustomerAPI.EDIT_CUSTOMER_ByID);
    }

    @Given("Put editCustomer with invalid id {string}")
    public void putEditCustomerWithInvalidId(String id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerInvalidId(Constant.TOKEN, id, json);
    }

    @Given("Put editCustomer with valid json and id {int}")
    public void putEditCustomerWithValidJsonAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(Constant.TOKEN, id, json);

    }

    @Given("Put editCustomer with invalid json and id {int}")
    public void putEditCustomerWithInvalidJsonAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerInvalid.json");
        customerAPI.editCustomerById(Constant.TOKEN, id, json);
    }

    @Given("Put editCustomer with valid token and id {int}")
    public void putEditCustomerWithValidTokenAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(Constant.TOKEN, id, json);
    }

    @Given("Put editCustomer with invalid token and id {int}")
    public void putEditCustomerWithInvalidTokenAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(Constant.INVALIDTOKEN, id, json);
    }

    @Given("Put editCustomer without token and id {int}")
    public void putEditCustomerWithoutTokenAndId(int id) {
        File json = new File(Constant.editCUSTOMER_JSON_REQUEST + "/editCustomerValid.json");
        customerAPI.editCustomerById(Constant.WITHOUTTOKEN, id, json);
    }
}
