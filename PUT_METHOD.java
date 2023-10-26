package rest_assured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PUT_METHOD {
	
	@Test
	public void putMethod() {
		
		
		//https://reqres.in/api/users/2
			
			
			JSONObject jsonData = new JSONObject();
		jsonData.put("name", "VICKY");
		jsonData.put("job", "SDET");

		RestAssured.baseURI= "https://reqres.in/api/users/203";
		RestAssured.given().header("Content-type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().put()
		.then().statusCode(200).log().all();
		
	}

}
