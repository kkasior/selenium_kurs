package sda.bdd.testing.first;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/sda.bdd.testing.first"
)
public class CalculatorTest {

}
