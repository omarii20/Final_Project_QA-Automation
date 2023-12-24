package steps;

import infrastructre.PropertiesWrapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginPage;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class LoginSteps {

    TestContext testContext;
    WebDriver driver;
    RamiLeviHomePage ramiLeviHomePage;
    PropertiesWrapper propertiesWraper;


    public LoginSteps(TestContext testContext){
        this.testContext=testContext;
        driver=this.testContext.get("driver");
        propertiesWraper=new PropertiesWrapper();
    }
    @Given("Navigate to ramiLevy site")
    public void navigateToGoogleSite() {
        driver.get(propertiesWraper.getProperties("URL"));
    }

    @When("i login with user name {string} and password {string}")
    public void iLoginWithUserNameAndPassword(String username, String password) {
        this.ramiLeviHomePage=new RamiLeviHomePage(driver);
        this.ramiLeviHomePage.maxpage();
        this.ramiLeviHomePage.clickLogin();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
    }

    @Then("validate i am loged in with {string} user")
    public void validateIAmLogedInWithUser(String user) {
        Assertions.assertEquals(
                this.ramiLeviHomePage.getLoginUserText(),user
        );
    }
}
