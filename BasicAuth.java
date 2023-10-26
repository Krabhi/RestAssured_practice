package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuth {
	
	@Test
	public void basicAuth() {
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<BASIC AUTHORIZATION >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		RequestSpecification reqspec= RestAssured.given();
		
	//	http://postman-echo.com/basic-auth

		
		reqspec.baseUri("http://postman-echo.com");
		reqspec.basePath("/basic-auth");
		
	//	NON-preemptive >>>>>>>>>>>>>
		Response response = reqspec.auth().basic("postman", "password").get();
		
	///	preemptive>>>>>>>>>>>>>
		
		Response response1= reqspec.auth().preemptive().basic("postman", "password").get();
		
		System.out.println("Response status : " + response.statusLine() );
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );

		System.out.println("Response status : " + response1.statusLine() );
		
		
			
		
		
		
	}

}
