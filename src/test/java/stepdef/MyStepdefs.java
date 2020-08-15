package stepdef;

import base.CommonUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.DressesPage;
import pages.HomePage;

import static base.CommonUtil.takeScreenshot;

public class MyStepdefs {
//    CommonUtil commonUtil = new CommonUtil();

    @Given("User launches Automation Demo page")
    public void userLaunchesAutomationDemoPage() {
        System.out.println("User launched Automation demo page successfully");
//        takeScreenshot("HomePage");
        makeScreenShot();
    }

    @When("User enters the text {string} in search field and click Search")
    public void userEntersTheTextInSearchFieldAndClickSearch(String text) {
        HomePage.searchTextBox(CommonUtil.driver).sendKeys("Printed dress");
        System.out.println("User searched Printed dress in Home page");
        HomePage.searchButton(CommonUtil.driver).click();
//        takeScreenshot("SearchText");
        makeScreenShot();

    }

    @Then("User should be able to view all the {string}")
    public void userShouldBeAbleToViewAllThe(String text) {
//        takeScreenshot("DressesPage");
        String expectedTitle = "Search - My Store";
        String actualTitle = CommonUtil.driver.getTitle();
        Assert.assertEquals("Title" + expectedTitle + "in the page is as expected", expectedTitle, actualTitle);
        makeScreenShot();
    }

    @And("User should be able to {int} results found")
    public void userShouldBeAbleToResultsFound(int count) {
        String results = DressesPage.noOfResults(CommonUtil.driver).getText();
        System.out.println(results);
        int noOfActualResults = Integer.parseInt(results.split("results")[0].trim());
        System.out.println("Actual number of results displayed: " + noOfActualResults);
        Assert.assertEquals("Number of results match the expected", count, noOfActualResults);
        makeScreenShot();

    }

    @Attachment
    @And("Make screen shot of results page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) CommonUtil.driver).getScreenshotAs(OutputType.BYTES);
    }
}
