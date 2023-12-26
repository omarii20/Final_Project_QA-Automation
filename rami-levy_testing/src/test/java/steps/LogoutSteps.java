package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class LogoutSteps {
    TestContext testContext;
    WebDriver driver;
    RamiLeviHomePage ramiLeviHomePage;

    public LogoutSteps(TestContext testContext) {
        this.testContext = testContext;
        driver=testContext.get("driver");
    }

    @When("i press logout button")
    public void iPressLogoutButton() {
        this.ramiLeviHomePage=testContext.get("homepage");
        ramiLeviHomePage.logoutButton();
    }

    @Then("navigate to guest page")
    public void navigateToGuestPage() {
        this.ramiLeviHomePage=testContext.get("homepage");
        Assertions.assertEquals(ramiLeviHomePage.LogoutWord(),"התחברות");

    }
}
