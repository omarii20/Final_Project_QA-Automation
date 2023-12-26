package test.steps;
import infrastructre.PropertiesWrapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.LoginPage;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import test.enums.Enums;
import utils.TestContext;

public class LoginSteps {

    TestContext testContext;
    RamiLeviHomePage ramiLeviHomePage;
    PropertiesWrapper propertiesWraper;


    public LoginSteps(TestContext testContext){
        this.testContext=testContext;
        propertiesWraper=new PropertiesWrapper();
    }

    @Given("logged in user")
    public void loggedinuser() {
        iLoginWithUsernameAndPassword(propertiesWraper.getProperties(Enums.username),propertiesWraper.getProperties(Enums.password));
    }
    @When("i login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        this.ramiLeviHomePage=testContext.get(Enums.homepage);
        this.ramiLeviHomePage.maxpage();
        this.ramiLeviHomePage.clickLogin();
        LoginPage loginPage=new LoginPage(testContext.get(Enums.driver));
        loginPage.login(username,password);
        propertiesWraper.setProprieties(Enums.token,loginPage.getToken());
    }

    @Then("validate i am loged in with {string} user")
    public void validateIAmLogedInWithUser(String user) {
        Assertions.assertEquals(
            this.ramiLeviHomePage.getLoginUserText(),user
        );
    }


}
