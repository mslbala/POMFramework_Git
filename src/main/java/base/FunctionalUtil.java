package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FunctionalUtil {
    private static WebDriver driver;

    public FunctionalUtil(WebDriver driver) {
        FunctionalUtil.driver = driver;
    }

    public static void actionsClick(WebElement element1, WebElement element2) {
        System.out.println("going to click using actions");
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).moveToElement(element2).click().perform();
    }

    public static boolean isDisplayedOnScreen(WebElement element) {
        boolean isDisplayed = element.isDisplayed();
//        Assert.assertEquals("Element " + element + " is displayed as expected",true,isDisplayed);
        if (isDisplayed) {
            System.out.println("Element " + element + " is displayed as expected");
        } else {
            System.out.println("Element " + element + " is not displayed as expected");
        }
        return isDisplayed;
    }
}
