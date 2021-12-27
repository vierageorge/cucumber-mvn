package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        strict = true,
        //plugin = {"pretty", "html:reports/Report1.html"},
        //tags = {"@P24"},
        name = {"Logo"}
)
public class TestRunner {
}
