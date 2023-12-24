package logic;

import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static utils.Utils.extractTokenFromJson;
import static utils.Utils.myWait;

public class LoginPage extends BasePage {

    private By userInput = By.id("email");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[@aria-label='כניסה']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String password) {
        getDriver().findElement(userInput).sendKeys(user);
        getDriver().findElement(passwordInput).sendKeys(password);
        myWait(3000);
        getDriver().findElement(loginButton).click();

    }

    public String getToken() {
        myWait(5000);
        JavascriptExecutor js = (JavascriptExecutor) super.getDriver();
        String localstorage = (String) js.executeScript("return localStorage.getItem('ramilevy');");
        String accessToken=extractTokenFromJson(localstorage);
        return accessToken;

    }

}
