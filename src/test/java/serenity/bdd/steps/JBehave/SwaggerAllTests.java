package serenity.bdd.steps.JBehave;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import serenity.bdd.EnvironmentPropertyLoader;

public class SwaggerAllTests {

    private static Logger log = LoggerFactory.getLogger(SwaggerAllTests.class);

    Response resp;
    String BaseUrl = "https://petstore.swagger.io/v2";
    String URI="";

    String jsonBody = "{\n" +
            "\"id\":"+ EnvironmentPropertyLoader.getProperty("user.id")+",\n" +
            "\"petId\":1,\n" +
            "\"quantity\":0,\n" +
            "\"shipDate\":\"2019-12-07T20:28:34.606Z\",\n" +
            "\"status\":\"placed\",\n" +
            "\"complete\":true\n" +
            "}";

    //Common methods
    @Given("I have an endpoint $endpoint")
    public void getURI(String endpoint) {
        URI = BaseUrl + endpoint;
        log.info("URI is: "+URI);
        }


    //Scenario: I can see the all inventory
    @When("I perform a GET request to endpoint")
    public void getRequest() {
        resp = RestAssured.get(URI);
       log.info(resp.getStatusCode()+ "URI "+ URI);

   }



    @Then("I check that Inventory response body contains value '$code'")
    public void checkingStatusCodetoInclude(int code) {
        Assert.assertEquals(code, resp.getStatusCode());
        log.info(String.valueOf(resp.getStatusCode()));


    }


//Scenario: I can create new order

    //Cant set headers and body
    @When("I perform a POST request to endpoint")
    public void postRequestToServer() {
       resp = RestAssured.given().header("Content-Type", "application/json").body(jsonBody).when().post(URI);

        log.info(resp.getStatusCode()+ "URI "+ URI);
        log.info("Request is:\n"+ jsonBody);


    }


    //Scenario: I can delete the particular order by orderID
    @When("I perform a DELETE request to inventory endpoint")
    public void deletingItem() {
        // resp = RestAssured.get("https://petstore.swagger.io/v2/store/order/2");
        resp = RestAssured.delete(URI);

    }


    //Common methods
    @Then("I verify that status code is '$code'")
    public void checkingStatusCode(int code) {
        Assert.assertEquals(code, resp.getStatusCode());
        log.info(String.valueOf(resp.getStatusCode()));


    }

    @Then("I check that Inventory response body contains value $i")
    public void checkingJsonBody(int i) {
        String json = resp.asString();
        JsonPath jp = new JsonPath(json);
        Assert.assertEquals(i, jp.getInt("no"));
    }

    @Then("I check that NewOrder response body contains value $status")
    public void checkingJsonBody(String status) {
        String json = resp.asString();
        JsonPath jp = new JsonPath(json);
        Assert.assertEquals(status, jp.getString("status"));
    }


}
