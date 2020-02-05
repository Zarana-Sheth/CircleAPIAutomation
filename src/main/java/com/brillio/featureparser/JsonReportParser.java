package com.brillio.featureparser;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.codehaus.plexus.util.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReportParser {
	public static HashMap<String, String> innermap = new HashMap<>();
	public static void cucumberReportParser(String reportpath2) {
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String, String>> resultmap = new HashMap<>();
		
		JSONParser parser1 = new JSONParser();
		try {
			JSONArray a = (JSONArray) parser1.parse(new FileReader(reportpath2));
			for (Object obj : a) {
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray elementsarray = (JSONArray) jsonObject.get("elements");
				Iterator<JSONObject> elementsIterator = elementsarray.iterator();
				while (elementsIterator.hasNext()) {
					JSONObject innerelementsobjects = elementsIterator.next();
					String scenario_name = (String) innerelementsobjects.get("name");
					JSONArray stepsarray = (JSONArray) innerelementsobjects.get("steps");
					int stepscount = stepsarray.size();
					Iterator<JSONObject> stepsIterator = stepsarray.iterator();
					int passcount = 0;
					int failcount = 0;
					int skipcount = 0;
					JSONObject resultobject = null;
					while (stepsIterator.hasNext()) {
						JSONObject stepsobjects = stepsIterator.next();
						resultobject = (JSONObject) stepsobjects.get("result");

						if (resultobject.get("status").equals("passed")) {
							passcount++;
						} else if (resultobject.get("status").equals("skipped")) {
							skipcount++;
							break;
						} else if (resultobject.get("status").equals("failed")) {
							failcount++;
							break;
						}
					}
				
					if (stepscount == passcount && failcount == 0 && skipcount == 0) {
						innermap.put("passed", (String) resultobject.get("error_message"));
						resultmap.put(scenario_name, innermap);
					} else if (failcount >= 1) {
						innermap.put("failed", (String) resultobject.get("error_message"));
						resultmap.put(scenario_name, innermap);

					} else if (skipcount >= 1) {
						innermap.put("skipped", "Skip");
						resultmap.put(scenario_name, innermap);
					}
					System.out.println("Status of the scenario*************************************:"+resultmap);
				}
			}
		} catch (Exception e) {
				
		}
	}

	public void cleanFolder(String path) throws IOException {
		FileUtils.cleanDirectory(path);
	}

}
