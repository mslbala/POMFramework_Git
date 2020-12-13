package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FunctionalUtil {
    private static WebDriver driver;

    public FunctionalUtil(WebDriver driver) {
        FunctionalUtil.driver = driver;
    }


}
