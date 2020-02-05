package com.brillio.pageObjects;

import org.json.simple.parser.ParseException;
import com.brillio.WebserviceKeywords.WebServiceKeywords;
import com.brillio.utilities.ConvertResponse;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.DriverScript;
import com.brillio.utilities.TestDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeletePO {
	TestDriver testDriver;
	WebServiceKeywords keywords;
	Response Deleteresponse;

	public DeletePO() throws Exception {
		keywords = new WebServiceKeywords();
		testDriver = CucumberDriver.testDriver;
	}

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

	public void VerifyDeletedGooglePlaceAPI(String uri)
			throws Exception, InterruptedException, Exception, ParseException {

		try {

			Deleteresponse = keywords.DeleteGooglePlace(testDriver, uri);

			if (Deleteresponse.getStatusCode() == 200) {
				DriverScript.logMessage(testDriver, "testStepDone", " Delete is sucessfull");
			} else {
				DriverScript.logMessage(testDriver, "testStepFail", "Delete is Unsucessfull");
				throw new Exception(
						new Throwable("Delete is Unsucessfull with status code " + Deleteresponse.getStatusCode()));
			}
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Delete is Unsucessfull");
			throw new Exception(new Throwable("Delete is Unsucessfull", e.getCause()));
		}
	}

	public void VerifyDeleteGoogleAPIResponse() throws Exception, InterruptedException, Exception, ParseException {
		try {

			String responseString = Deleteresponse.asString();
			System.out.println("My response::" + "\n" + responseString + "\n");

			verifyResponseCode(Deleteresponse);
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "testStepFail", "Delete is Unsucessfull");
			throw new Exception(new Throwable("Delete is Unsucessfull", e.getCause()));

		}
	}

}
