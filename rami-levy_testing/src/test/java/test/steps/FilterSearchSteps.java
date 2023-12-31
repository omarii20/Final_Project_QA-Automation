package test.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import test.enums.Enums;
import utils.TestContext;

public class FilterSearchSteps {

    private RamiLeviHomePage ramiLeviHomePage;

    public FilterSearchSteps(TestContext testContext) {
        this.ramiLeviHomePage=testContext.get(Enums.homepage);
    }

    @Given("I choose a fruit and vegetable feature")
    public void iChooseAFruitAndVegetableFeature() {
        this.ramiLeviHomePage.productSideBar();
    }

    @When("I press the filter button")
    public void iPressTheFilterButton() {
        this.ramiLeviHomePage.clickOnFilterIcon();
    }

    @And("I filter results by a specific category")
    public void iFilterResultsByASpecificCategory() {
        this.ramiLeviHomePage.selectFromItemsFilter();
    }

    @Then("the displayed product count should match the expect")
    public void theDisplayedProductCountShouldMatchTheExpect() {
        Assertions.assertTrue(this.ramiLeviHomePage.countProducts());
    }
}
