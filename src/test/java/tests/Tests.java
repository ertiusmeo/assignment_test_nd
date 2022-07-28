package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.FAQPage;

public class Tests extends BaseTest {

    @Test
    public void Assignment() {

        FAQPage faqPage = new FAQPage(driver);

        faqPage.clickAcceptAllCookies();
        System.out.println(faqPage.getLatestNewsHeader());
        System.out.println(faqPage.getLatestNewsLinks().size());
        System.out.println(faqPage.getLatestNewsLinks().get(1).getAttribute("href"));

        Assert.assertTrue(faqPage.getLatestNewsLinks().size() > 0);

        faqPage.getLatestNewsLinks().get(1).click();

        Assert.assertEquals("Personal", faqPage.getBroadCrumbLinks().get(0).getText());
        Assert.assertEquals("Security", faqPage.getBroadCrumbLinks().get(1).getText());

    }

}
