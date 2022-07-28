package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page {

    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By breadcrumb = By.xpath("//*[contains(@class, 'breadcrumb row')and contains(@class, 'medium')]");
    By cookiesPopup = By.id("CookieReportsBanner");
    By btnAcceptAllCookies = (By.className("wscrOk"));

    public void clickAcceptAllCookies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesPopup)).findElement(btnAcceptAllCookies).click();
    }

    public List<WebElement> getBroadCrumbLinks() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(breadcrumb)).findElements(By.className("block-link"));
    }


}
