package test.steps;
import infrastructre.http.HttpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.ApiRequests;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import test.enums.Enums;
import utils.TestContext;

public class addToCartSteps {
    ApiRequests apiRequests;
    TestContext testContext;
    RamiLeviHomePage ramiLeviHomePage;
    public addToCartSteps(TestContext testContext) {
        this.testContext=testContext;
        apiRequests=new ApiRequests();
        ramiLeviHomePage=testContext.get(Enums.homepage);
    }

    @When("i add item number {string} to the cart")
    public void i_add_item_number_to_the_cart(String itemId) {
        HttpResponse httpResponse = apiRequests.addToCart(itemId);
        testContext.put(Enums.response,httpResponse);
        ramiLeviHomePage.refresh();
    }

    @Then("validate status code")
    public void alidatestatuscode() {
        HttpResponse httpResponse =testContext.get(Enums.response);
        Assertions.assertEquals(httpResponse.getStatus(),200);
    }

    @And("validate that the item in the cart")
    public void validatethattheiteminthecart() {
        Assertions.assertTrue(ramiLeviHomePage.isCartNotEmpty());
    }
}