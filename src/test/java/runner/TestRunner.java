package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/java/feature",glue= {"stepDefinition"},plugin= {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase {

}
