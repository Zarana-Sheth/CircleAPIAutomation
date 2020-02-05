package com.brillio.featureparser;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import com.brillio.results.pojo.SmartestArgsVO;
import com.google.gson.Gson;

public class Cucumber_Runner {
	// Here set the Gherkin path to fetch feature file and JSON file path to
	// write into JSON format

	private static String temp_Path = System.getProperty("user.dir");
	private static String featurePath = temp_Path + "\\src\\test\\resources\\SourceFeatureFiles\\careProvider";
	private static String reportpath = temp_Path + "\\report\\cucumber.json";
	// Set as pretty / ugly format for for JSON output. By default it is pretty
	static GherkinToJson testG = new GherkinToJson("pretty");
	static JsonReportParser reportParser = new JsonReportParser();
	public static Map<String, Integer> smartestmap = new HashMap<>();
	
	//public static SmarTESTArguments SmarTestArguments;
	
	public static void main(String[] args) throws IOException {
		String smartestArgs =null;
		//SmarTestArguments = Utility.parseSmarTestArguments("%7B%22SmarTESTURL%22%3A%22http%3A%2F%2Flocalhost%3A8080%2FSmarTEST%2F%22%2C+%22jenkinsURL%22%3A%22http%3A%2F%2F172.16.81.39%3A8081%2Fjenkins%22%2C%22jenkinsJob%22%3A%22SmartBotTest%22%2C%22testCaseNames%22%3A%22Login+to+Amazon%2CShop+in+Amazon%22%2C+%22testCaseIds%22%3A%22234%2C233%22%2C+%22testExecutionId%22%3A%22125%22%7D");
		/*
		 * Method will parse the feature files from "destinationFeatureFiles/careProvider" folder and
		 * creates seperate feature file based on the scenario name and stores
		 * it in "sourceFeatureFiles/careProvider" folder
		 */
		smartestArgs = URLDecoder.decode(args[0], "UTF-8");
		Gson gson = new Gson();
		SmartestArgsVO smartestArgsVO =  gson.fromJson(smartestArgs, SmartestArgsVO.class);
		System.out.println("Scenario names are:"+smartestArgsVO.getTestCaseNames());
		String[] scenario_names = getTestcaseArray(smartestArgsVO.getTestCaseNames());
		
		reportParser.cleanFolder(temp_Path + "\\src\\test\\resources\\destinationFeatureFiles\\careProvider\\");

		

		testG.gherkinTojson(scenario_names, featurePath);

		// Parses "Cucumber.json" file from report folder and gives the status
		// of the scenario
		// reportParser.cucumberReportParser(reportpath);

	}

	private static String[] getTestcaseArray(String testCaseName) {
		String[] testCaseArray = null;
		if (testCaseName.contains(",")) {
			testCaseArray = testCaseName.split(",");
		} else {
			testCaseArray = new String[1];
			testCaseArray[0] = testCaseName;
		}
		return testCaseArray;
	}

}