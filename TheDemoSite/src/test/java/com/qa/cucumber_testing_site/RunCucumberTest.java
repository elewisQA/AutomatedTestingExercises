package com.qa.cucumber_testing_site;

//===[ Imports ]===
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//===[ Runner Method ]===
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:/target/logs/"},
		features = "src/test/resources/features",
		glue = ""
		)
public class RunCucumberTest {

}
