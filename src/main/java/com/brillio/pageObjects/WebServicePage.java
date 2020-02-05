/*package com.brillio.pageObjects;


import org.json.simple.parser.ParseException;

import com.brillio.WebserviceKeywords.WebServiceKeywords;
import com.brillio.utilities.CucumberDriver;
import com.brillio.utilities.DriverScript;
import com.brillio.utilities.TestDriver;
import io.restassured.response.Response;

public class WebServicePage {
	TestDriver testDriver;
	WebServiceKeywords keywords;
	Response Getresponse;
	public WebServicePage() throws Exception {
		keywords = new WebServiceKeywords();
		testDriver = CucumberDriver.testDriver;
		
	}
	

    	
	public void getResponse(TestDriver testDriver,String uri) throws Exception,  InterruptedException, Exception, ParseException {
		try{
			Getresponse = keywords.Get(testDriver, uri);
			if(Getresponse.getStatusCode()==200){
				DriverScript.logMessage(testDriver,"testStepDone"," Get is sucessfull");
			}
			else{
				DriverScript.logMessage(testDriver,"testStepFail","Get is Unsucessfull");
				throw new Exception(new Throwable( "Get is Unsucessfull with status code "+Getresponse.getStatusCode()));
			}
		}
		catch(Exception e){
			DriverScript.logMessage(testDriver,"testStepFail","Get is Unsucessfull");
			throw new Exception(new Throwable( "Get is Unsucessfull",e.getCause()));
			
		}
	}
	
	
	public void validateStatusCode(TestDriver testDriver,int statuscode) throws Exception, ParseException {
		try{
			if(Getresponse.getStatusCode() == statuscode){
				DriverScript.logMessage(testDriver,"testStepDone",statuscode+" statuscode validation is sucessfull");
			}
			else{
				DriverScript.logMessage(testDriver,"testStepFail",statuscode+" statuscode validation is Unsucessfull");
				throw new Exception(new Throwable( statuscode+" statuscode validation is Unsucessfull"));
			}
		}
		catch(Exception e){
			DriverScript.logMessage(testDriver,"testStepFail"," statuscode validation is Unsucessfull");
			throw new Exception(new Throwable(" statuscode validation is Unsucessfull",e.getCause()));
			
		}
	}
	
	
	public void validateMessage(TestDriver testDriver,String message) throws Exception,  InterruptedException, Exception, ParseException {
		try{
			if(Getresponse.getBody().jsonPath().get("message").equals(message)){
				DriverScript.logMessage(testDriver,"testStepDone",message+" message validation is sucessfull");
			}
			else{
				DriverScript.logMessage(testDriver,"testStepFail",message+" message validation is Unsucessfull");
				throw new Exception(new Throwable( message+" message validation is Unsucessfull"));
			}
		}
		catch(Exception e){
			DriverScript.logMessage(testDriver,"testStepFail"," message validation is Unsucessfull");
			throw new Exception(new Throwable(" message validation is Unsucessfull",e.getCause()));
			
		}
	}
	public void postResponse(TestDriver testDriver,String uri,String body) throws Exception,  InterruptedException, Exception, ParseException {
		try{
			Getresponse = keywords.Post(testDriver, uri,body.replaceAll("'", "\""));
			if(Getresponse.getStatusCode()==200){
				DriverScript.logMessage(testDriver,"testStepDone"," Post is sucessfull");
			}
			else{
				DriverScript.logMessage(testDriver,"testStepFail","Post is Unsucessfull");
				throw new Exception(new Throwable( "Post is Unsucessfull with status code "+Getresponse.getStatusCode()));
			}
		}
		catch(Exception e){
			DriverScript.logMessage(testDriver,"testStepFail","Post is Unsucessfull");
			throw new Exception(new Throwable( "Post is Unsucessfull",e.getCause()));
			
		}
	}

	
	
}
*/