package starter.Sirloin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Sirloin.Utils.Constant;

import java.io.File;

public class TransactionSirloinAPI {

    public static String POST_CREATE_VALID_TRANSACTION = Constant.BASE_URL + "/transactions";
    public static String POST_CREATE_INVALID_TRANSACTION = Constant.BASE_URL + "/transactions123";
    public static String GET_TRXVALID = Constant.BASE_URL + "/transactions?status=sell";
    public static String GET_TRXINVALID = Constant.BASE_URL + "/transactions123?status=sell";

    public static String PUT_TRANSACTION_HISTORY = Constant.BASE_URL + "/transactions/{id}";

    public static String POST_TRANSACTION_BUY_VALID = Constant.BASE_URL + "/transactions/buy";
    public static String POST_TRANSACTION_BUY_INVALID = Constant.BASE_URL + "/transactions/buys";



    @Step("POST Create New Transaction Authorized with valid bearer token user")
    public void PostCreateNewTransactionWithToken(String token, File json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create New Transaction with invalid path")
    public void PostCreateNewTransactionWithInvalidPath(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("GET history transaction with valid parameter")
    public void GetHistoryTransactionWithValidParam(String token){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);

    }
    @Step("GET history transaction with invalid parameter")
    public void GetHistoryTransactionWithInvalidParam(String token) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token);
    }

    @Step("PUT history transaction with valid id and bearer token")
    public void PutHistoryTransactionWithValidIdAndToken(String token, int id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .pathParam("id", id);
    }

    @Step("PUT history transaction with invalid id and bearer token")
    public void PutHistoryTransactionWithInvalidIdAndToken(String token, String id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + token)
                .pathParam("id", id);
    }

    @Step("Post transaction buy with valid Authorized bearer token and valid json file")
    public void PostHistoryTransactionBuyWithAuthorizedBearerToken(String token, File json) {
            SerenityRest.given()
                    .headers("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(json);
    }
}
