package logic;

import infrastructre.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static utils.Utils.extractNumber;
import static utils.Utils.myWait;

public class RamiLeviHomePage  extends BasePage {
    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String USER_NAME_LABEL = "//*[@id=\"login-user\"]/div/div/div[2]/div";
    private final String LOGOUT_BUTTON= "//*[@id=\"login-user\"]";
    private final String LOGOUT_WORD= "//*[@id=\"login-user\"]/div[2]";
    private final String PRODUCT_SIDE_BAR = "//*[@id=\"main-menu-0\"]";
    private final String SPECIFIC_BRODUCT = "(//div[@class=\"swiper-wrapper\"])[2]/div[2]";
    private final String BARCODE_PRODUCT = "//div[@class='barcode']";
    private final String DELETE_CART = "//*[@id=\"remove-cart\"]";
    private final String SEARCH_INPUT = "//*[@id=\"destination\"]";
    private final String SEARCH_BUTTON = "//*[@id=\"search\"]/div[2]/div/div[1]/div/div[2]/div/div/div[2]/div[2]/button[2]";
    private final String PRODUCT_LIST = "//div[@data-v-05fdeae9 and @data-v-2fc006d5 and contains(@class,\"min-height-product\")]";
    private final String FILTER_ICON = "//*[@id=\"search\"]/div/div/div[1]/div/div[1]/div/div[1]/div[3]";
    private final String CLICK_ON_SIDE_CATEGORY_OPTION = "//input[@id=\"filter-brand-858\"]/following-sibling::*";
    private final String ITEM_COUNT="//*[@id=\"__layout\"]/div/div[1]/div[1]/div[3]/div[3]/div/div[1]/div[2]/div/div[3]/div[5]/label";
  
    private int itemCount;
    private WebElement filterIcon ;
    private WebElement clickOnSideCategoryOption;
    private WebElement deleteCart;
    private WebElement searchInput ;
    private WebElement searchButton;
    private List<WebElement> productList;
    private WebElement loginButton;
    private WebElement userNameLabel;
    private WebElement productSideBar;
    private WebElement specificProduct;
    private WebElement barcodeNumber;
    private WebElement deleteCart;
    private WebElement logOutButtont;
    private WebElement logoutWord;

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

    public void deleteAllCart(){
        WebElement deleteCart=this.getDriver().findElement(By.xpath(DELETE_CART));
        deleteCart.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement deleteCartbtn= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"delete-cart-btn\"]")));
        deleteCartbtn.click();
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
  
    public void fillSearchInput(String text)
    {
        this.searchInput = this.driver.findElement(By.xpath(SEARCH_INPUT));
        this.searchInput.sendKeys(text);
    }
  
    public void clickOnSearchButton(){
        this.searchButton = this.driver.findElement(By.xpath(SEARCH_BUTTON));
        this.searchButton.click();
    }
  
    public List<WebElement> productList()
    {
        myWait(3000);
        this.productList = getDriver().findElements(By.xpath(PRODUCT_LIST));
        return productList;
    }
  
    public void productSideBar()
    {
        myWait(3000);
        this.productSideBar = getDriver().findElement(By.xpath(PRODUCT_SIDE_BAR));
        this.productSideBar.click();
    }
  
    public void clickOnFilterIcon()
    {
        this.filterIcon = this.driver.findElement(By.xpath(FILTER_ICON));
        this.filterIcon.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement filter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ITEM_COUNT)));
        itemCount = extractNumber(filter.getText());
    }
  
    public void selectFromItemsFilter()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        this.clickOnSideCategoryOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLICK_ON_SIDE_CATEGORY_OPTION)));
        this.clickOnSideCategoryOption.click();
        this.filterIcon.click();
    }

    public boolean countProducts() {
        List<WebElement> list=productList();
        if(list.size()==itemCount){
            return true;
        }
        return false;
    }
  
    public String getProductBarcode(){
        this.barcodeNumber = new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BARCODE_PRODUCT)));
        return barcodeNumber.getText();
    }
}
