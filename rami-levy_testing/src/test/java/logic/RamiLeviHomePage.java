package logic;
import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RamiLeviHomePage  extends BasePage {

    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String USER_NAME_LABEL = "//div[@id=\"login-user\"]//span";

    private WebElement loginButton;
    private WebElement userNameLabel;
    public RamiLeviHomePage(WebDriver driver) {
        super(driver);
        this.loginButton = this.getDriver().findElement(By.xpath(LOGIN_BUTTON));
    }

    public void clickLogin(){
        this.loginButton.click();
    }

    public String getLoginUserText(){
        this.userNameLabel = this.getDriver().findElement(By.xpath(USER_NAME_LABEL));
        return this.userNameLabel.getText();
    }
}
