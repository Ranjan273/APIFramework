package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features="src/test/java/features",
                  glue= {"stepDefinations"})
@RunWith(Cucumber.class)
public class TestRunner {


}
