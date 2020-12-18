import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Add",
        plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"})
public class TestRunner {
}

