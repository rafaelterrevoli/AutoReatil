package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Prueba.feature",
        glue = {"steps"},
        tags = {"@prueba"}

)
public class TestRunner {

}
