package steps;

import infrastructre.BrwoserWarpper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginPage;
import logic.RamiLeviHomePage;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class Steps {


    TestContext testContext;
    WebDriver driver;

    String URL = "https://www.rami-levy.co.il/he";


    public Steps(TestContext testContext){
        this.testContext=testContext;
        driver=this.testContext.get("driver");
    }
    @Given("Navigate to ramiLevy site")
    public void navigateToGoogleSite() {
        driver.get(URL);
    }


    @When("i press login")
    public void iPressLogin() {
        RamiLeviHomePage ramiLeviHomePage=new RamiLeviHomePage(driver);
        ramiLeviHomePage.clickLogin();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("shahdno2001@gmail.com","shahd2001");

    }

    @Then("navigate to login page")
    public void navigateToLogin() {
        assert (5==5);///check if the name appears in above

    }




}
