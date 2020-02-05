package com.brillio.utilities;

public class RequestBody {
	
	public static String getRequestBody(String str)
	{
		if(str.equals("GoogleRequestBody"))
		{	
			String requestGoogleBody="{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958720" + "},"
				+ "\"accuracy\": 50," + "\"name\": \"Google Trial Shoes!\"," + "\"phone_number\": \"(02) 9374 4010\","
				+ "\"address\": \"50 Pirrama Road, Pyrmont, NSW 2009, Australia\"," + "\"types\": [\"shoe_store\"],"
				+ "\"website\": \"http://www.google.com.au/\"," + "\"language\": \"en-AU\"" + "}";	
			
			return requestGoogleBody;
			
		}else if(str.equals("EmpRequestBody")){
			
			String requestEmpBody="{\n" + "  \"name\": \"sammy\",\n" + "  \"salary\": \"19000\",\n" + "  \"age\": \"25\"\n" + "}";
			return requestEmpBody;
			
		}else if(str.equals("GoogleXmlFilePath")){
				
			String xmlGoogleFilePath="D:\\Finastra_API_Automation\\FinastraAPI_Automation\\TestFiles\\GoogleResponseXML.txt";
			return xmlGoogleFilePath;	
				
		}else if(str.equals("ProductDetailsRequestBody")){
			String productRequestBody = "{\r\n    \"originationTypeIndicator\": \"NEW\",\r\n    \"effectiveDate\":null,\r\n    \"maturityDate\": null,\r\n    \"expiryDate\": null,\r\n    \"productType\": \"3000205\",\r\n    \"purposeTypeId\": \"5684\",\r\n    \"previousAmount\": null,\r\n    \"amount\": {\r\n        \"currencyCode\": null,\r\n        \"amount\": 55000.0\r\n    },\r\n    \"hostLoanNumber\": \"987053104999006\",\r\n    \"pricings\": null,\r\n    \"fees\": null,\r\n    \"lineOfCreditId\": \"\",\r\n    \"applicationId\": \"4\",\r\n    \"term\": null,\r\n    \"termUnit\": \"n\",\r\n    \"supportedCurrencies\": null,\r\n    \"documentedAmount\": null,\r\n    \"originalAmount\": null,\r\n    \"totalAmountTakedown\": null,\r\n    \"requestedAmount\": 50000.0,\r\n    \"finalAmount\": 50000.0,\r\n    \"newMoneyAmount\": null,\r\n    \"payoffAmount\": null,\r\n    \"previousEffectiveDate\": null,\r\n    \"interestRate\": null,\r\n    \"rateType\": null,\r\n    \"isRevolvingLoan\": null,\r\n    \"isFullyAmortizing\": null,\r\n    \"primaryBorrowerId\": \"337\",\r\n    \"secondaryBorrowerIds\": null,\r\n    \"supportedRiskTypes\": null,\r\n    \"paymentTypeId\": null,\r\n    \"paymentFrequencyId\": null,\r\n    \"amendmentTypeIds\": [],\r\n    \"structure\": null,\r\n    \"repaymentSource\": null,\r\n    \"requestedRate\": null,\r\n    \"childLoanIds\": [],\r\n    \"loans\": null,\r\n    \"guarantees\": null,\r\n    \"externalId\": null,\r\n    \"parentId\": null\r\n"
					+ "}";
			return productRequestBody;
		}else if(str.equals("DummyRequestBody")){
			String dummyRequestBody = "{\"name\":\"test2\",\"salary\":\"1123\",\"age\":\"23\"}";
			return dummyRequestBody;
		}
		
			return str;
			
	}
	
	public static String getGoogleBody()
	{
		String requestGoogleBody="{" + "\"location\": {" + "\"lat\": -33.8669710," + "\"lng\": 151.1958720" + "},"
				+ "\"accuracy\": 50," + "\"name\": \"Google Trial Shoes!\"," + "\"phone_number\": \"(02) 9374 4010\","
				+ "\"address\": \"50 Pirrama Road, Pyrmont, NSW 2009, Australia\"," + "\"types\": [\"shoe_store\"],"
				+ "\"website\": \"http://www.google.com.au/\"," + "\"language\": \"en-AU\"" + "}";	
			
			return requestGoogleBody;
	}
} 
