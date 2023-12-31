package test.steps;
import infrastructre.PropertiesWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginPage;
import logic.RamiLeviHomePage;
import org.openqa.selenium.WebDriver;
import test.enums.Enums;
import utils.TestContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchSteps {
    TestContext testContext;
    RamiLeviHomePage ramiLeviHomePage;

    public SearchSteps(TestContext testContext) {
        this.testContext = testContext;
        this.ramiLeviHomePage = testContext.get(Enums.homepage);
    }

    @When("I fill {string} in input search")
    public void iFillTextInInputSearch(String text) {
        ramiLeviHomePage.fillSearchInput(text);
    }

    @And("click search button")
    public void clickSearchButton() {
        ramiLeviHomePage.clickOnSearchButton();
    }

    @Then("Therefore I get a list of products")
    public void thereforeIGetAListOfProducts() {
        assertTrue(!ramiLeviHomePage.productList().isEmpty());
    }

}

