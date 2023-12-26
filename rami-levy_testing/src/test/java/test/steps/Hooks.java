package test.steps;
import infrastructre.BrwoserWarpper;
import infrastructre.PropertiesWrapper;
import infrastructre.enums.Browser;
import io.cucumber.java.*;
import logic.RamiLeviHomePage;
import test.enums.Enums;
import utils.TestContext;

public class Hooks {
    private BrwoserWarpper browserwraber;
    private TestContext testContext;
    PropertiesWrapper propertiesWraper;

    public Hooks(TestContext testContext){
        propertiesWraper = new PropertiesWrapper();
        this.browserwraber= new BrwoserWarpper(Browser.CHROME);
        this.testContext = testContext;
    }

    @BeforeAll
    public static void setUp() {}

    @AfterAll
    public static void tearDown() {}

    @Before
    public void beforeEachTest() {
        browserwraber.initBrowser();
        testContext.put(Enums.driver,browserwraber.getDriver());
        browserwraber.getDriver().get(propertiesWraper.getProperties(Enums.URL));
        RamiLeviHomePage ramiLeviHomePage=new RamiLeviHomePage(browserwraber.getDriver());
        testContext.put(Enums.homepage,ramiLeviHomePage);
        ramiLeviHomePage.maxpage();
    }

    @After
    public void afterEachTest(Scenario scenario) {
        testContext.clear();
        browserwraber.closeDriver();
    }
}
