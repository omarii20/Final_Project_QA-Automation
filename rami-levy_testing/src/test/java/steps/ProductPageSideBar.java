package steps;

import infrastructre.PropertiesWrapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.RamiLeviHomePage;
import org.openqa.selenium.WebDriver;
import utils.TestContext;

public class ProductPageSideBar {
    TestContext testContext;
    WebDriver driver;
    RamiLeviHomePage ramiLeviHomePage;

    public ProductPageSideBar(TestContext testContext) {
        this.testContext = testContext;
        driver=testContext.get("driver");
    }

    @When("i click product my product")
    public void iClickProduct() {
        this.ramiLeviHomePage=testContext.get("homepage");
        this.ramiLeviHomePage.getProductSideBarList();


    }
    @Then("navigate to the product page")

    public void navigateToTheProductPage() {
       String currentUrl= driver.getCurrentUrl();
       currentUrl.equals("https://www.rami-levy.co.il/he/online/market/%D7%A4%D7%99%D7%A8%D7%95%D7%AA-%D7%95%D7%99%D7%A8%D7%A7%D7%95%D7%AA");
    }
}
