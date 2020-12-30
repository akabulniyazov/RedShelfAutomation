package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        WebDriver driver= Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario(Scenario scenario){
        Driver.closeDriver();
    }
}
