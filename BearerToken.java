package rest_assured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BearerToken {


	@Test
	public void barerToken() {


		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://gorest.co.in");
		reqSpec.basePath("/public/v2/users");
		
		JSONObject payload = new JSONObject();
		
				payload.put("name", "Abhishek");
				payload.put("gender", "Male");
				payload.put("email", "Abhishek@gmail.com");
				payload.put("status", "Active");

				String AuthToken = "Bearer b2bf4c85c4626c1ce94c379667b46866e5830d826b60de10914eaab6ce8f7209";
				
				reqSpec.header("Authorization", AuthToken).
				contentType(ContentType.JSON).
				body(payload.toJSONString());
				
				Response response = reqSpec.post();
				
				System.out.println("Response Line :  " + response.getStatusLine());
				System.out.println("Response BODY :  " + response.getBody());

				Assert.assertEquals(response.getStatusCode(),  201, "failed ");

	
	
	}

}
