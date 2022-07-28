package tests;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static WebDriver driver;
    static String browser = PropertiesFile.readProperty("browser");


    @Before()
    public void setup() throws MalformedURLException {

        switch (browser) {
            case "Chrome" -> WebDriverManager.chromedriver().setup();
            case "IE" -> WebDriverManager.iedriver().setup();
            case "Firefox" -> WebDriverManager.firefoxdriver().setup();
            case "Edge" -> WebDriverManager.edgedriver().setup();
        }

        switch (browser) {
            case "Chrome" -> driver = new ChromeDriver();
            case "IE" -> driver = new InternetExplorerDriver();
            case "Firefox" -> driver = new FirefoxDriver();
            case "Edge" -> driver = new EdgeDriver();
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
