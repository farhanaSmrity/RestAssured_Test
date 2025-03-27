import org.testng.Assert;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test_GetMethod {
	
	@Test
	public void test01()
	{
		Response res = get("https://reqres.in/api/users?page=2");
		
		System.out.println("Status code:" + res.getStatusCode());
		System.out.println("Response body:" + res.getBody().asString());
		System.out.println("Response time:" + res.getTime());
		System.out.println("Response header:" + res.getHeader("Content-Type"));
		
		
		//Validated the response code with assert
		
		int expectedStatusCode = 200;
		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(expectedStatusCode,actualStatusCode);
	}
	
	
	@Test
	public void test02()
	{
		// given, when, then
		baseURI="https://reqres.in/api/users";
	
		   given().queryParam("page","2").
		   when().get().
		   then().statusCode(200);
	}
}
