package logic;

import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        getDriver().findElement(loginButton).click();
    }

}
