package logic;
import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RamiLeviHomePage  extends BasePage {
    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String USER_NAME_LABEL = "//*[@id=\"login-user\"]/div/div/div[2]/div";
    private final String PRODUCT_SIDE_BAR = "//*[@id=\"main-menu-0\"]";
    private final String SPECIFIC_BRODUCT = "(//div[@class=\"swiper-wrapper\"])[2]/div[2]";
    private final String BARCODE_PRODUCT = "//div[@class='barcode']";
    private final WebElement loginButton;
    private WebElement userNameLabel;
    private WebElement productSideBar;
    private WebElement specificProduct;
    private WebElement barcodeNumber;

    public RamiLeviHomePage(WebDriver driver) {
        super(driver);
        this.loginButton = this.getDriver().findElement(By.xpath(LOGIN_BUTTON));
    }

    public void clickLogin() {
        this.loginButton.click();
    }

    public String getLoginUserText() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.userNameLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(USER_NAME_LABEL)));
        return this.userNameLabel.getText();
    }

    public boolean isCartNotEmpty() {
        List<WebElement> webElements = getDriver().findElements(By.xpath("//li[@data-v-1980ce6d]"));
        return !webElements.isEmpty();
    }

    public void getProductSideBarList () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.productSideBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRODUCT_SIDE_BAR)));
        productSideBar.click();
    }

    public void checkProductDetails(){
        this.specificProduct = new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SPECIFIC_BRODUCT)));
        specificProduct.click();
    }

    public void popUpProductDetails(){
        By POP_UP_PRODUCT =  By.xpath("//div[@class='main-product position-relative']");
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(POP_UP_PRODUCT));
    }

    public String getProductBarcode(){
        this.barcodeNumber = new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BARCODE_PRODUCT)));
        return barcodeNumber.getText();
    }
}
