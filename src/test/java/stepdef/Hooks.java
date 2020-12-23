package stepdef;

import base.CommonUtil;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    CommonUtil commonUtil;
    Scenario scenario;

    @Before
    public void beforeScenario() {
        System.out.println("Before scenario");
        commonUtil = new CommonUtil();
        System.out.println("Before scenario");
    }

    @BeforeStep
    public void beforeStep()
    {
        System.out.println("In before step");
        CommonUtil.takeScreenshot();
    }
    @AfterStep
    public void afterStep(Scenario scenario)
    {
        System.out.println("In after step");
        byte[] screenshotAs = ((TakesScreenshot) CommonUtil.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotAs,"image/png","screenshot1");
//        scenario.e
        CommonUtil.takeScreenshot();
    }

    @After
    public void afterScenario() {
        System.out.println("After scenario-check if git pull is reflected");
        CommonUtil.closeSession();
    }
}
