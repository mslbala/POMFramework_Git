package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtil {
    public static WebDriver driver;
    Properties properties = new Properties();
    public static EventFiringWebDriver eventFiringWebDriver;
    public static WebEventListener webEventListener;

    public CommonUtil() {
        try {
//            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
            driver = new ChromeDriver();

            eventFiringWebDriver = new EventFiringWebDriver(driver);
            webEventListener = new WebEventListener();
            eventFiringWebDriver.register(webEventListener);
            driver = eventFiringWebDriver;

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            properties.load(fileInputStream);
            String url = properties.getProperty("qa.url");
            System.out.println("Url is " + url);

            driver.get(url);
        } catch (FileNotFoundException e) {
            System.out.println("File not found to read properties file");
        } catch (Exception e) {
            System.out.println("Exception during browser set up" + e);
        }

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

    public static void selectValueByVisibleTextInDropdown(WebElement element, String valueToBeSelected) {
        new Select(element).selectByVisibleText(valueToBeSelected);
    }

    public static void takeScreenshot(String name) {
        System.out.println("going to take screenshot");
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotFilePath = System.getProperty("user.dir") + "/Screenshots/" +name+ System.currentTimeMillis() + ".png";
        File destinationFile = new File(screenshotFilePath);
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            System.out.println("There is a problem in taking screenshot and saving it");
        }
    }

    public static void takeScreenshot() {
        System.out.println("going to take screenshot");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
        Date date = new Date();
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
        System.out.println(screenshotName);
        File destinationFile = new File(screenshotName);
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            System.out.println("There is a problem in taking screenshot and saving it");
        }
    }


    public static void closeSession() {
        driver.quit();
        eventFiringWebDriver.unregister(webEventListener);
        System.out.println("driver closed!");
    }
}
