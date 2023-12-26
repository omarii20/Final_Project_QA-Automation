package logic;
import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RamiLeviHomePage  extends BasePage {

    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String USER_NAME_LABEL = "//*[@id=\"login-user\"]/div/div/div[2]/div";
    private final String PRODUCT_SIDE_BAR ="//*[@id=\"main-menu-0\"]";
/// //*[@id="sale"]/a sales..
    private final String LOGOUT_BUTTON= "//*[@id=\"login-user\"]";
    private final String LOGOUT_WORD= "//*[@id=\"login-user\"]/div[2]";
    private WebElement loginButton;
    private WebElement userNameLabel;
    private WebElement productSideBar;
    private WebElement logOutButtont;
    private WebElement logoutWord;

    public RamiLeviHomePage(WebDriver driver) {
        super(driver);
        this.loginButton = this.getDriver().findElement(By.xpath(LOGIN_BUTTON));
    }

    public void clickLogin(){
        this.loginButton.click();
    }

    public String getLoginUserText(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.userNameLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(USER_NAME_LABEL)));
        return this.userNameLabel.getText();
    }
    public void getProductSideBarList(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.productSideBar=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRODUCT_SIDE_BAR)));;
        productSideBar.click();

    }
    public void logoutButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.logOutButtont=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGOUT_BUTTON)));;
        logOutButtont.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[3]/div/div[2]/div[4]/div/div[2]/div/div/div[7]/div"))).click();
    }
    public String LogoutWord(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        this.logoutWord= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGOUT_WORD)));;
        return (this.logoutWord.getText());

    }
}
