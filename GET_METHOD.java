package rest_assured;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GET_METHOD {
	
// GET request : 
	
	@Test
	public void response () {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("ststuscode :  " + response.getStatusCode());
		System.out.println("ststuscode :  " + response.getBody());
		System.out.println("ststuscode :  " + response.getTime());
		System.out.println("ststuscode :  " + response.getHeaders());

		int Expected_ststusCode  = 200;
		int Actual_statusCode = response.getStatusCode();
		
		Assert.assertEquals(Expected_ststusCode, Actual_statusCode);
		
	}

	
	@Test
	
	public void response_BDD() {
		
		
		//@Given
		baseURI = "https://reqres.in/api/users";
		given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
