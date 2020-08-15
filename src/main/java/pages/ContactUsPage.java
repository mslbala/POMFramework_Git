package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    public static WebElement element = null;

    public static WebElement contactUsPageLabel(WebDriver driver) {
        element = driver.findElement(By.className("page-subheading"));
        return element;
    }
}
