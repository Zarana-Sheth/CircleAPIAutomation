package com.brillio.stepdefs;


import java.io.IOException;


import com.automation.framework.core.BaseTest;
import com.automation.framework.pojs.TestDriver;
import com.brillio.featureparser.Cucumber_Runner;

import com.brillio.utilities.CucumberDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	
	Cucumber_Runner obj = new Cucumber_Runner();
	@Before
	public void beforeScenario(Scenario scenario) throws 	Exception {
		String rawFeatureName = scenario.getId().replaceAll("-", " ").split(";")[0];
		System.out.println("Feature Name:"+rawFeatureName);
		System.out.println("Scenario Name:"+scenario.getName());
		TestDriver testDriver = new TestDriver();
		testDriver.setCucumber(true);		
		new BaseTest(scenario.getName(), testDriver, null);
		//BaseTest.loadTestData(rawFeatureName,scenario.getName(),testDriver);
		CucumberDriver.driver = testDriver.getWebDriver();
		//CucumberDriver.testDriver = testDriver;
		
	}

	@After
		public void tearDown(Scenario scenario) throws IOException {
		
		String scenario_Name = scenario.getName();
		//Cucumber_Runner.SmarTestArguments.getMapTestCaseNamesAndTestCaseId();
		   /* if (scenario.isFailed()) {		    	
				byte[] screenshotBytes = ((TakesScreenshot) CucumberDriver.driver).getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshotBytes, "image/png");
	            JsonReportParser.innermap.get(scenario.getName());
		    }else{
		    	
		    }*/
		   // CucumberDriver.driver.quit();
	
	} 
}
