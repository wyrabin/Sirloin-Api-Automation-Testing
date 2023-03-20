package starter.Sirloin;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

public class GetAdminSirloinAPI {

    public static String GET_VALID_ADMIN = Constant.BASE_URL + "/products/admin";
    public static String GET_INVALID_ADMIN = Constant.BASE_URL + "/products/admins";

    public static String GET_VALID_TRANSACTION = Constant.BASE_URL + "/transactions/admin";

    public static String GET_INVALID_TRANSACTION = Constant.BASE_URL + "/transactions/admins";

    public static String GET_VALID_TRANSACTION_HISTORY = Constant.BASE_URL + "/transactions/{id}/admin";
    public static String GET_INVALID_TRANSACTION_HISTORY = Constant.BASE_URL + "/transactions/{id}/admins";

    public static String GET_EMPTYID_TRANSACTION_HISTORY = Constant.BASE_URL + "/transactions/{id}/admin";


    // products admin
    @Step("Get product admin with authorization valid bearer token")
    public void GetProductAdminWithToken(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get tenant with authorization on invalid path")
    public void GetProductAdminWithInvalidPath(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    // transactions admin

    @Step("Get transaction admin with authorization valid bearer token")
    public void GetTransactionAdminWithToken(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get transaction admin on invalid path")
    public void GetTransactionAdminOnInvalidPath(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    // history admin

    @Step("Get transaction history with valid id")
    public void GetTransactionHistoryValidID(String token, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get transaction history with invalid id")
    public void GetTransactionHistoryInvalidID(String token, String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + token);
    }

    @Step("Get transaction history with empty id")
    public void GetTransactionHistoryEmptyID(String token, String id) {
        SerenityRest.given()
                .pathParam("id", id)
                .headers("Authorization", "Bearer " + token);
    }
}