package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FAQPage extends Page {

    public FAQPage(WebDriver driver) {
        super(driver);
    }

    By latestNewsHeader = By.className("medium-h4");
    By latestNewsCard = By.xpath("//*[@class='content-card card card--margin-bottom']");


    public String getLatestNewsHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(latestNewsHeader)).getText();
    }

    public List<WebElement> getLatestNewsLinks() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(latestNewsCard)).findElements(By.xpath(".//a[@href]"));
    }


}
