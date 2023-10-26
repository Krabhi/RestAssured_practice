package rest_assured;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class validateResponseHeader {
	
	@Test
	
	public void validateRespHeader() {
		
		RequestSpecification reqspec = RestAssured.given();
		
		//BAse URI
		
		
			reqspec.baseUri("https://reqres.in/");
			reqspec.basePath("/users/2");
			
			Response resp = reqspec.get();	
			String ContentType = resp.getHeader("Content-Type");
//			System.out.println("ContentType:-   " + ContentType);
			Headers headersList = resp.getHeaders();
			
			for (Header header : headersList ) {
				System.out.println(header.getName() + " : " + header.getValue());
			}
			
			Assert.assertEquals(ContentType , "text/html; charset=utf-8" );
			
			
			
		
	}

}
