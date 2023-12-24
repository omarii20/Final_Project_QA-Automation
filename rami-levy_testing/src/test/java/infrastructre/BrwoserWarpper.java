package infrastructre;

import infrastructure.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrwoserWarpper {

    private static WebDriver driver;
    private Browser browser;

    public BrwoserWarpper(String driverPath, Browser browser){
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver",driverPath);
                break;
            case EDGE:
                System.setProperty("webdriver.edge.driver",driverPath);
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver",driverPath);
                break;
        }
        this.browser=browser;
        this.setDriver(driver);
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
