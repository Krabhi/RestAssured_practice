package rest_assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_KEY_AUTH {
	
	
	@Test
	public void apiKeyAuth() {
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://api.openweathermap.org");
		reqSpec.basePath("/data/2.5/weather");
	//	https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		reqSpec.queryParam("q", "delhi").queryParam("appid", "edd1d98f7b118d9efc3bc1cfb72b0358");
		Response response = reqSpec.get();
		System.out.println("Statuse line:" +  response.getStatusLine());

		Assert.assertEquals(response.getStatusCode(), 200 , "Check Response");
		
		
	}

}
