package session09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {

	@Test
	public void BearerToken()
	{
		RequestSpecification resquestSpec = RestAssured.given();
		
		resquestSpec.baseUri("https://gorest.co.in");
		resquestSpec.basePath("public/v2/users");
		
		JSONObject payload = new JSONObject();
		payload.put("name", "smrity");
		payload.put("gender", "Female");
		payload.put("email", "smrity123@gmail.com");
		payload.put("status", "Active");
        
		String AuthToken = "Bearer 4bb2c5afc9dff402b0b97dc8d733deaa9cb8877b77df8412a3c7ceace28bae75";
		resquestSpec.headers("Authorization",AuthToken)
		.contentType(ContentType.JSON)
		.body(payload.toJSONString());
		
		// perform post request
		Response response = resquestSpec.post();
		
		// print response body
	    System.out.println("Response status line" + response.statusLine());
	    System.out.println("Response body:" + response.body().asString());
		Assert.assertEquals(response.statusCode()/*actual*/ ,201);
	}
}
