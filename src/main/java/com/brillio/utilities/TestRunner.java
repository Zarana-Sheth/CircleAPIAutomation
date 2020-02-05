package com.brillio.utilities;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"src/test/resources/FeatureFiles/TestGet.feature"},
plugin = {"json:target/cucumber-parallel/1.json"},
monochrome = true,
tags = {"@QA @Post_EmployeeFormSubmitAPI"},
glue = { "com.brillio.stepdefs" }
 
)

public class TestRunner {
	
	
}


