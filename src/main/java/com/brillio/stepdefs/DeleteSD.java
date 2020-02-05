package com.brillio.stepdefs;
import com.brillio.pageObjects.DeletePO;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.TestDriver;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DeleteSD {
	TestDriver testDriver;
	DeletePO testDelete;
	boolean result;
	public DeleteSD() throws Exception {
		testDriver = CucumberDriver.testDriver;
		testDelete = new DeletePO();
	}
	
	@Given("^I pass Delete URI \"([^\"]*)\"$")
    public void i_pass_delete_uri_something(String strArg1) throws Throwable {
		testDelete.VerifyDeletedGooglePlaceAPI(strArg1);
    }

	@Then("^Verify the response of DELETE API$")
    public void verify_the_response_of_delete_api() throws Throwable {
		   testDelete.VerifyDeleteGoogleAPIResponse();
    }
	
	
/*	@Given("^I pass the Employee Form Submission URL with QueryParam \"([^\"]*)\"$")
    public void i_pass_the_employee_form_submission_url_with_queryparam_something(String strArg1) throws Throwable {
    	testPost.VerifyPostEmpDetails(strArg1);
    }*/
	
/*	@And("^Verify the response of EmployeeFormSubmit API$")
    public void verify_the_response_of_employeeformsubmit_api() throws Throwable {
    	testPost.VerifyPostEmpDetailsResponse();
    }*/
	
/*	@Given("^I pass the Post Google Place URL \"([^\"]*)\"$")
    public void i_pass_the_post_google_place_url_something(String strArg1) throws Throwable {
        testPut.VerifyPostGooglePlaceAPI(strArg1);
    }*/
	
/*	 @And("^Verify the reponse of Post Google Place API$")
	 public void verify_the_reponse_of_post_google_place_api() throws Throwable {
		 testPost.VerifyPostGooglePlaceAPIResponse();
	}*/
	 
/*	 @Given("^I pass the Delete Google Place URL \"([^\"]*)\"$")
	    public void i_pass_the_delete_google_place_url_something(String strArg1) throws Throwable {
		 testPost.VerifyDeletedGooglePlaceAPI(strArg1);
	    }*/

	
}
