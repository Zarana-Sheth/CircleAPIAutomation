package com.brillio.stepdefs;

import com.brillio.WebserviceKeywords.WebServiceKeywords;
import com.brillio.pageObjects.PostPO;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.RequestBody;
import com.brillio.utilities.TestDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostSD {
	TestDriver testDriver;
	PostPO testPost;
	RequestBody rb;
	WebServiceKeywords keywords;
	boolean result;

	public PostSD() throws Exception {
		testDriver = CucumberDriver.testDriver;
		testPost = new PostPO();
		keywords=new WebServiceKeywords();
	}
	
	 @When("^I set POST requestBody as \"([^\"]*)\"$")
	    public void i_set_post_requestbody_as_something(String reqBody) throws Throwable {
		String body=RequestBody.getRequestBody(reqBody);
	    keywords.postRequestBody(body);
	}

	/*@Given("^I pass the Employee Form Submission URL with QueryParam \"([^\"]*)\"$")
	public void i_pass_the_employee_form_submission_url_with_queryparam_something(String strArg1) throws Throwable {
		testPost.VerifyPostEmpDetails(strArg1);
	}*/

	@And("^Verify the response as name \"([^\"]*)\" and age \"([^\"]*)\" of EmployeeFormSubmit API$")
	public void verify_the_response_as_name_something_and_age_something_of_employeeformsubmit_api(String strArg1,
			String strArg2) throws Throwable {
		testPost.VerifyPostEmpDetailsResponse(strArg1, strArg2);
	}

	@Given("^I pass Finastra POST URI \"([^\"]*)\"$")
    public void i_pass_finastra_post_uri_something(String strArg1) throws Throwable {
		testPost.VerifyPostURI_WithAccessToken(strArg1);
    }

	@And("^Verify the response of ProductDetails API$")
	public void verify_the_response_of_productdetails_api() throws Throwable {
		testPost.VerifyPostProductDetailsResponse();
	}

	@Given("^I pass the Product Details URL with XML Response \"([^\"]*)\"$")
	public void i_pass_the_product_details_url_with_xml_response_something(String strArg1) throws Throwable {
		testPost.VerifyPostProductDetailsXML(strArg1);
	}

	/*@And("^Verify the response of ProductDetails API in XML Format$")
	public void verify_the_response_of_productdetails_api_in_xml_format() throws Throwable {
		testPost.VerifyPostProductDetailsResponseXML();
	}*/
	@Then("^Verify the response of Post Google Place API$")
	public void verify_the_response_of_post_google_place_api() throws Throwable {
		 testPost.VerifyPostGooglePlaceAPIResponse();
	}
	@Given("^I pass URI as \"([^\"]*)\"$")
	public void i_pass_uri_as_something(String strArg1) throws Throwable {
		 testPost.VerifyPostURI(strArg1);
	}
	 @Given("^I pass URI with XML param \"([^\"]*)\"$")
	    public void i_pass_uri_with_xml_param_something(String strArg1) throws Throwable {
		 testPost.VerifyPostAPIXML(strArg1);
	 }
	 @And("^Verify the reponse of Post Google Place API for XMLResponse$")
		public void verify_the_reponse_of_post_google_place_api_for_xmlresponse() throws Throwable {
			testPost.VerifyPostGooglePlaceAPIResponseXML();
	 }
	
	/*@Given("^I pass the Post Google Place URL for XMLResponse \"([^\"]*)\"$")
	public void i_pass_the_post_google_place_url_for_xmlresponse_something(String strArg1) throws Throwable {
		testPost.VerifyPostGooglePlaceAPIXML(strArg1);
	}*/

	

}
