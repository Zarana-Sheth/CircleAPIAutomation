package com.brillio.utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ConvertResponse {

	public static XmlPath rawToXML(Response response) {
		String respon = response.asString();
		XmlPath xml = new XmlPath(respon);
		return xml;
	}

	public static JsonPath rawToJson(Response response) {
		String respon = response.asString();
		JsonPath json = new JsonPath(respon);
		return json;
	}
}
