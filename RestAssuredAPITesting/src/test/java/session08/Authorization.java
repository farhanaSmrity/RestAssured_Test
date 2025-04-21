package session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	
	@Test
	public void BasicAuth() 
	{
		RequestSpecification requestSpec = RestAssured.given();
		
		// specify url
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");
		
		// perform get request
	    Response response = requestSpec.auth().preemptive().basic("postman","password").get();
	    
	    // print response body
	    System.out.println("Response status" + response.statusLine());
	    System.out.println("Response body:" + response.body().asString());
		
	}

	
	@Test
	public void DigestAuth() 
	{
		RequestSpecification requestSpec = RestAssured.given();
		
		// specify url
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/smrity/smrity");
		
		// perform get request
	    Response response = requestSpec.auth().digest("smrity","smrity").get();
	    
	    // print response body
	    System.out.println("Digest auth Response status" + response.statusLine());
	    System.out.println("Digest auth Response body:" + response.body().asString());
		Assert.assertEquals(response.statusCode()/*actual*/ ,200);
	}
}
