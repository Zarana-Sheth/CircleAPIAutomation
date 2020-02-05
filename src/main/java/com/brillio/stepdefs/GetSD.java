package com.brillio.stepdefs;

import com.brillio.pageObjects.GetPO;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.TestDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GetSD {
	TestDriver testDriver;
	GetPO testGet;

	boolean result;

	public GetSD() throws Exception {
		testDriver = CucumberDriver.testDriver;
		testGet = new GetPO();
	}

	@Given("^I pass the \"([^\"]*)\"$")
	public void i_pass_the_something(String uri) throws Throwable {
		testGet.getResponse(uri);
	}

	/*@Given("^I pass the URI with pathParam \"([^\"]*)\"$")
	public void i_pass_the_uri_with_pathparam_something(String uri) throws Throwable {
		testGet.getapplicationIdResponse(uri);
	}*/

	/*@Given("^I pass the Collateral URI with pathParam \"([^\"]*)\"$")
	public void i_pass_the_collateral_uri_with_pathparam_something(String uri) throws Throwable {
		testGet.getcollateralIdResponse(uri);
	}*/

	@Then("^I Should see StatusCode as (.+)$")
	public void i_should_see_statuscode_as(int statuscode) throws Throwable {
		testGet.validateStatusCode(testDriver, statuscode);
	}

	@And("^I Should see message as (.+)$")
	public void i_should_see_message_as(String message) throws Throwable {
		testGet.validateMessage(testDriver, message);
	}

	@Given("^I pass the URI \"([^\"]*)\" and body as \"([^\"]*)\"$")
	public void i_pass_the_uri_and_body_as(String uri, String body) throws Throwable {
		// webServicePage.postResponse(testDriver,uri,body);
	}

	@And("^Verify the response of Bank API$")
	public void verify_the_response_of_bank_api() throws Throwable {
		testGet.VerifyBankAPI();
	}

	@And("^Verify the response of FeeType API$")
	public void verify_the_response_of_FeeType_api() throws Throwable {
		testGet.VerifyfeeTypeAPI();
	}

	@And("^Verify the response of WorkflowConfiguration API$")
	public void verify_the_response_of_WorkflowConfiguration_api() throws Throwable {
		testGet.VerifyWorkflowConfigurationAPI();
	}

	@And("^Verify the response of ProcessCenters API$")
	public void verify_the_response_of_ProcessCenters_api() throws Throwable {
		testGet.VerifyProcessCenterAPI();
	}

	@And("^Verify the response of ProcessGroups API$")
	public void verify_the_response_of_ProcessGroups_api() throws Throwable {
		testGet.VerifyProcessGroupAPI();
	}

	@And("^Verify the response of ProductTypes API$")
	public void verify_the_response_of_ProductTypes_api() throws Throwable {
		testGet.VerifyProductTypesAPI();
	}

	@And("^Verify the response of ConfigurationData API$")
	public void verify_the_response_of_ConfigurationData_api() throws Throwable {
		testGet.VerifyConfigurationDataAPI();
	}

	@And("^Verify the response of UserProfiels API$")
	public void verify_the_response_of_UserProfiels_api() throws Throwable {
		testGet.VerifyUserProfilesAPI();
	}

	@And("^Verify the response of Activites API$")
	public void verify_the_response_of_Activites_api() throws Throwable {
		testGet.VerifyActivitesAPI();
	}

	@And("^Verify the response of ApplicationTrackingItems API$")
	public void verify_the_response_of_ApplicationTrackingItems_api() throws Throwable {
		testGet.VerifyApplicationTrackingItemsAPI();
	}

	@And("^Verify the response of ApplicationQueueActivities API$")
	public void verify_the_response_of_ApplicationQueueActivities_api() throws Throwable {
		testGet.VerifyApplicationQueueActivitiesAPI();
	}

	@And("^Verify the response of ApplicationDocuments API$")
	public void verify_the_response_of_ApplicationDocuments_api() throws Throwable {
		testGet.VerifyApplicationDocumentsAPI();
	}

	@And("^Verify the response of ApplicationDecisionList API$")
	public void verify_the_response_of_ApplicationDecisionList_api() throws Throwable {
		testGet.VerifyApplicationDecisionListAPI();
	}

	@And("^Verify the response of ApplicationSummary API$")
	public void verify_the_response_of_ApplicationSummary_api() throws Throwable {
		testGet.VerifyApplicationSummaryAPI();
	}

	@And("^Verify the response of ApplicationGetDetails API$")
	public void verify_the_response_of_ApplicationGetDetails_api() throws Throwable {
		testGet.VerifyApplicationGetDetailsAPI();
	}

	@And("^Verify the response of queueActivitiesList API$")
	public void verify_the_response_of_queueActivitiesList_api() throws Throwable {
		testGet.VerifyqueueActivitiesListAPI();
	}

	@And("^Verify the response of Documents API$")
	public void verify_the_response_of_Documents_api() throws Throwable {
		testGet.VerifyDocumentsAPI();
	}

	@And("^Verify the response of CollateralGetDetails API$")
	public void verify_the_response_of_CollateralGetDetails_api() throws Throwable {
		testGet.VerifyCollateralGetDetailsAPI();
	}
	
/*	@Given("^I pass the Google Place Search URI with QueryParam \"([^\"]*)\"$")
	public void i_pass_the_google_place_search_uri_with_queryparam_something(String strArg1) throws Throwable {
		//testGet.VerifyGooglePlaceSearchAPI(strArg1);
		testGet.getJsonResponse(strArg1);
	}*/

	@And("^Verify the response of GooglePlaceSearch API$")
	public void verify_the_response_of_googleplacesearch_api() throws Throwable {
		testGet.VerifyGoogleSearchPlaceAPI();
	}

/*	@Given("^I pass the GET Product URI \"([^\"]*)\"$")
	public void i_pass_the_get_product_uri_something(String strArg1) throws Throwable {
		//testGet.getResponse(strArg1);
		//testGet.getProductResponse(strArg1);
		testGet.getJsonResponse(strArg1);
	}*/

	@And("^Verify the response of Product API$")
	public void verify_the_response_of_product_api() throws Throwable {
		testGet.VerifyProductGetAPI();
	}
	
	@Given("^I pass the URI with xml QueryParam \"([^\"]*)\"$")
    public void i_pass_the_uri_with_xml_queryparam_something(String strArg1) throws Throwable {
		testGet.getXmlResponse(strArg1);
    }
	

	@And("^Verify the response of GooglePlaceSearch API With XML Response$")
	public void verify_the_response_of_googleplacesearch_api_with_xml_response() throws Throwable {
		testGet.VerifyGoogleSearchPlaceResponseXML();
	}
	
	@Given("^I pass the GET Product URI with XML responsec \"([^\"]*)\"$")
    public void i_pass_the_get_product_uri_with_xml_responsec_something(String strArg1) throws Throwable {
        testGet.getXmlResponse(strArg1);
    }
	
	@And("^Verify the response of Product API XML$")
    public void verify_the_response_of_product_api_xml() throws Throwable {
       testGet.VerifyResponseProductGetAPIXML();
    }

	@Given("^I pass the URI with Json Response and QueryParam \"([^\"]*)\"$")
    public void i_pass_the_uri_with_json_response_and_queryparam_something(String strArg1) throws Throwable {
        testGet.getJsonResponse(strArg1);
    }

}
