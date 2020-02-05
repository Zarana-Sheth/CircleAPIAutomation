package com.brillio.WebserviceKeywords;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.restassured.RestAssured.given;

public class OAuth2Test {
	
	private final Logger logger = LoggerFactory.getLogger(OAuth2Test.class);

    private void resourceOwnerLogin() throws JSONException {
           	
    	String response =

                 given().urlEncodingEnabled(false)
                        .queryParams("code"," ")       
                		.queryParams("client_id", "501cdbc8-1f26-443c-a9ef-a6c5b45b37fd")
                        .queryParams("client_secret", "732a69d3-414c-4257-9fb4-7dc7d114c6cb")
                        .queryParams("callback_url", "https://fscqa1-dev-ed--c.visualforce.com/apex/FNS_AuthorizeFFDC")
                        .queryParams("auth_url", "https://api.lobdev.fusionfabric.cloud/login/v1/sandbox/oidc/authorize")
                        .queryParams("grant_type", "authorization_code")
                        .queryParams("state", "")
                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                .when().log().all()
                        .post("https://api.lobdev.fusionfabric.cloud/login/v1/sandbox/oidc/authorize").asString();

//	System.out.println(response);
				    	JsonPath jsonPath = new JsonPath(response);
				    	String accessToken = jsonPath.getString("access_token");
				    	System.out.println(accessToken);
				    	String r2=    given().contentType("application/json").
				    	queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when()	
				       .get("https://rahulshettyacademy.com/getCourse.php")
				
				.asString();				
				System.out.println(r2);



    	
/*callbackURL= "https://fscqa1-dev-ed--c.visualforce.com/apex/FNS_AuthorizeFFDC";
authURL="https://api.lobdev.fusionfabric.cloud/login/v1/sandbox/oidc/authorize";
accessTokenURL="https://api.lobdev.fusionfabric.cloud/login/v1/sandbox/oidc/token";
clientId="501cdbc8-1f26-443c-a9ef-a6c5b45b37fd";
clientSecret="732a69d3-414c-4257-9fb4-7dc7d114c6cb";
scope= "openId";
username="ffdcuser1";
password="123456";
    	
      
        
        
        Response response =
                given().auth().preemptive().basic(clientId, clientSecret)   
                        .formParam("callbackURL", callbackURL)
                        .formParam("granttype", "Autorization Code")
                        .formParam("accessTokenURL", accessTokenURL)
                        .formParam("username", username)
                        .formParam("password", password)
                        .formParam("scope", scope)
                        .when()
                        .post(authURL);

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();
        logger.info("Oauth Token for {} with type {} is {}", username, tokenType, accessToken);
        //return accessToken;
*/    }
}
