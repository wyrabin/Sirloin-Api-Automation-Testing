package starter.Sirloin.Utils;

public class Constant {

    public static String BASE_URL = "https://bluepath.my.id";

    public static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjU0fQ.4OjLwaZl68OM8zHYCSmNhD3S579V8n8JV0iT2GwAD6c";
    public static String INVALIDTOKEN = "invalid token";
    public static String WITHOUTTOKEN = "";
    public static final String DIR = System.getProperty("user.dir");
    public static String LOGIN_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/Login";
    public static String LOGIN_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/Login";
    public static String addPRODUCT_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/AddProduct";
    public static String addPRODUCT_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/AddProduct";
    public static String getPRODUCT_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/GetProduct";
    public static String putPRODUCT_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/UpdateProduct";
    public static String putPRODUCT_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/UpdateProduct";
    public static String deletePRODUCT_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/DeleteProduct";
    public static String inputCUSTOMER_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/InputCustomer";
    public static String editCUSTOMER_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/EditCustomer";

    public static String REGISTER_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/Register";
    public static String REGISTER_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/RegisterSchema";

    public static String USERS_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/UserTenant";
    public static String USERS_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/UserTenant";

    public static String ADMIN_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/GetAdmin";

    public static String POST_TRANSACTION_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/PostTransaction";
    public static String POST_TRANSACTION_JSON_SCHEMA = DIR + "/src/test/resources/JSON/JsonSchema/PostTransaction";
    public static String PAYMENTNOTIF_JSON_REQUEST = DIR + "/src/test/resources/JSON/Request/PaymentNotif";


}
