package logic;
import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static utils.Utils.myWait;

public class RamiLeviHomePage  extends BasePage {

    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String USER_NAME_LABEL = "//*[@id=\"login-user\"]/div/div/div[2]/div";
    private final String PRODUCT_SIDE_BAR = "//*[@id=\"main-menu-0\"]";
    private final String DELETE_CART = "//*[@id=\"remove-cart\"]";



    private WebElement deleteCart;
    private WebElement loginButton;
    private WebElement userNameLabel;
    private WebElement productSideBar;

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
    public boolean isCartEmpty() {
        myWait(2000);
        List<WebElement> webElements = getDriver().findElements(By.xpath("//li[@data-v-1980ce6d]"));
        return webElements.isEmpty();
    }


    public void getProductSideBarList () {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.productSideBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRODUCT_SIDE_BAR)));
        productSideBar.click();
    }

    public void deleteAllCart(){
        WebElement deleteCart=this.getDriver().findElement(By.xpath(DELETE_CART));
        deleteCart.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement deleteCartbtn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"delete-cart-btn\"]")));
        deleteCartbtn.click();

    }
}
