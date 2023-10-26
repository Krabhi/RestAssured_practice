package rest_assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class checkForValidResponse {
	
	@Test(enabled =false)
	public void getsingleUser() {
		
		
		baseURI= "https://reqres.in/api/users/2";
		RequestSpecification resqSpec = given();	

		Response response = resqSpec.get();
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(200,statusCode );
		
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK" , "Incorect status line recived ");
	}
	
	@Test(enabled =false)
	public void getsingleUserUsingValidatableResponse() {
		
		
		baseURI= "https://reqres.in/api/users/2";
		RequestSpecification resqSpec = given();	
		Response response = resqSpec.get();
		ValidatableResponse validateResp = response.then();
		validateResp.statusCode(200);
		validateResp.statusLine("HTTP/1.1 200 OK");

	}
	
	
	@Test
	
	public void BDD_getsingleUserUsingValidatableResponse() {
		
		given()

		.when()
		    .get("https://reqres.in/api/users/2")
		.then()
		     .statusCode(200)
		     .statusLine("HTTP/1.1 200 OK");
		
	}
	

}
