package rest_api_23_Andris_Grindulis.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "junit:target/cucumber-reports/report.xml"},
        features = {"src/test/resources/features"},
        glue = {"rest_api_23_Andris_Grindulis/stepdefinitions"}
)
public class TestRunner {

}
