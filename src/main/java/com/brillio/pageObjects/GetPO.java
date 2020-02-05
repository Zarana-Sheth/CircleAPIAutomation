package com.brillio.pageObjects;

import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import com.brillio.WebserviceKeywords.WebServiceKeywords;
import com.brillio.utilities.ConvertResponse;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.DriverScript;
import com.brillio.utilities.TestDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetPO {
	TestDriver testDriver;
	WebServiceKeywords keywords;
	Response Getresponse;

	public GetPO() throws Exception {
		keywords = new WebServiceKeywords();
		testDriver = CucumberDriver.testDriver;
	}

	/*
	 * method to validate the response from the URI
	 */
	public void verifyResponseCode(Response TestResponse)
			throws Exception, InterruptedException, Exception, ParseException {
		try {

			if (TestResponse.getStatusCode() == 200) {
				DriverScript.logMessage(testDriver, "testStepDone", "Delete is sucessfull");
			}

			else if ((TestResponse.getStatusCode() == 201)) {
				DriverScript.logMessage(testDriver, "201 Created ",
						"Successful creation of a queue, topic, temporary queue, temporary topic, session, producer, consumer, listener, queue browser, or message.");
			}

			else if ((TestResponse.getStatusCode() == 204)) {
				DriverScript.logMessage(testDriver, "204 No Content",
						"Successful deletion of a queue, topic, session, producer, or listener.");
			}

			else if ((TestResponse.getStatusCode() == 400)) {
				DriverScript.logMessage(testDriver, "400 Bad Request",
						"The path info doesn't have the right format, or a parameter or request body value doesn't have the right format, or a required parameter is missing, or values have the right format but are invalid in some way (for example, destination parameter does not exist, content is too big, or client ID is in use).");
			}

			else if ((TestResponse.getStatusCode() == 403)) {
				DriverScript.logMessage(testDriver, "403 Forbidden",
						"The invoker is not authorized to invoke the operation.");
			}

			else if ((TestResponse.getStatusCode() == 404)) {
				DriverScript.logMessage(testDriver, "404 Not Found",
						"The object referenced by the path does not exist.");
			}

			else if ((TestResponse.getStatusCode() == 405)) {
				DriverScript.logMessage(testDriver, "205 Reset Content",
						"The method is not one of those allowed for the path.");
			} else if ((TestResponse.getStatusCode() == 409)) {
				DriverScript.logMessage(testDriver, "409 Conflict",
						"An attempt was made to create an object that already exists.");
			} else if ((TestResponse.getStatusCode() == 500)) {
				DriverScript.logMessage(testDriver, "500 Internal Server Error",
						"The execution of the service failed in some way.");
			} else if ((TestResponse.getStatusCode() == 502)) {
				DriverScript.logMessage(testDriver, "502 Bad Gateway",
						"The server, while acting as a gateway or proxy, received an invalid response from the upstream server it accessed in attempting to fulfill the request.");
			} else if ((TestResponse.getStatusCode() == 503)) {
				DriverScript.logMessage(testDriver, "503 Service Unavailable",
						"The server is currently unable to handle the request due to a temporary overloading or maintenance of the server");
			} else if ((TestResponse.getStatusCode() == 504)) {
				DriverScript.logMessage(testDriver, "504 Gateway Timeout",
						"The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server specified by the URI");
			} else if ((TestResponse.getStatusCode() == 505)) {
				DriverScript.logMessage(testDriver, "505 HTTP Version Not Supported",
						"The server does not support, or refuses to support, the HTTP protocol version that was used in the request message");
			} else {
				DriverScript.logMessage(testDriver, "testStepFail", "No Response Code from List of ResponseCode");
				throw new Exception(new Throwable("Verify ResponseCode Validation is Unsucessfull with status code "
						+ TestResponse.getStatusCode()));
			}

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Response Code Verification is Unsucessfull");
			throw new Exception(new Throwable("Response Code Verification is Unsucessfull", e.getCause()));
		}
	}

	public void getResponse(String uri) throws Exception, InterruptedException, Exception, ParseException {
		try {
			Getresponse = keywords.GetURL(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());
			verifyResponseCode(Getresponse);
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));
		}
	}

	public void getJsonResponse(String uri) throws Exception, InterruptedException, Exception, ParseException {
		try {

			Getresponse = keywords.GetURL_Json(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());

			verifyResponseCode(Getresponse);

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	public void getProductResponse(String uri) throws Exception, InterruptedException, Exception, ParseException {
		try {

			Getresponse = keywords.GetURL(testDriver, uri);
			// Getresponse = keywords.GetURL_WithXMLResponse(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());

			verifyResponseCode(Getresponse);

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	public void getXmlResponse(String uri) throws Exception, InterruptedException, Exception, ParseException {
		try {

			Getresponse = keywords.GetURL_XML(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());

			verifyResponseCode(Getresponse);

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * method to validate the response from the URI
	 */
	public void getapplicationIdResponse(String uri) throws Exception, InterruptedException, Exception, ParseException {
		try {
			Getresponse = keywords.GetapplicationIdURL(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());

			verifyResponseCode(Getresponse);

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * method to validate the response from the URI
	 */
	public void getcollateralIdResponse(String uri) throws Exception, InterruptedException, Exception, ParseException {
		try {
			Getresponse = keywords.GetcollateralIdURL(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());
			verifyResponseCode(Getresponse);
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * method to validate the Status Code from the URI
	 */

	public void validateStatusCode(TestDriver testDriver, int statuscode) throws Exception, ParseException {
		/*
		 * try{ if(Getresponse.getStatusCode() == statuscode){
		 * DriverScript.logMessage(testDriver,"testStepDone",
		 * statuscode+" statuscode validation is sucessfull"); } else{
		 * DriverScript.logMessage(testDriver,"testStepFail",
		 * statuscode+" statuscode validation is Unsucessfull"); throw new
		 * Exception(new Throwable(
		 * statuscode+" statuscode validation is Unsucessfull")); } }
		 * catch(Exception e){ DriverScript.logMessage(testDriver,
		 * "testStepFail"," statuscode validation is Unsucessfull"); throw new
		 * Exception(new
		 * Throwable(" statuscode validation is Unsucessfull",e.getCause()));
		 * 
		 * }
		 */

		if (Getresponse.getStatusCode() == statuscode) {
			DriverScript.logMessage(testDriver, "testStepDone", statuscode + " statuscode validation is sucessfull");
		} else {
			DriverScript.logMessage(testDriver, "testStepFail", statuscode + " statuscode validation is Unsucessfull");

		}
	}

	/*
	 * method to validate the message from the URI
	 */

	public void validateMessage(TestDriver testDriver, String message)
			throws Exception, InterruptedException, Exception, ParseException {
		try {
			if (Getresponse.getBody().jsonPath().get("message").equals(message)) {
				DriverScript.logMessage(testDriver, "testStepDone", message + " message validation is sucessfull");
			} else {
				DriverScript.logMessage(testDriver, "testStepFail", message + " message validation is Unsucessfull");
				throw new Exception(new Throwable(message + " message validation is Unsucessfull"));
			}
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", " message validation is Unsucessfull");
			throw new Exception(new Throwable(" message validation is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * method to validate the response of BANK API
	 */
	public void VerifyBankAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("banksList.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("banksList[" + i + "].bankName");
				String id = js.get("banksList[" + i + "].bankId");
				System.out.println("BankId=" + id + "   " + " BankName=" + name + "");
				DriverScript.logMessage(testDriver, " ", "BankId=" + id + "   " + " BankName=" + name + " ");
				if (name.equals(js.get("banksList[" + i + "].bankName"))
						&& (id.equals(js.get("banksList[" + i + "].bankId")))) {
					DriverScript.logMessage(testDriver, " ", "Bank API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Bank API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * method to validate the response of feeType API
	 */
	public void VerifyfeeTypeAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("feeTypesList.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("feeTypesList[" + i + "].description");
				String id = js.get("feeTypesList[" + i + "].feeTypeId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "feeTypeId=" + id + "   " + " Description=" + name + " ");
				if (name.equals(js.get("feeTypesList[" + i + "].description"))
						&& (id.equals(js.get("feeTypesList[" + i + "].feeTypeId")))) {
					DriverScript.logMessage(testDriver, " ", "Fee Type API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Fee Type API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Work flow Configuration API
	 */
	public void VerifyWorkflowConfigurationAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("workflowConfigurationsList.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("workflowConfigurationsList[" + i + "].activity.description");
				String id = js.get("workflowConfigurationsList[" + i + "].activity.activityId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "ActivityId=" + id + "   " + " Description=" + name + " ");
				if (name.equals(js.get("workflowConfigurationsList[" + i + "].activity.description"))
						&& (id.equals(js.get("workflowConfigurationsList[" + i + "].activity.activityId")))) {
					DriverScript.logMessage(testDriver, " ", "Workflow Configurations API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Workflow Configurations API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Process Center API
	 */
	public void VerifyProcessCenterAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("processCentersList.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("processCentersList[" + i + "].processCenterName");
				String id = js.get("processCentersList[" + i + "].processCenterId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"processCenterId=" + id + "   " + " processCenterName=" + name + " ");
				if (name.equals(js.get("processCentersList[" + i + "].processCenterName"))
						&& (id.equals(js.get("processCentersList[" + i + "].processCenterId")))) {
					DriverScript.logMessage(testDriver, " ", "Process Center API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Process Center API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Process Groups API
	 */
	public void VerifyProcessGroupAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("processGroupsList.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("processGroupsList[" + i + "].description");
				String id = js.get("processGroupsList[" + i + "].processGroupId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "processGroupId=" + id + "   " + " Description=" + name + " ");
				if (name.equals(js.get("processGroupsList[" + i + "].description"))
						&& (id.equals(js.get("processGroupsList[" + i + "].processGroupId")))) {
					DriverScript.logMessage(testDriver, " ", "Process Groups API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Process Groups API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Product Types API
	 */
	public void VerifyProductTypesAPI() throws Exception {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("productTypesList.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("productTypesList[" + i + "].description");
				String id = js.get("productTypesList[" + i + "].productTypeId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "productTypeId=" + id + "   " + " Description=" + name + " ");
				if (name.equals(js.get("productTypesList[" + i + "].description"))
						&& (id.equals(js.get("productTypesList[" + i + "].productTypeId")))) {
					DriverScript.logMessage(testDriver, " ", "Product Types API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Product Types API validation is unsuccessful");
				}
			}
			verifyResponseCode(Getresponse);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Configuration Data API
	 */
	public void VerifyConfigurationDataAPI() {
		try {
			String path = "D:\\Finastra_API_Automation\\FinastraAPI_Automation\\testdata\\storeResponse.properties";
			String responseString = Getresponse.asString();
			// System.out.println(responseString);

			File FC = new File(path);
			FileWriter fw = new FileWriter(FC);
			fw.write("Response Text is :::::::" + responseString);
			fw.close();

			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			// int count=js.get("configurationDataList.size()");
			for (int i = 0; i < 5; i++) {
				String name = js.get("configurationDataList[" + i + "].description");
				String id = js.get("configurationDataList[" + i + "].configurationDataId");
				DriverScript.logMessage(testDriver, " ",
						"configurationDataId=" + id + "   " + " Description=" + name + " ");
				if (name.equals(js.get("configurationDataList[" + i + "].description"))
						&& (id.equals(js.get("configurationDataList[" + i + "].configurationDataId")))) {
					DriverScript.logMessage(testDriver, " ", "Configuration Data API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Configuration Data API validation is unsuccessful");
				}
			}

			verifyResponseCode(Getresponse);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
		}

	}

	/*
	 * method to validate the response of Process Groups API
	 */
	public void VerifyUserProfilesAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("userProfilesList.size()");

			for (int i = 0; i < 3; i++) {
				String name = js.get("userProfilesList[" + i + "].firstName");
				String initials = js.get("userProfilesList[" + i + "].initials");
				String id = js.get("userProfilesList[" + i + "].bankId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"bankId=" + id + "   " + " firstName=" + name + "   " + " initials=" + initials + " ");
				if (name.equals(js.get("userProfilesList[" + i + "].firstName"))
						&& (id == (js.get("userProfilesList[" + i + "].bankId")))
						&& (id.equals(js.get("userProfilesList[" + i + "].initials")))) {
					DriverScript.logMessage(testDriver, " ", "User Profiles API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "User Profiles API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Activities API
	 */
	public void VerifyActivitesAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("activitiesList.size()");

			for (int i = 0; i < count; i++) {
				String name = js.get("activitiesList[" + i + "].description");
				String id = js.get("activitiesList[" + i + "].activityId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "activityId=" + id + "   " + " description=" + name + "   ");
				if (name.equals(js.get("activitiesList[" + i + "].description"))
						&& (id == (js.get("activitiesList[" + i + "].activityId")))) {
					DriverScript.logMessage(testDriver, " ", "Activites API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Activites API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationTrackingItems API
	 */
	public void VerifyApplicationTrackingItemsAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("trackingItemsList.size()");

			for (int i = 0; i < count; i++) {
				String name = js.get("trackingItemsList[" + i + "].description");
				String id = js.get("trackingItemsList[" + i + "].trackingItemId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"trackingItemId=" + id + "   " + " description=" + name + "   ");
				if (name.equals(js.get("trackingItemsList[" + i + "].description"))
						&& (id == (js.get("trackingItemsList[" + i + "].trackingItemId")))) {
					DriverScript.logMessage(testDriver, " ", "Application Tracking Items API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ",
							"Application Tracking Items API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationQueueActivities API
	 */
	public void VerifyApplicationQueueActivitiesAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("queueActivitiesList.size()");

			for (int i = 0; i < count; i++) {
				String name = js.get("queueActivitiesList[" + i + "].activityId");
				String id = js.get("queueActivitiesList[" + i + "].queueActivityId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"queueActivityId=" + id + "   " + " activityId=" + name + "   ");
				if (name.equals(js.get("queueActivitiesList[" + i + "].activityId"))
						&& (id == (js.get("queueActivitiesList[" + i + "].queueActivityId")))) {
					DriverScript.logMessage(testDriver, " ",
							"Application Queue Activities API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ",
							"Application Queue Activities API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationQueueActivities API
	 */
	public void VerifyApplicationDocumentsAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("documentsList.size()");

			for (int i = 0; i < count; i++) {
				String name = js.get("documentsList[" + i + "].description");
				String id = js.get("documentsList[" + i + "].documentId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "documentId=" + id + "   " + " description=" + name + "   ");
				if (name.equals(js.get("documentsList[" + i + "].description"))
						&& (id == (js.get("documentsList[" + i + "].documentId")))) {
					DriverScript.logMessage(testDriver, " ", "Application Documents API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Application Documents API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationQueueActivities API
	 */
	public void VerifyApplicationDecisionListAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("applicationDecisionsList.size()");

			for (int i = 0; i < count; i++) {
				String name = js.get("applicationDecisionsList[" + i + "].applicationId");
				String id = js.get("applicationDecisionsList[" + i + "].authorizationId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"authorizationId=" + id + "   " + " applicationId=" + name + "   ");
				if (name.equals(js.get("applicationDecisionsList[" + i + "].applicationId"))
						&& (id == (js.get("applicationDecisionsList[" + i + "].authorizationId")))) {
					DriverScript.logMessage(testDriver, " ", "Application Decision List API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ",
							"Application Decision List API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationSummary API
	 */
	public void VerifyApplicationSummaryAPI() throws Exception {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("applicationSummariesList.size()");
			for (int i = 0; i < count; i++) {

				String id = js.get("applicationSummariesList[" + i + "].applicationId");
				String activity = js.get("applicationSummariesList[" + i + "].activitySLA");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"applicationId=" + id + "   " + " Activity SLA=" + activity + " ");
				if (id.equals(js.get("applicationSummariesList[" + i + "].applicationId"))
						&& (activity.equals(js.get("applicationSummariesList[" + i + "].activitySLA")))) {
					DriverScript.logMessage(testDriver, " ", "Application Summary API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Application Summary API validation is unsuccessful");
				}
			}

			verifyResponseCode(Getresponse);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationGetDetails API
	 */
	public void VerifyApplicationGetDetailsAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("linesOfCredit.size()");
			for (int i = 0; i < count; i++) {
				String name = js.get("linesOfCredit[" + i + "].purposeTypeId");
				String id = js.get("linesOfCredit[" + i + "].productType");

				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ",
						"ProductType=" + id + "   " + " PurposeTypeId=" + name + "   ");
				if (name.equals(js.get("linesOfCredit[" + i + "].purposeTypeId"))
						&& (id == (js.get("linesOfCredit[" + i + "].productType")))) {
					DriverScript.logMessage(testDriver, " ", "Application Get Details API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Application Get Details API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	public void VerifyGoogleSearchPlaceAPI() throws Exception, InterruptedException, Exception, ParseException {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);

			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("results.size()");
			System.out.println("No of results:" + count);
			for (int i = 0; i < count; i++) {
				String id = js.get("results[" + i + "].id");
				String name = js.get("results[" + i + "].name");
				DriverScript.logMessage(testDriver, " ", "Id=" + id + "   " + " Name=" + name + " ");
				if (id.equals(js.get("results[" + i + "].id")) && (name.equals(js.get("results[" + i + "].name")))) {
					DriverScript.logMessage(testDriver, " ", "Get Google Place Search API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Get Google Place Search API validation is unsuccessful");
				}
			}

			verifyResponseCode(Getresponse);

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * method to validate the response of queueActivitiesList API
	 */
	public void VerifyqueueActivitiesListAPI() throws Exception {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("queueActivitiesList.size()");
			for (int i = 0; i < count; i++) {

				String id = js.get("queueActivitiesList[" + i + "].queueActivityId");
				String userid = js.get("queueActivitiesList[" + i + "].userId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "queueActivityId=" + id + "   " + " User Id=" + userid + " ");
				if (id.equals(js.get("queueActivitiesList[" + i + "].queueActivityId"))
						&& (userid.equals(js.get("queueActivitiesList[" + i + "].userId")))) {
					DriverScript.logMessage(testDriver, " ", "Queue Activities List API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Queue Activities List API validation is unsuccessful");
				}
			}

			verifyResponseCode(Getresponse);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of Documents API
	 */
	public void VerifyDocumentsAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			int count = js.get("queueActivitiesList.size()");
			for (int i = 0; i < count; i++) {

				String id = js.get("queueActivitiesList[" + i + "].queueActivityId");
				String userid = js.get("queueActivitiesList[" + i + "].userId");
				// System.out.println("Free Type ID="+ id+" "+ " Free Type
				// description="+ name+"");
				DriverScript.logMessage(testDriver, " ", "queueActivityId=" + id + "   " + " User Id=" + userid + " ");
				if (id.equals(js.get("queueActivitiesList[" + i + "].queueActivityId"))
						&& (userid.equals(js.get("queueActivitiesList[" + i + "].userId")))) {
					DriverScript.logMessage(testDriver, " ", "Queue Activities List API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Queue Activities List API validation is unsuccessful");
				}
			}

			// response =
			// RestAssured.given().contentType("application/json").when().get(URI);
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	/*
	 * method to validate the response of ApplicationGetDetails API
	 */
	public void VerifyCollateralGetDetailsAPI() {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			JsonPath js = ConvertResponse.rawToJson(Getresponse);
			String id = js.get("collateralId");
			System.out.println(id);
			if (id.equalsIgnoreCase(id)) {
				DriverScript.logMessage(testDriver, " ", "Collateral Id=" + id);
				DriverScript.logMessage(testDriver, " ", "Collateral Get Details API validation is successful");
			} else {
				DriverScript.logMessage(testDriver, " ", "Collateral Get Details API validation is unsuccessful");
			}

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

	}

	public void VerifyProductGetAPI() throws Exception, InterruptedException, Exception, ParseException {
		try {
			String responseString = Getresponse.asString();
			System.out.println("My response::" + "\n" + responseString + "\n");
			/****
			 * Another Solution for Getting Json Response using "JSONObject"
			 **********/
			/*
			 * JSONObject js =new JSONObject(responseString); Object name =
			 * js.get("amount"); System.out.println("Amount:::"+((JSONObject)
			 * name).get("amount"));
			 * System.out.println("HostLoanNumber:::"+js.get("hostLoanNumber"));
			 */

			/********* Validating Json Response Using "JsonPath" ************/

			JsonPath jsPath = new JsonPath(responseString);
			float Amount = jsPath.get("amount.amount");
			System.out.println("HostLoanNumber========" + jsPath.get("hostLoanNumber"));
			System.out.println("ProductType:::" + jsPath.get("productType"));
			System.out.println("ProductType:::" + jsPath.get("purposeTypeId"));
			System.out.println("Primary BorrowerId:::" + jsPath.get("primaryBorrowerId"));
			System.out.println("Amount:::" + Amount);
			DriverScript.logMessage(testDriver, "testStepDone", " Get is sucessfull");

			verifyResponseCode(Getresponse);

		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	public void VerifyResponseProductGetAPIXML() throws Exception, InterruptedException, Exception, ParseException {
		try {
			String responseString = Getresponse.asString();
			System.out.println("My response::" + "\n" + responseString + "\n");

			if (Getresponse.getStatusCode() == 200) {

				/****
				 * Another Solution for Getting Json Response using "JSONObject"
				 **********/
				/*
				 * JSONObject js =new JSONObject(responseString); Object name =
				 * js.get("amount");
				 * System.out.println("Amount:::"+((JSONObject)
				 * name).get("amount"));
				 * System.out.println("HostLoanNumber:::"+js.get(
				 * "hostLoanNumber"));
				 */

				/********* Validating XML Response Using "XmlPath" ************/

				XmlPath xmlPath = new XmlPath(responseString);
				float Amount = xmlPath.get("amount.amount");
				System.out.println("HostLoanNumber========" + xmlPath.get("hostLoanNumber"));
				System.out.println("ProductType:::" + xmlPath.get("productType"));
				System.out.println("ProductType:::" + xmlPath.get("purposeTypeId"));
				System.out.println("Primary BorrowerId:::" + xmlPath.get("primaryBorrowerId"));
				System.out.println("Amount:::" + Amount);
				DriverScript.logMessage(testDriver, "testStepDone", " Get is sucessfull");
			} else {
				DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
				throw new Exception(
						new Throwable("Get is Unsucessfull with status code " + Getresponse.getStatusCode()));
			}
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * Method verify the Google place search
	 */
	public void VerifyGooglePlaceSearchAPI(String uri)
			throws Exception, InterruptedException, Exception, ParseException {
		try {
			// Getresponse = keywords.GetGoogleSearchPlace(testDriver, uri);
			Getresponse = keywords.GetURL_Json(testDriver, uri);
			System.out.println("My response" + Getresponse.toString());

			if (Getresponse.getStatusCode() == 200) {
				DriverScript.logMessage(testDriver, "testStepDone", " Get is sucessfull");
			} else {
				DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
				throw new Exception(
						new Throwable("Get is Unsucessfull with status code " + Getresponse.getStatusCode()));
			}
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));
		}
	}

	/*
	 * public void VerifyGooglePlaceSearchAPIXML(String uri) throws Exception,
	 * InterruptedException, Exception, ParseException { try { Getresponse =
	 * keywords.GetGoogleSearchPlaceXML(testDriver, uri);
	 * System.out.println("My response" + Getresponse.toString());
	 * 
	 * if (Getresponse.getStatusCode() == 200) {
	 * DriverScript.logMessage(testDriver, "testStepDone",
	 * " Get is sucessfull"); } else { DriverScript.logMessage(testDriver,
	 * "testStepFail", "Get is Unsucessfull"); throw new Exception( new
	 * Throwable("Get is Unsucessfull with status code " +
	 * Getresponse.getStatusCode())); } } catch (Exception e) {
	 * DriverScript.logMessage(testDriver, "testStepFail",
	 * "Get is Unsucessfull"); throw new Exception(new
	 * Throwable("Get is Unsucessfull", e.getCause())); } }
	 */

	public void VerifyGoogleSearchPlaceResponseXML() throws Exception, InterruptedException, Exception, ParseException {
		try {
			String responseString = Getresponse.asString();
			System.out.println(responseString);
			XmlPath xmlPath = ConvertResponse.rawToXML(Getresponse);
			int count = xmlPath.get("placesearchresponse.result.size()");
			System.out.println("No of results:" + count);
			for (int i = 0; i < count; i++) {
				String id = xmlPath.get("placesearchresponse.result[" + i + "].id");
				String name = xmlPath.get("placesearchresponse.result[" + i + "].name");
				DriverScript.logMessage(testDriver, " ", "Id=" + id + "   " + " Name=" + name + " ");
				if (id.equals(xmlPath.get("placesearchresponse.result[" + i + "].id"))
						&& (name.equals(xmlPath.get("placesearchresponse.result[" + i + "].name")))) {
					DriverScript.logMessage(testDriver, " ", "Get Google Place Search API validation is successful");
				} else {
					DriverScript.logMessage(testDriver, " ", "Get Google Place Search API validation is unsuccessful");
				}
			}
			verifyResponseCode(Getresponse);
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Get is Unsucessfull");
			throw new Exception(new Throwable("Get is Unsucessfull", e.getCause()));

		}
	}

	/*
	 * public void postResponse(TestDriver testDriver,String uri,String body)
	 * throws Exception, InterruptedException, Exception, ParseException { try{
	 * Getresponse = keywords.Post(testDriver, uri,body.replaceAll("'", "\""));
	 * if(Getresponse.getStatusCode()==200){
	 * DriverScript.logMessage(testDriver,"testStepDone"," Post is sucessfull");
	 * } else{
	 * DriverScript.logMessage(testDriver,"testStepFail","Post is Unsucessfull"
	 * ); throw new Exception(new Throwable(
	 * "Post is Unsucessfull with status code "+Getresponse.getStatusCode())); }
	 * } catch(Exception e){
	 * DriverScript.logMessage(testDriver,"testStepFail","Post is Unsucessfull"
	 * ); throw new Exception(new Throwable(
	 * "Post is Unsucessfull",e.getCause()));
	 * 
	 * } }
	 * 
	 * 
	 * public void resourceOwnerLogin(String callbackURL, String grant_type,
	 * String clientId, String clientSecret, String authURL, String
	 * accessTokenURL,String username, String password, String scope) throws
	 * JSONException {
	 * 
	 * callbackURL=
	 * "https://fscqa1-dev-ed--c.visualforce.com/apex/FNS_AuthorizeFFDC";
	 * grant_type= "Authorization Code"; authURL=
	 * "https://api.lobdev.fusionfabric.cloud/login/v1/sandbox/oidc/authorize";
	 * accessTokenURL=
	 * "https://api.lobdev.fusionfabric.cloud/login/v1/sandbox/oidc/token";
	 * clientId="501cdbc8-1f26-443c-a9ef-a6c5b45b37fd";
	 * clientSecret="732a69d3-414c-4257-9fb4-7dc7d114c6cb"; scope= "openId";
	 * username="ffdcuser1"; password="123456";
	 * 
	 * 
	 * Response response = given().auth().preemptive().basic(clientId,
	 * clientSecret).log().all() .formParam("callbackURL", callbackURL)
	 * .formParam("authURL", accessTokenURL) .formParam("grant_type",
	 * "AuthorizationCode") .formParam("username", username)
	 * .formParam("password", password) .formParam("scope", scope) .when()
	 * .post(authURL);
	 * 
	 * JSONObject jsonObject = new JSONObject(response.getBody().asString());
	 * System.out.println(jsonObject); String accessToken =
	 * jsonObject.get("access_token").toString(); String tokenType =
	 * jsonObject.get("token_type").toString(); System.out.println(accessToken);
	 * // logger.info("Oauth Token for {} with type {} is {}", username,
	 * tokenType, accessToken); //return accessToken; }
	 */
}
