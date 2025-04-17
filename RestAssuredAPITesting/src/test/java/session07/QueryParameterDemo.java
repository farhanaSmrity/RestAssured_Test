package session07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameterDemo {

	@Test
	public void filterData() 
	{
		//get request specification for the given request
		
		RequestSpecification requestSpec = RestAssured.given();
		
		// specify base URI
		requestSpec.baseUri("https://reqres.in");
	    requestSpec.basePath("api/users?page=2");
	    requestSpec.queryParam("page", 2).queryParam("id", 10);
	    
	    // perform get request
	    Response response = requestSpec.get();
	    
	    // read response body
	    String responseBody =  response.getBody().asString();
	    
	    // print response body
	    System.out.println("Response body" + responseBody );
	    
	    //get json path view of response body
	   JsonPath jsonPathView =  response.jsonPath();
	   
	    //get first_name
	   String firstname = jsonPathView.get("x[0].data[3].first_name"); 
	   
	   
	   Assert.assertEquals(firstname,"Byron","Verify firstname.");
	   
	   
	}
	

}
