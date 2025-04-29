package session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationDemo {
	
	@Test
	public void GetWeatherDataByCity()
	{	
		//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		
		requestSpec.queryParam("q","delhi").queryParam("appid","aa1df310f6f476cc68d27ddd9198030a");
		Response response = requestSpec.get();
		
		// print response body
	    System.out.println("Response status line" + response.statusLine());
	    System.out.println("Response body:" + response.body().asString());
		Assert.assertEquals(response.statusCode()/*actual*/ ,200);

	}

}
