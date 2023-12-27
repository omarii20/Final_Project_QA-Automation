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
        this.driver.findElement(userInput).sendKeys(user);
        this.driver.findElement(passwordInput).sendKeys(password);
        myWait(3000);
        this.driver.findElement(loginButton).click();
        myWait(5000);
    }

    public String getToken() {
        myWait(5000);
        JavascriptExecutor js = (JavascriptExecutor) super.driver;
        String localstorage = (String) js.executeScript("return localStorage.getItem('ramilevy');");
        String accessToken = extractTokenFromJson(localstorage);
        return accessToken;
    }

}