//
//import io.restassured.response.Response;
//import net.serenitybdd.rest.SerenityRest;
//import net.thucydides.core.annotations.Step;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.hasItem;
//
//public class EndUserSteps {
//    Response POSTresponse;
//
//    String jsonBody ="{\n" +
//            "\"id\":2,\n" +
//            "\"petId\":1,\n" +
//            "\"quantity\":0,\n" +
//            "\"shipDate\":\"2019-12-07T20:28:34.606Z\",\n" +
//            "\"status\":\"placed\",\n" +
//            "\"complete\":true\n" +
//            "}";
//
//    @Step
//    public void postMethod(String jsonBody) {
//
//
//        //response = SerenityRest.when().post("https://petstore.swagger.io/v2/store/order").body(jsonBody);
//    }
//
//
//}