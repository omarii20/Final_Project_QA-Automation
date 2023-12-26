package test.steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.RamiLeviHomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import test.enums.Enums;
import utils.TestContext;

import static utils.Utils.myWait;

public class ProductPageSideBar {
    TestContext testContext;
    WebDriver driver;
    RamiLeviHomePage ramiLeviHomePage;

    public ProductPageSideBar(TestContext testContext) {
        this.testContext = testContext;
        this.ramiLeviHomePage=testContext.get(Enums.homepage);
        driver=testContext.get(Enums.driver);
    }

    @When("i click product my product")
    public void iClickProduct() {
        this.ramiLeviHomePage.getProductSideBarList();
    }
    @Then("validate the product page")
    public void navigateToTheProductPage() {
        myWait(2000);
       String currentUrl= driver.getCurrentUrl();
       Assertions.assertEquals("https://www.rami-levy.co.il/he/online/market/%D7%A4%D7%99%D7%A8%D7%95%D7%AA-%D7%95%D7%99%D7%A8%D7%A7%D7%95%D7%AA",currentUrl);
    }
}
