package rest_assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuth {
	
	@Test
	public void digestAuth() {
		
		RequestSpecification reqspec= RestAssured.given();
		
			
			reqspec.baseUri("https://httpbin.org");
			reqspec.basePath("/digest-auth/undefined/abhishek/password");
			
			Response response = reqspec.auth().digest("abhishek", "password").get();
			
			
		    System.out.println("Response Line : " +  response.getStatusLine());
		    
		    Assert.assertEquals(  response.statusCode(), 200, "wrong response");
	}

}
