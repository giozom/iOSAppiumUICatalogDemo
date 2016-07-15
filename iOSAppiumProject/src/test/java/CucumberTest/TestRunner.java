package CucumberTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Feature"
        ,glue = {"StepDefinition"}
        ,monochrome = true
        ,tags = {"@Test"}
        ,format = {"pretty","json:target/cucumber.json","html:target/site/cucumber-pretty",}
)

public class TestRunner {

}
