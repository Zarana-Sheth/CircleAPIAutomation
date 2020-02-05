@TestAPI 
Feature: Feature to test GET Request

#Below @Get_GooglePlaceSearchAPI working perfectly till 30/01/2020
@QA @Get_GooglePlaceSearchAPI
		Scenario: Test GET to verify the Google Place Search API
		Given I pass the URI with Json Response and QueryParam "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&key=AIzaSyCa0yCggnvY1BzScc4-z3_QHFKhiTXxQRE&radius=500"
 		And Verify the response of GooglePlaceSearch API
 		Then I Should see StatusCode as 200
 		Then I Should see StatusCode as 401
 		Then I Should see StatusCode as 500
 		Then I Should see StatusCode as 400
 		Then I Should see StatusCode as 404

#Below @Get_GooglePlaceSearchAPIWithXMLResponse working perfectly till 30/01/2020
@QA @Get_GooglePlaceSearchAPIWithXMLResponse
		Scenario: Test GET to verify the Google Place Search API With XML Response
		Given I pass the URI with xml QueryParam "https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&key=AIzaSyCa0yCggnvY1BzScc4-z3_QHFKhiTXxQRE&radius=500"
 		And Verify the response of GooglePlaceSearch API With XML Response

#Below @GetProductAPI working perfectly till 30/01/2020
@QA @GetProductAPI
		Scenario: Test GET to verify the Product API
		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/lines-of-credit/4" 
 		And Verify the response of Product API

#Below  @Get_BankAPI working perfectly till 30/01/2020
@QA @Get_BankAPI
		Scenario: Test GET to verify the Bank API
		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/configuration/v1/banks"
  		And Verify the response of Bank API

#Below @Pre-Prod @ProductTypeAPI working perfectly till 30/01/2020
@QA @Pre-Prod @ProductTypeAPI
		Scenario: Test GET to verify the Product Type API
		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/configuration/v1/product-types/"
  		And Verify the response of ProductTypes API

#Below @Get_ConfigurationDataAPI working perfectly till 30/01/2020- Fetch its response and stored into storeResponse.properties file
@Pre-Prod @Get_ConfigurationDataAPI
		Scenario: Test GET to verify the Configuration Data API
  		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/configuration/v1/configuration-data?type="
  		And Verify the response of ConfigurationData API

#Below API Throws java.lang.NullPointerException for initials record - Not working perfectly
#@Pre-Prod @Get_UserProfilesAPI
#		Scenario: Test GET to verify the User Profiles API
#		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/configuration/v1/user-profiles"
#  		And Verify the response of UserProfiels API

#Below API working perfectly - But Got too much lengthy response with applicationSummariesList		[667] - Can we store this into response File ? 
@Pre-Prod @Get_ApplicationSummaryAPI
		Scenario: Test GET to verify the Application Summary API
		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/applications/summary?officerId=6"
  		And Verify the response of ApplicationSummary API

#Below API Throws Status Code - 404 - in postman also - Need to try with correct appId
#@Pre-Prod @Get_ApplicationGetDetailsAPI
#		Scenario: Test GET to verify the Application Get Details API
##		Given I pass the URI with pathParam "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/applications/{applicationId}"
#		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/applications/105428"
#		And Verify the response of ApplicationGetDetails API

#Below API working perfectly till 30/01/2020
@Pre-Prod @Get_QueueActivitiesListAPI
		Scenario: Test GET to verify the Queue Activities List API
		Given I pass the "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/applications/289/queue-activities"
  		And Verify the response of queueActivitiesList API