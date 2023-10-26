package rest_assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;


public class validateResponseBody {
	
	
	@Test

	public void validateResBody() {
		
		RequestSpecification  reqspec =RestAssured.given();
		
		reqspec.baseUri("https://reqres.in");
		
		reqspec.basePath("/api/users?page=2");
		
		Response resp = reqspec.get();
		ResponseBody responseBody = resp.getBody();
//		String respString= responseBody.asString();
//		System.out.println("response body" + respString);
//		
	//	Assert.assertEquals(respString.contains("George"), true , "Check for prsernce for George ");
		
               JsonPath jsonPathView =	responseBody.jsonPath();
		
		
               String firstname = jsonPathView.get("data[0].first_name");
               
               Assert.assertEquals(firstname , "George" , "check first name");
	}

}
