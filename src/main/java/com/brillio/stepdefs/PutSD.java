package com.brillio.stepdefs;

import com.brillio.WebserviceKeywords.WebServiceKeywords;
import com.brillio.pageObjects.PutPO;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.RequestBody;
import com.brillio.utilities.TestDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PutSD {
	TestDriver testDriver;
	PutPO testPut;
	WebServiceKeywords keywords;

	boolean result;

	public PutSD() throws Exception {
		testDriver = CucumberDriver.testDriver;
		testPut = new PutPO();
	}

	@When("^I set PUT requestBody as \"([^\"]*)\"$")
    public void i_set_put_requestbody_as_something(String strArg1) throws Throwable {
		String body=RequestBody.getRequestBody(strArg1);
	    keywords.postRequestBody(body);
    }
	
	@Given("^I pass PUT URI with QueryParam \"([^\"]*)\"$")
    public void i_pass_put_uri_with_queryparam_something(String strArg1) throws Throwable {
		testPut.VerifyPut_URI(strArg1);
	}
	
	@Then("^Verify the response of PUT API$")
    public void verify_the_response_of_put_api() throws Throwable {
		testPut.VerifyPutResponse();
    }

	 @Given("^I pass PUT Finastra URI \"([^\"]*)\"$")
	    public void i_pass_put_finastra_uri_something(String strArg1) throws Throwable {
		 testPut.VerifyPUTFinastraATAPI(strArg1);
	    }
	
	@Given("^I pass the Product Details PUT API URL \"([^\"]*)\"$")
	public void i_pass_the_product_details_put_api_url_something(String strArg1) throws Throwable {
		testPut.VerifyPUTFinastraATAPI(strArg1);
	}

	/*@Given("^I update the Employee Details from URL for XML Response with QueryParam \"([^\"]*)\"$")
	public void i_update_the_employee_details_from_url_for_xml_response_with_queryparam_something(String strArg1) throws Throwable {
	    testPut.VerifyPUTEmpDetailsAPIXML(strArg1);
	}*/

	@And("^Verify the response of PUT EmployeeDetails API with XML Response$")
	public void verify_the_response_of_put_employeedetails_api_with_xml_response() throws Throwable {
	    testPut.VerifyPutEmpDetailsResponseXML();
	}

}
