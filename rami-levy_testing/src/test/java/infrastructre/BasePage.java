package infrastructre;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;

    }
    public void refresh() {
        driver.navigate().refresh();
    }
    public void maxpage(){
        driver.manage().window().maximize();
    }
}