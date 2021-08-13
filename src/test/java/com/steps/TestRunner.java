package com.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHtmlReport"},
        features = "classpath:Features",
        glue = {"com.steps"},tags = {"@Test"}
)

public class TestRunner {
}