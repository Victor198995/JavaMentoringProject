package serenity.bdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SwaggerTest {

    private static Logger log = LoggerFactory.getLogger(SwaggerTest.class);

    //GET inventory
    @Test
    public void getInventory(){
        given().log().uri().
                when().get("https://petstore.swagger.io/v2/store/inventory").
                then().body("scary", equalTo(4)).log().all().statusCode(200);


        log.info("getInventory request(GET method) has been sent");
        log.info("JSON has been validated");

    }

    //Place an order for a pet
    @Test
    public void placeAnOrder(){

        String jsonBody ="{\n" +
                "\"id\":2,\n" +
                "\"petId\":1,\n" +
                "\"quantity\":0,\n" +
                "\"shipDate\":\"2019-12-07T20:28:34.606Z\",\n" +
                "\"status\":\"placed\",\n" +
                "\"complete\":true\n" +
                "}";

        given().header("Content-Type","application/json").body(jsonBody).log().uri().
                when().post("https://petstore.swagger.io/v2/store/order").
                then().log().all().statusCode(200);

        log.info("placeAnOrder request(POST method) has been sent");
    }


    //Find purchase order by ID
    @Test
    public void getOrderByID(){
        given().log().uri().
                when().get("https://petstore.swagger.io/v2/store/order/2)").
                then().log().all();

        log.info("getOrderByID request(GET method) has been sent");
    }

    //Delete purchase order by ID
    @Test
    public void deleteOrderByID(){
        given().log().uri().
                when().get("https://petstore.swagger.io/v2/store/order/2").
                then().log().all().statusCode(200);

        log.info("deleteOrderByID request(DELETE method) has been sent");
    }


}
