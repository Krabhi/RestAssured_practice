package rest_assured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Deserialization {
	
	@Test
	
	
	public void deserialization_demo() {
		
		RequestSpecification reqres = RestAssured.given();
		reqres.baseUri("https://reqres.in/");
		reqres.basePath("/api/users");
		
		
		JSONObject jsonData =  new JSONObject();
		jsonData.put("name", "Abhishek");
		jsonData.put("job", "QA");

		
		Response response = reqres
				.contentType(ContentType.JSON)
				.body(jsonData.toJSONString())
				.post();
		
		
		ResponseBody responseBody = response.getBody();
		
		// deserialize the json body to class object 
		
		
		Deserialization_Response responseClass = responseBody.as(Deserialization_Response.class);
		Assert.assertEquals(responseClass.name, "Abhishek", "check for name");
		Assert.assertEquals(responseClass.job, "QA", "check for QA");

		
		
	}

}
