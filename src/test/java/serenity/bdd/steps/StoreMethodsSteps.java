//package serenity.bdd.steps;
//
//import io.restassured.response.Response;
//import net.serenitybdd.rest.SerenityRest;
//import net.thucydides.core.annotations.Step;
//import org.jbehave.core.annotations.Given;
//import org.jbehave.core.annotations.Then;
//import org.jbehave.core.annotations.When;
//
//public class StoreMethodsSteps {
//
//    private String baseUrl = "https://petstore.swagger.io/v2/store/";
//    private Response response;
//
//    @Step
//    public void goToResource(String resource,String ID){
//        response = SerenityRest.when();
//    }
//
//    @Given("the user is on the Wikionary home page")
//    public void givenTheUserIsOnTheWikionaryHomePage() {
//        endUser.is_the_home_page();
//    }
//
//    @When("the user looks up the definition of the word '$word'")
//    public void whenTheUserLooksUpTheDefinitionOf(String word) {
//        endUser.looks_for(word);
//    }
//
//    @Then("they should see the definition '$definition'")
//    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
//        endUser.should_see_definition(definition);
//    }
//
//}
