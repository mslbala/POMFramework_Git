package testSuite;

import base.CommonUtil;
import base.FunctionalUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.ContactUsPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static base.FunctionalUtil.*;

public class TestContactUsPage extends CommonUtil {
    @Before
    public void beforeMethod() {
        System.out.println("I am in before method");
        takeScreenshot("ContactUs");
    }

    @Test
    public void fillContactUsPageForm() {
        HomePage.contactUsLink(driver).click();
        takeScreenshot("ContactUsLink");

        //to verify the contact us page element is located on the screen
        boolean elementDisplayed = isDisplayedOnScreen(ContactUsPage.subjectHeadingDropDown(driver));
        if (elementDisplayed) {
            System.out.println("Contact us page is loaded successfully");

        }

        //fill contact us page elements
//        WebElement headingDropDown = ContactUsPage.subjectHeadingDropDown(driver);
        selectValueByVisibleTextInDropdown(ContactUsPage.subjectHeadingDropDown(driver), "Customer service");
        ContactUsPage.emailAddress(driver).sendKeys("bala@test.com");
        takeScreenshot("EmailTest");
    }

    @After
    public void tearDown() {
        closeSession();
    }

}
