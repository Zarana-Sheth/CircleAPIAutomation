#@TestPOSTAPI 
Feature: Feature to test PUT Request 

@QA @Post_EmployeeFormSubmitAPI
		Scenario: Test PUT to verify the Employee Form Submittion API
		When I set PUT requestBody as "DummyRequestBody"
		Given I pass PUT URI with QueryParam "http://dummy.restapiexample.com/api/v1/update/21"
		Then Verify the response of PUT API
		
#Below PUT API @QA @Post_ProductDetailsPutAPI working perfectly till 28/01/2020
#@QA @Post_ProductDetailsPutAPI
#Scenario: Test PUT to verify the Product Details API
#	When I set PUT requestBody as "ProductRequestBody"
#	Given I pass PUT Finastra URI "https://api.preprod.fusionfabric.cloud/corporate-lending/origination/credit-agreement/v1/lines-of-credit/4"
#	Then Verify the response of PUT API

#Below API not working for xml response - Take it as reference
#@QA @Post_EmployeeFormSubmitAPIwithXMLResponse
#		Scenario: Test PUT to verify the Employee Form Submittion API with XML Response
#		Given I update the Employee Details from URL for XML Response with QueryParam "http://dummy.restapiexample.com/api/v1"
#		And Verify the response of PUT EmployeeDetails API with XML Response