package steps;

import infrastructre.http.HttpResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.ApiRequests;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import utils.TestContext;

public class DeleteCartSteps {


    ApiRequests apiRequests;
    TestContext testContext;
    RamiLeviHomePage ramiLeviHomePage;
    public DeleteCartSteps(TestContext testContext) {
        this.testContext=testContext;
        apiRequests=new ApiRequests();
        ramiLeviHomePage=testContext.get("homepage");
    }


    @Given("item number {string} adde to the cart")
    public void item_adde_to_the_cart(String itemId) {
        HttpResponse httpResponse = apiRequests.addToCart(itemId);
    }

    @When("i click delete cart")
    public void i_click_delete_cart() {
        ramiLeviHomePage.deleteAllCart();
    }

    @Then("validate that the cart is empty")
    public void validatethattheiteminthecart() {
        Assertions.assertTrue(ramiLeviHomePage.isCartEmpty());
    }





}
