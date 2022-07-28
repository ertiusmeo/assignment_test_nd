package tests;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static WebDriver driver;
    static String browser = PropertiesFile.readProperty("browser");


    @Before()
    public void setup() throws MalformedURLException {

        if ("Chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to(new URL("https://www.nordea.fi/en/personal/get-help/"));
    }

    @After()
    public void afterSuite() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

}
