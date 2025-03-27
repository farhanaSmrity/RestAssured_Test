import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_DeleteMethod {
	
	@Test
	public void test06()
	{
		
		// given, when, then
		baseURI="https://reqres.in/api/users/87";
	
		   given().
	        when().delete().
			then().statusCode(204).log().all();
		}


}
