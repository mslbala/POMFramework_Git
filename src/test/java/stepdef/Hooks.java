package stepdef;

import base.CommonUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;


public class Hooks {
    CommonUtil commonUtil;

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
    public void afterStep()
    {
        System.out.println("In after step");
        CommonUtil.takeScreenshot();
    }

    @After
    public void afterScenario() {
        System.out.println("After scenario");
        CommonUtil.closeSession();
    }
}
