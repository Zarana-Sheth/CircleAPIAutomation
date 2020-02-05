import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"D:/Finastra_API_Automation/FinastraAPI_Automation/src/test/resources/FeatureFiles/TestDelete.feature"},
        plugin = {"json:D:/Finastra_API_Automation/FinastraAPI_Automation/target/cucumber-parallel/1.json"},
        monochrome = true,
        tags = {},
        glue = {"com.brillio.stepdefs"})
public class Parallel01IT {
}
