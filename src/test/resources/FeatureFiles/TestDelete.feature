@TestDELETEAPI 
Feature: Feature to test DELETE Request


@QA @Post_DeleteGooglePlaceAPI
		Scenario: Test Delete to verify the Posted Google place API
		Given I pass Delete URI "http://216.10.245.166/maps/api/place/delete/json?key=qaclick123"
		Then Verify the response of DELETE API
#		Then I Should see StatusCode as 200
# 		Then I Should see StatusCode as 401
# 		Then I Should see StatusCode as 500
# 		Then I Should see StatusCode as 400
# 		Then I Should see StatusCode as 404