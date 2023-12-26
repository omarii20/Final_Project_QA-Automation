package test.steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import test.enums.Enums;
import utils.TestContext;

public class LogoutSteps {
    TestContext testContext;
    RamiLeviHomePage ramiLeviHomePage;

    public LogoutSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("i press logout button")
    public void iPressLogoutButton() {
        this.ramiLeviHomePage=testContext.get(Enums.homepage);
        ramiLeviHomePage.logoutButton();
    }

    @Then("validate user loged out")
    public void validateuserlogedout() {
        Assertions.assertEquals(ramiLeviHomePage.LogoutWord(),"התחברות");

    }
}
