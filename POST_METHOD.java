package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import  org.json.simple.JSONObject;

public class POST_METHOD {
	
	@Test
	public void getMethod() {
		
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Abhishek");
		jsonData.put("job", "QA");

		RestAssured.baseURI= "https://reqres.in/api/users";
		RestAssured.given().header("Content-type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().post()
		.then().statusCode(201).log().all();
		
	}

}
