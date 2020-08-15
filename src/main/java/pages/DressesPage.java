package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DressesPage {

    public static WebElement element = null;

    public static WebElement noOfResults(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[@class='heading-counter']"));
        return element;
    }

}
