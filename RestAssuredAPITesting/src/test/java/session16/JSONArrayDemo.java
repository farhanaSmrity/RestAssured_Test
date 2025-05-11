package session16;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class JSONArrayDemo {
	
	@Test (enabled = false)
	public void CreateUserUsingJSONArray()
	{
		// create user
		JSONObject user1 = new JSONObject();
		user1.put("firstName", "seema");
		user1.put("lastName","sultana");
		user1.put("age",28);
		user1.put("salary",10000.56);
		
		JSONObject user2 = new JSONObject();
		user2.put("firstName", "sonia");
		user2.put("lastName","sultana");
		user2.put("age",27);
		user2.put("salary",20000.56);
		
		JSONObject user3 = new JSONObject();
		user3.put("firstName", "sampa");
		user3.put("lastName","sultana");
		user3.put("age",26);
		user3.put("salary",30000.56);
		
		// add json object to json array
		JSONArray userPayload = new JSONArray();
		userPayload.add(user1);
		userPayload.add(user2);
		userPayload.add(user3);
		
		//create request specification
		RequestSpecification reqspec = RestAssured.given();
		
		//specify url
		reqspec.baseUri("https://reqres.in/api/users");
		reqspec.contentType(ContentType.JSON);
		reqspec.body(userPayload);
		Response response = reqspec.post();
		
		response.prettyPrint();
		
		//validate the status code
		Assert.assertEquals(response.statusCode(), 401,"check for status code");
	}

	@Test 
	public void CreaterJSONArrayUsingList()
	{
		// create user
		Map<String, Object> user1 = new HashMap<String, Object>();
		user1.put("firstName", "seema");
		user1.put("lastName","sultana");
		user1.put("age",28);
		user1.put("salary",10000.56);
		
		Map<String, Object> user2 = new HashMap<String, Object>();
		user2.put("firstName", "sonia");
		user2.put("lastName","sultana");
		user2.put("age",27);
		user2.put("salary",20000.56);
		
		Map<String, Object> user3 = new HashMap<String, Object>();
		user3.put("firstName", "sampa");
		user3.put("lastName","sultana");
		user3.put("age",26);
		user3.put("salary",30000.56);
		
		// add json object to json array
		List <Map<String, Object>> jsonArrayListPayload = new JSONArray();
		jsonArrayListPayload.add(user1);
		jsonArrayListPayload.add(user2);
		jsonArrayListPayload.add(user3);
		
		//create request specification
		RequestSpecification reqspec = RestAssured.given();
		
		//specify url
		reqspec.baseUri("https://reqres.in/api/users");
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jsonArrayListPayload);
		Response response = reqspec.post();
		
		response.prettyPrint();
		
		//validate the status code
		Assert.assertEquals(response.statusCode(), 401,"check for status code");
	}

}
