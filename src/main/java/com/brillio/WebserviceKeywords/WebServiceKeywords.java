package com.brillio.WebserviceKeywords;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import com.brillio.utilities.AccessTokens;
import com.brillio.utilities.DriverScript;
import com.brillio.utilities.RequestBody;
import com.brillio.utilities.TestDriver;
import bsh.ParseException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WebServiceKeywords {

	Properties prop = new Properties();
	WebServiceKeywords keywords;
	//String str="";
	static String str="";
	/*public WebServiceKeywords()throws Exception
	{
		keywords =new WebServiceKeywords();
	}*/
	/*
	 * public void getaccesstoken() throws IOException { FileInputStream fis=
	 * new FileInputStream("D:\\Cucumber_Maven\\Access_Token.properties");
	 * prop.load(fis); }
	 */

	/**
	 * @description Get the json response from respective Bank URI With out
	 *              authentication
	 * @param URI
	 * @return Json Response
	 * @throws ParseException
	 */
	public Response GetURL(TestDriver testDriver, String uri) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
				response = given().log().all()
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + AccessTokens.getsessionKEY())
				.when()
				.get(uri)
				.then()
				.and().contentType(ContentType.JSON)
				.extract().response();

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}
	
	public Response GetURL_Json(TestDriver testDriver, String uri) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
				response = given().log().all()
				.header("Content-Type", "application/json")
				.when()
				.get(uri)
				.then()
				.and().contentType(ContentType.JSON)
				.extract().response();

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}
	
	
	public Response GetURL_XML(TestDriver testDriver, String uri) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
			// URI="https://api.lobdev.fusionfabric.cloud";
			// RestAssured.baseURI= URI;
			response = given().log().all()
					.header("Content-Type", "application/xml")
				//	.header("Authorization", "Bearer " + AccessTokens.getsessionKEY())
					.when().get(uri).then()
					.and().contentType(ContentType.XML).extract().response();

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}

	/**
	 * @description Get the json response from respective Bank URI With out
	 *              authentication
	 * @param URI
	 * @return Json Response
	 * @throws ParseException
	 */
	public Response GetapplicationIdURL(TestDriver testDriver, String uri) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
			// URI="https://api.lobdev.fusionfabric.cloud";
			// RestAssured.baseURI= URI;
			response = given().log().all().
			// auth().oauth2("Bearer "+ AccessToken.getsessionKEY()).
					pathParam("applicationId", "105428").header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + AccessTokens.getsessionKEY()).when().get(uri).then().
					// assertThat()
					and().contentType(ContentType.JSON).statusCode(200).extract().response();

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}

	/**
	 * @description Get the json response from respective Bank URI With out
	 *              authentication
	 * @param URI
	 * @return Json Response
	 * @throws ParseException
	 */

	public static String postRequestBody(String gbody){
		 str=gbody;
	//	System.out.println("Print inside WebServiceKeywords::" + str);
		return str;
	}

	public Response PostURI(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside post response method");
		Response response = null;
		String requestBody=WebServiceKeywords.postRequestBody(str);
//		String requestBody = keywords.postRequestBodyJson(str);
//		String requestBody = keywords.postRequestBodyJson(postBody);
		try {
			RestAssured.baseURI = URI;
			response = given()
					//.queryParam("key", "qaclick123")
					.contentType(ContentType.JSON)
					.body(requestBody).when()
					.post(URI)
					.then()
					//.body("status", equalTo("OK"))
					.and().extract().response();
			// System.out.println("Print Google search API Response : " +
			// response.asString());
			// System.out.println("Response Status Code" +
			// response.statusCode());
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}
	
	public Response PostURL_AT(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside post response method");
		Response response = null;
		
		String requestBody=WebServiceKeywords.postRequestBody(str);
		/*String requestBody = "{\r\n    \"originationTypeIndicator\": \"NEW\",\r\n    \"effectiveDate\":null,\r\n    \"maturityDate\": null,\r\n    \"expiryDate\": null,\r\n    \"productType\": \"3000205\",\r\n    \"purposeTypeId\": \"5684\",\r\n    \"previousAmount\": null,\r\n    \"amount\": {\r\n        \"currencyCode\": null,\r\n        \"amount\": 55000.0\r\n    },\r\n    \"hostLoanNumber\": \"987053104999006\",\r\n    \"pricings\": null,\r\n    \"fees\": null,\r\n    \"lineOfCreditId\": \"\",\r\n    \"applicationId\": \"4\",\r\n    \"term\": null,\r\n    \"termUnit\": \"n\",\r\n    \"supportedCurrencies\": null,\r\n    \"documentedAmount\": null,\r\n    \"originalAmount\": null,\r\n    \"totalAmountTakedown\": null,\r\n    \"requestedAmount\": 50000.0,\r\n    \"finalAmount\": 50000.0,\r\n    \"newMoneyAmount\": null,\r\n    \"payoffAmount\": null,\r\n    \"previousEffectiveDate\": null,\r\n    \"interestRate\": null,\r\n    \"rateType\": null,\r\n    \"isRevolvingLoan\": null,\r\n    \"isFullyAmortizing\": null,\r\n    \"primaryBorrowerId\": \"337\",\r\n    \"secondaryBorrowerIds\": null,\r\n    \"supportedRiskTypes\": null,\r\n    \"paymentTypeId\": null,\r\n    \"paymentFrequencyId\": null,\r\n    \"amendmentTypeIds\": [],\r\n    \"structure\": null,\r\n    \"repaymentSource\": null,\r\n    \"requestedRate\": null,\r\n    \"childLoanIds\": [],\r\n    \"loans\": null,\r\n    \"guarantees\": null,\r\n    \"externalId\": null,\r\n    \"parentId\": null\r\n"
				+ "}";*/

		try {
			RestAssured.baseURI = URI;
			response = given()
					.log().all()
					.body(requestBody)
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + AccessTokens.getsessionKEY())
					.when().post(URI)
					.then().extract().response();

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
			System.out.println("Response Status Code::" + response.statusCode());
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}
	
	public Response PostURIXML(TestDriver testDriver, String URI) throws IOException {
		DriverScript.logMessage(testDriver, "info", "Inside post response method");
		Response response = null;
	//	String requestBody = GenerateStringFromResource("D:\\Finastra_API_Automation\\FinastraAPI_Automation\\TestFiles\\GoogleResponseXML.txt");
		String requestBody= WebServiceKeywords.postRequestBody(str);
		try {
			RestAssured.baseURI = URI;
			response = given()
					//.queryParam("key", "qaclick123")
					.contentType(ContentType.XML)
					.body(requestBody).when()
					.post(URI)
					.then()
					.and().extract().response();
			
			 System.out.println("Print Google search API Response : " +response.asString()); 
			 System.out.println("Response Status Code" +response.statusCode());
			 
			DriverScript.logMessage(testDriver, "info", "XML Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched xml response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}
	
	public Response PutURI(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside put response method");
		Response response = null;
		String requestBody=WebServiceKeywords.postRequestBody(str);
		try {
			RestAssured.baseURI = URI;
			response = given()
					.log().all()
					.body(requestBody)
					.header("Content-Type", "application/json")
					.when()
					.put(URI)
					.then()
					.extract().response();

			System.out.println("Print Response Code Put API::" + response.statusCode());
		//	System.out.println("Does Reponse contains 'put_test_employee'? :" + response.asString().contains("put_test_employee"));
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	public Response PutFinastraURI(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside put response method");
		Response response = null;
		String requestBody = "{\r\n    \"originationTypeIndicator\": \"NEW\",\r\n    \"effectiveDate\":null,\r\n    \"maturityDate\": null,\r\n    \"expiryDate\": null,\r\n    \"productType\": \"3000205\",\r\n    \"purposeTypeId\": \"5684\",\r\n    \"previousAmount\": null,\r\n    \"amount\": {\r\n        \"currencyCode\": null,\r\n        \"amount\": 58100.0\r\n    },\r\n    \"hostLoanNumber\": \"987053104999006\",\r\n    \"pricings\": null,\r\n    \"fees\": null,\r\n    \"lineOfCreditId\": \"\",\r\n    \"applicationId\": \"4\",\r\n    \"term\": null,\r\n    \"termUnit\": \"n\",\r\n    \"supportedCurrencies\": null,\r\n    \"documentedAmount\": null,\r\n    \"originalAmount\": null,\r\n    \"totalAmountTakedown\": null,\r\n    \"requestedAmount\": 50000.0,\r\n    \"finalAmount\": 50000.0,\r\n    \"newMoneyAmount\": null,\r\n    \"payoffAmount\": null,\r\n    \"previousEffectiveDate\": null,\r\n    \"interestRate\": null,\r\n    \"rateType\": null,\r\n    \"isRevolvingLoan\": null,\r\n    \"isFullyAmortizing\": null,\r\n    \"primaryBorrowerId\": \"337\",\r\n    \"secondaryBorrowerIds\": null,\r\n    \"supportedRiskTypes\": null,\r\n    \"paymentTypeId\": null,\r\n    \"paymentFrequencyId\": null,\r\n    \"amendmentTypeIds\": [],\r\n    \"structure\": null,\r\n    \"repaymentSource\": null,\r\n    \"requestedRate\": null,\r\n    \"childLoanIds\": [],\r\n    \"loans\": null,\r\n    \"guarantees\": null,\r\n    \"externalId\": null,\r\n    \"parentId\": null\r\n"
				+ "}";		
		try {
			RestAssured.baseURI = URI;
			response = given().log().all()
					.body(requestBody)
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + AccessTokens.getsessionKEY())
					.when()
					.put("/lines-of-credit/4")
					.then()
					.extract().response();

			System.out.println("Print Response Code PutProductAPI::" + response.statusCode());
		//	System.out.println("Does Reponse contains 'put_test_employee'? :" + response.asString().contains("put_test_employee"));
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}


	/*public Response GetGoogleSearchPlace(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
			RestAssured.baseURI = URI;
			response = given().param("location", "-33.8670522,151.1957362")
					 .param("radius", "500")
					.param("key", "AIzaSyArhFuqezKpvfcYwo4HdTNAJKQdRQNVKKA")
					.when()
					.get("maps/api/place/nearbysearch/json").then().contentType(ContentType.JSON).and()
					.body("results[0].name", equalTo("Sydney")).and()
					.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
					.header("X-Frame-Options","SAMEORIGIN")
					.header("Vary", "Accept-Language")
					.extract().response();
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	*/
	/*public Response GetGoogleSearchPlaceXML(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
			RestAssured.baseURI = URI;
			response = given()
					//.param("location", "-33.8670522,151.1957362")
					//.param("radius", "500")
					//.param("key", "AIzaSyArhFuqezKpvfcYwo4HdTNAJKQdRQNVKKA").when()
					.get("uri").then().contentType(ContentType.XML).and()
					//.body("placesearchresponse.result[0].name", equalTo("Sydney")).and()
					//.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"))
					.extract().response();
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}
		return response;
	}*/
	
	/*public Response PostEmpDetails(TestDriver testDriver, String URI) {
		String postBody="";
		DriverScript.logMessage(testDriver, "info", "Inside post response method");
		Response response = null;
		String requestBody = "{\n" + "  \"name\": \"sammy\",\n" + "  \"salary\": \"19000\",\n" + "  \"age\": \"25\"\n"
				+ "}";
		//String requestBody = RequestBody.getGoogleBody();
		String requestBody = keywords.postRequestBodyJson(postBody);
		try {
			RestAssured.baseURI = URI;
			response = given().contentType(ContentType.JSON)
					// .accept(ContentType.JSON)
					.body(requestBody).when()
					.post("/create")
					.then()
					// .body("age",equalTo("25"))
					.extract().response();

			// System.out.println("Print Google search API Response : "
			// +response.asString());
			// System.out.println("Response Status Code" +
			// response.statusCode());
			// System.out.println("Does Reponse contains 'tammy'? :" +
			// response.asString().contains("ammy"));
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}
*/
	

	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	/*public Response PostProductDetailsXML(TestDriver testDriver, String URI) throws IOException {
		DriverScript.logMessage(testDriver, "info", "Inside Post XML Response method");
		Response response = null;
		String requestBody = GenerateStringFromResource("D:\\Rest_API_Documents\\ProductResponseXML.xml");

		try {
			RestAssured.baseURI = URI;
			response = given().log().all().body(requestBody).header("Content-Type", "application/xml")
					.header("Authorization", "Bearer " + AccessTokens.getsessionKEY()).when().post("/lines-of-credit")
					.then().and().contentType(ContentType.XML).extract().response();

			DriverScript.logMessage(testDriver, "info", "XML Response fetched from URI " + " is Sucessfull");
			System.out.println("Response Status Code::" + response.statusCode());
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched XML response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}*/

	/*
	 * public Response PutEmpDetails(TestDriver testDriver,String URI) {
	 * DriverScript.logMessage(testDriver,"info",
	 * "Inside post response method"); Response response = null; String
	 * requestBody = "{\r\n" + " \"name\":\"put_test_employee\",\r\n" +
	 * " \"salary\":\"1123\",\r\n" + " \"age\":\"23\"\r\n" + "}";
	 * 
	 * try{ RestAssured.baseURI= URI; response = given().
	 * contentType(ContentType.JSON) //.accept(ContentType.JSON)
	 * .body(requestBody) .when() .put("/update/4710") .then()
	 * //.body("age",equalTo("25")) .extract().response();
	 * 
	 * System.out.println("Does Reponse contains 'put_test_employee'? :" +
	 * response.asString().contains("put_test_employee"));
	 * DriverScript.logMessage(testDriver,"info", "Response fetched from URI "+
	 * " is Sucessfull"); }catch(Exception e){
	 * DriverScript.logMessage(testDriver,"info",
	 * "Failed to fetched response from URI "); e.printStackTrace(); throw e; }
	 * 
	 * return response; }
	 */

	public Response PutEmpURI(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside put response method");
		Response response = null;
		int id=9;
		// RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RestAssured.baseURI = "https://reqres.in/api/users/9";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		/*
		 * requestParams.put("name", "Zion"); // Cast requestParams.put("age"
		 * 23); requestParams.put("salary", 12000);
		 */

		// requestParams.put("id",9);
		requestParams.put("email", "janet.weaver@reqres.in");
		requestParams.put("first_name", "Janeti21");
		requestParams.put("last_name", "Weaverww21");
		requestParams.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");
		request.body(requestParams.toString());
		response = request.put("/update/" + id);

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		// Assert.assertEquals(statusCode, 200);

		return response;
	}
	
	
	/*public Response PutEmpDetailsXML(TestDriver testDriver, String URI) throws IOException {
		DriverScript.logMessage(testDriver, "info", "Inside put response method");
		Response response = null;
		String requestBody = GenerateStringFromResource("D:\\Finastra_API_Automation\\Rest_API_Documents\\EmpResponseXML.xml");
	//	String requestBody = "{\"name\":\"test1\",\"salary\":\"1123\",\"age\":\"23\"}";		
		try {
			RestAssured.baseURI = URI ;
			response = given().log().all()
					.body(requestBody)
					.header("Content-Type", "application/xml")
					.header("Authorization", "Bearer " + AccessTokens.getsessionKEY())
					.when()
					.put("/update/179")
					.then()
					.contentType(ContentType.XML)
					.extract().response();

			System.out.println("Print Response Code PutProductAPI::" + response.statusCode());
		//	System.out.println("Does Reponse contains 'put_test_employee'? :" + response.asString().contains("put_test_employee"));
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}
		return response;
	}*/

	
	public Response DeleteGooglePlace(TestDriver testDriver, String URI) {
		DriverScript.logMessage(testDriver, "info", "Inside post response method");
		Response response = null;
		String placeId = "{\r\n\"place_id\":\"28a4b46b47b438bd7a5700d57a87bd9e\"\r\n}";

		try {
			RestAssured.baseURI = URI;
			response = given()
					// .queryParam("key","qaclick123")
					.body(placeId).when().delete(URI)
					// .post("/maps/api/place/delete/json")
					.then().body("status", equalTo("OK")).contentType(ContentType.JSON).and().extract().response();
			System.out.println("Print Google search API Response : " + response.asString());
			System.out.println("Response Status Code" + response.statusCode());
			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}

	/**
	 * @description Get the json response from respective Bank URI With out
	 *              authentication
	 * @param URI
	 * @return Json Response
	 * @throws ParseException
	 */
	public Response GetcollateralIdURL(TestDriver testDriver, String uri) {
		DriverScript.logMessage(testDriver, "info", "Inside get response method");
		Response response = null;
		try {
			// URI="https://api.lobdev.fusionfabric.cloud";
			// RestAssured.baseURI= URI;
			response = given().log().all().
			// auth().oauth2("Bearer "+ AccessToken.getsessionKEY()).
					pathParam("collateralId", "300872").header("Content-Type", "application/json")
					.header("Authorization", "Bearer " + AccessTokens.getsessionKEY()).when().get(uri).then().
					// assertThat()
					and().contentType(ContentType.JSON).statusCode(200).extract().response();

			DriverScript.logMessage(testDriver, "info", "Response fetched from URI " + " is Sucessfull");
		} catch (Exception e) {
			DriverScript.logMessage(testDriver, "info", "Failed to fetched response from URI ");
			e.printStackTrace();
			throw e;
		}

		return response;
	}

	/*
	 * public Response GetFeeTypeAPI(TestDriver testDriver, String uri) {
	 * DriverScript.logMessage(testDriver,"info", "Inside get response method");
	 * Response response = null; try{
	 * //URI="https://api.lobdev.fusionfabric.cloud"; //RestAssured.baseURI=
	 * URI; response= given(). //auth().oauth2("Bearer "+
	 * AccessToken.getsessionKEY()). header("Content-Type","application/json").
	 * header("Authorization","Bearer "+AccessToken.getsessionKEY()). when().
	 * get(
	 * "https://api.lobdev.fusionfabric.cloud/corporate-lending/origination/configuration/v1.0/fee-types"
	 * ). then(). // assertThat()
	 * and().contentType(ContentType.JSON).statusCode(200)
	 * .extract().response(); String responseString=response.asString();
	 * System.out.println(responseString); JsonPath js=
	 * ConvertResponse.rawToJson(response); int
	 * count=js.get("feeTypesList.size()"); for(int i=0;i<count; i++) { String
	 * name=js.get("feeTypesList["+i+"].feeTypeId"); String
	 * id=js.get("feeTypesList["+i+"].description");
	 * //System.out.println("Free Type ID="+ id+"   "+
	 * " Free Type description="+ name+"");
	 * DriverScript.logMessage(testDriver," ","BankId="+ id+"   "+ " BankName="+
	 * name+" "); }
	 * 
	 * //response =
	 * RestAssured.given().contentType("application/json").when().get(URI);
	 * DriverScript.logMessage(testDriver,"info", "Response fetched from URI "+
	 * " is Sucessfull"); }catch(Exception e){
	 * DriverScript.logMessage(testDriver,"info",
	 * "Failed to fetched response from URI "); e.printStackTrace(); throw e; }
	 * return response; }
	 * 
	 */

	/*
	 * public Response Post(TestDriver testDriver, String URI ,String body)
	 * throws ParseException{ DriverScript.logMessage(testDriver,"info",
	 * "Inside Post method"); Response response = null; try{ response =
	 * RestAssured.given().contentType("application/json").body(body).when().
	 * post(URI); DriverScript.logMessage(testDriver,"info",
	 * "Response fetched from URI "+URI+ " is Sucessfull"); }catch(Exception e){
	 * DriverScript.logMessage(testDriver,"info",
	 * "Failed to fetched response from URI "+URI); e.printStackTrace(); throw
	 * e; } return response; }
	 * 
	 * public Response Put(TestDriver testDriver, String URI ,String body)
	 * throws ParseException{ DriverScript.logMessage(testDriver,"info",
	 * "Inside Put method"); Response response = null; Map<String,String> car =
	 * new HashMap<>(); car.put("plateNumber", "xyx1111"); car.put("brand",
	 * "audi"); car.put("colour", "red"); try{ response =
	 * RestAssured.given().contentType("application/json").body(car).when().put(
	 * URI); DriverScript.logMessage(testDriver,"info",
	 * "Response fetched from URI "+URI+ " is Sucessfull"); }catch(Exception e){
	 * DriverScript.logMessage(testDriver,"info",
	 * "Failed to fetched response from URI "+URI); e.printStackTrace(); throw
	 * e; } return response; }
	 * 
	 * 
	 * public Response Delete(TestDriver testDriver, String URI ,String body)
	 * throws ParseException{ DriverScript.logMessage(testDriver,"info",
	 * "Inside Delete method"); Response response = null; try{ response =
	 * RestAssured.given().contentType("application/json").body(body).when().
	 * delete(URI); DriverScript.logMessage(testDriver,"info",
	 * "Response fetched from URI "+URI+ " is Sucessfull"); }catch(Exception e){
	 * DriverScript.logMessage(testDriver,"info",
	 * "Failed to fetched response from URI "+URI); e.printStackTrace(); throw
	 * e; } return response; }
	 */
	
	public Response DeleteURL(TestDriver testDriver, String uri) {
        DriverScript.logMessage(testDriver,"info", "Inside get response method");
        Response response = null;
        String requestBody = "{\n" +
                "  \"place_id\": \"8bb1faa7e81d7e0ad39444091bbdb398\",\n" +
              "}";
        try{
             response=
             given().log().all().
                       auth().oauth2("Bearer "+ AccessTokens.getsessionKEY()).
                       header("Authorization","Bearer "+AccessTokens.getsessionKEY()).
                     body(requestBody).
                    
             when().
                     delete(uri).            
             then().
                       and().
                    extract().response();       
           
             System.out.println("Status Code :>>>>>" + response.getStatusCode());
           
             DriverScript.logMessage(testDriver,"info", "Response fetched from URI "+ " is Sucessfull");
        }catch(Exception e){
            DriverScript.logMessage(testDriver,"info", "Failed to fetched response from URI ");
            e.printStackTrace();
            throw e;
        }
    
        return response;
    }

}
