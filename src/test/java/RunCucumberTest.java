import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@HomePageTest",plugin = {"pretty", "html:target/Cucumber.html"})
/*@CucumberOptions(features = "src/test/java/resources/features/Login.feature",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/Cucumber.html"},
        monochrome = true)*/
public class RunCucumberTest {
}

