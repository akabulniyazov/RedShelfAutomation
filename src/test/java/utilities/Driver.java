package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

    private Driver() {}

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null||((RemoteWebDriver)driver).getSessionId()==null) {
            String browser = Configuration.getProperty("browser");
            if(browser.equalsIgnoreCase("firefox")){
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
            }else if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
