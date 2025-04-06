package session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CheckForValidResponse {
	
	@Test (enabled = false)
	public void GetSingleUser() 
	{
		// specify base url
		baseURI = "https://reqres.in/api/users/2";
		
		// Get request specification of the request
		RequestSpecification requestspec = given();
		
		// call get method 
		Response response = requestspec.get();
		
		//gets response code
		int statuscode = response.statusCode();
		
		// validated actual status code with expected
		Assert.assertEquals(statuscode/*actual status code*/, 200/*expected status code*/);
	    
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","incorrect status line returned");
		
	    
	}
	
	
	@Test(enabled= false)
	public void GetSingleUserUsingValidatableResponse()
	{
		// specify base url
				baseURI = "https://reqres.in/api/users/2";
				
				// Get request specification of the request
				RequestSpecification requestspec = given();
				
				// call get method 
				Response response = requestspec.get();
				 ValidatableResponse valideteRes = response.then();
				    
				    //status code
				    valideteRes.statusCode(200);
				    
				    //status line
				    valideteRes.statusLine("HTTP/1.1 200 OK");
				}
	
	
	@Test (enabled = true)
	public void GetSingleUser_BDDStyle() 
	{
		given()
		
		.when()
		      .get("https://reqres.in/api/users/2")
		
		.then()
		      .statusCode(200)
		      .statusLine("HTTP/1.1 200 OK");
		  
	}
}
