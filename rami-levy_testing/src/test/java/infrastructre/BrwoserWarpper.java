package infrastructre;

import infrastructre.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class BrwoserWarpper {

    private static WebDriver driver;
    private Browser browser;

    public BrwoserWarpper(Browser browser){
        String chromeDriverPath = checkOS();
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",chromeDriverPath);
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver",chromeDriverPath);
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver",chromeDriverPath);
                break;
        }
        this.browser=browser;
        this.setDriver(driver);
    }

    public String checkOS (){
        String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        String chromeDriverPath;
        if (os.contains("win")) {
            chromeDriverPath = "chromedriver.exe";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            chromeDriverPath = "chromedriver";
        } else {
            throw new IllegalStateException("Unsupported operating system: " + os);
        }
        return chromeDriverPath;
    }

    public  void initBrowser(){
        switch (this.browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                 driver = new EdgeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
    }

    public void closeDriver(){
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
