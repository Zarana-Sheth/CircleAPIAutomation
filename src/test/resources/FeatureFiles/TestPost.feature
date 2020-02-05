@TestPOSTAPI
Feature: Feature to test POST Request 
#@QA @Post_EmployeeFormSubmitAPI
#Scenario: Test POST to verify the Employee Form Submittion API
#		When I set POST requestBody as "EmpRequestBody"
#		Given I pass URI as "http://dummy.restapiexample.com/api/v1/create"
#		And Verify the response as name "sammy" and age "25" of EmployeeFormSubmit API

@QA @Post_PostGooglePlaceAPI 
Scenario: Test POST to verify the Posted Google place API
		When I set POST requestBody as "GoogleRequestBody"
		Given I pass URI as "http://216.10.245.166/maps/api/place/add/json?key=qaclick123"
		Then Verify the response of Post Google Place API

#@QA @Post_ProductAPI
#Scenario: Test POST to verify the Product Details API
#		When I set POST requestBody as "ProductDetailsRequestBody"
#		Given I pass Finastra POST URI "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/lines-of-credit"
#		And Verify the response of ProductDetails API
#	
#@QA @Post_PostGooglePlaceAPI_XMLResponse 
#Scenario: Test POST to verify the Posted Google place API for XMLResponse
#	When I set requestBody as "GoogleXmlFilePath"
#	Given I pass URI with XML param "http://216.10.245.166/maps/api/place/add/xml?key=qaclick123" 
#	And Verify the reponse of Post Google Place API for XMLResponse 
	
	
	
#@QA @Post_ProductAPI_With_XMLResponse
#		Scenario: Test POST to verify the Product Details API with XML Response
#		Given I pass the Product Details URL with XML Response "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1"
#		And Verify the response of ProductDetails API in XML Format
