package steps;

import infrastructre.BrwoserWarpper;
import infrastructre.PropertiesWrapper;
import infrastructre.enums.Browser;
import io.cucumber.java.*;
import logic.LoginPage;
import logic.RamiLeviHomePage;
import utils.TestContext;

public class Hooks {



    private BrwoserWarpper browserwraber;
    private TestContext testContext;
    private Scenario scenario;
    PropertiesWrapper propertiesWraper;

    public Hooks(TestContext testContext){
        this.browserwraber= new BrwoserWarpper("chromedriver.exe", Browser.CHROME);
        this.testContext = testContext;
        propertiesWraper=new PropertiesWrapper();
    }

    @BeforeAll
    public static void setUp() {

    }

    @AfterAll
    public static void tearDown() {


    }

    @Before
    public void beforeEachTest(Scenario scenario) {
        this.scenario = scenario;
        browserwraber.initBrowser();
        testContext.put("driver",browserwraber.getDriver());

        browserwraber.getDriver().get(propertiesWraper.getProperties("URL"));
        RamiLeviHomePage ramiLeviHomePage=new RamiLeviHomePage(browserwraber.getDriver());
        ramiLeviHomePage.maxpage();
        ramiLeviHomePage.clickLogin();
        LoginPage loginPage=new LoginPage(browserwraber.getDriver());
        loginPage.login(propertiesWraper.getProperties("username"),propertiesWraper.getProperties("password"));
        //testContext.put("token",loginPage.getToken());
        testContext.put("homepage",ramiLeviHomePage);
        propertiesWraper.setProprieties("token",loginPage.getToken());

    }

    @After
    public void afterEachTest(Scenario scenario) {
        testContext.clear();
       // browserwraber.closeDriver();
    }




}
