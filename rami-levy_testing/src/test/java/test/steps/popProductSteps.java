package test.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.RamiLeviHomePage;
import test.enums.Enums;
import utils.TestContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class popProductSteps {
    TestContext testContext;
    RamiLeviHomePage ramiLeviHomePage;

    public popProductSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("i click a specific product")
    public void clickingAproduct(){
        this.ramiLeviHomePage=testContext.get(Enums.homepage);
        this.ramiLeviHomePage.checkProductDetails();
    }
    @Then("open popup for a product")
    public void popUpProduct(){
       this.ramiLeviHomePage.popUpProductDetails();
    }

    @And("get a barcode of the product {string}")
    public void getProductBarcode(String actualBarcode) {
        String expectedBarcode = this.ramiLeviHomePage.getProductBarcode().trim();
        // Extract only the numeric part from the expected barcode
        String expectedNumericPart = expectedBarcode.replaceAll("[^0-9]", "");
        assertEquals(expectedNumericPart, actualBarcode);
    }
}
