import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PatchMethod {

	@Test
	public void test05()
	{
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("Name","Ammu");
		jsonData.put("Job","Homemaker");
		
		// given, when, then
		baseURI="https://reqres.in/api/users/87";
	
		   given().header("Content-type","application/json").
	        contentType(ContentType.JSON).
	        body(jsonData.toJSONString()).
	        when().patch().
			then().statusCode(200).log().all();
		}

}
