package com.brillio.featureparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;

import org.codehaus.plexus.util.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import gherkin.formatter.JSONFormatter;
import gherkin.formatter.JSONPrettyFormatter;
import gherkin.parser.Parser;
import gherkin.util.FixJava;

// Gherkin to Json parser core file.

public class GherkinToJson {
	private String format;
	// To get the total running time (optional)
	long startTime = System.currentTimeMillis();

	public GherkinToJson(String outFormat) {
		this.format = outFormat;
	}

	public String getOutFormat() {
		return format;
	}

	public void gherkinTojson(String[] scenario_name, String fPath) {
		File folder = new File(fPath);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {

				// Define Feature file and JSON File path.
				String gherkin = null;
				try {
					gherkin = FixJava.readReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				} catch (FileNotFoundException e) {
					System.out.println("Feature file not found");
					// e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				StringBuilder json = new StringBuilder();
				JSONFormatter formatter;
				// pretty or ugly selection, pretty by default
				if (format.equalsIgnoreCase("ugly")) {
					formatter = new JSONFormatter(json);// not pretty
				} else {
					formatter = new JSONPrettyFormatter(json);// pretty
				}

				Parser parser = new Parser(formatter);
				parser.parse(gherkin, fPath, 0);
				formatter.done();
				formatter.close();
				JSONParser parser1 = new JSONParser();
				String tagname = null;
				String scenarioDetails = null;
				try {
					JSONArray a = (JSONArray) parser1.parse(json.toString());
					for (Object obj : a) {

						JSONObject jsonObject = (JSONObject) obj;

						String featurename = (String) jsonObject.get("name");
						String description = (String) jsonObject.get("description");
						String featureTags = "";

						JSONArray tagArray = (JSONArray) jsonObject.get("tags");
						if (tagArray != null) {
							Iterator<JSONObject> itr3 = tagArray.iterator();
							while (itr3.hasNext()) {
								JSONObject innerjsonobject2 = (JSONObject) itr3.next();
								featureTags += (String) innerjsonobject2.get("name") + " ";
							}

						}

						JSONArray jarray = (JSONArray) jsonObject.get("elements");
						Iterator<JSONObject> itr = jarray.iterator();
						String backgroundData = null;
						for (int i = 1; i <= jarray.size(); i++) {
							JSONObject innerjsonobject = (JSONObject) itr.next();
							if (i == 1 && innerjsonobject.get("keyword").equals("Background")) {
								backgroundData = "Background: ";
								backgroundData += innerjsonobject.get("name") + "\n\t\t";
								JSONArray backgroundarray = (JSONArray) innerjsonobject.get("steps");
								Iterator<JSONObject> itr1 = backgroundarray.iterator();
								while (itr1.hasNext()) {
									JSONObject innerjsonobject2 = (JSONObject) itr1.next();
									backgroundData += (String) innerjsonobject2.get("keyword") + " ";
									backgroundData += (String) innerjsonobject2.get("name") + "\n\t\t";

								}

							}

							for (String s : scenario_name) {

								if (innerjsonobject.get("name").equals(s)) {
									if (featureTags == "") {
										scenarioDetails = "Feature: " + featurename + "\n\t";
									} else {
										scenarioDetails = featureTags + "\n" + "Feature: " + featurename + "\n\t";
									}
									if (description != null) {
										scenarioDetails += description.replaceAll("\n", " ").replaceAll("\r", "")
												+ "\n\t";
									}
									if (backgroundData != null) {
										scenarioDetails += backgroundData;
									}
									String scenarioTags = "";
									JSONArray scenarioTagsArray = (JSONArray) innerjsonobject.get("tags");
									if (scenarioTagsArray != null) {
										Iterator<JSONObject> scenarioTagsitr = scenarioTagsArray.iterator();
										while (scenarioTagsitr.hasNext()) {
											JSONObject innerjsonobject2 = (JSONObject) scenarioTagsitr.next();
											scenarioTags += (String) innerjsonobject2.get("name") + " ";
										}
									}
									if (scenarioTags != "") {
										scenarioDetails += scenarioTags + "\n\t";
									}
									scenarioDetails += "\t" + "Scenario: ";
									scenarioDetails += innerjsonobject.get("name") + "\n\t\t";

									JSONArray innerArray = (JSONArray) innerjsonobject.get("steps");
									Iterator<JSONObject> itr1 = innerArray.iterator();
									while (itr1.hasNext()) {
										JSONObject innerjsonobject2 = (JSONObject) itr1.next();
										scenarioDetails += "\t" + (String) innerjsonobject2.get("keyword") + " ";
										scenarioDetails += (String) innerjsonobject2.get("name") + "\n\t\t";
									}
									String featureFileExecutionPath = System.getProperty("user.dir")+"\\src\\test\\resources\\destinationFeatureFiles\\careProvider\\" + featurename.replaceAll(" ", "")
											+ "_" + i + ".feature";
									Writer writer = null;
									File directory = new File(String.valueOf(System.getProperty("user.dir")+"\\src\\test\\resources\\destinationFeatureFiles\\careProvider"));
									if (!directory.exists()) {
										directory.mkdir();

									}
									try {
										if (!(directory.isDirectory() && directory.list().length == 0)) {
											//FileUtils.cleanDirectory(System.getProperty("user.dir")+"\\src\\test\\resources\\destinationFeatureFiles\\careProvider");
										}
										writer = new BufferedWriter(new OutputStreamWriter(
												new FileOutputStream(featureFileExecutionPath), "utf-8"));
										writer.write(scenarioDetails);
										scenarioDetails = "";

									} catch (IOException ex) {
										// report
									} finally {
										try {
											writer.close();
										} catch (Exception ex) {
											/* ignore */}
									}
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
}
