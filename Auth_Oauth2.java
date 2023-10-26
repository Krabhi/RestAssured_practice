package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Auth_Oauth2 {
	
	static String access_token;
	
	@Test
	
	public void Get_Oath2_Request() {
		
		String client_ID = "sfdghjgdfsdadfgfhgdfds";

		String client_secret = "sfdghjgdfsdadfgfhgdfds";

		RequestSpecification reqsep = RestAssured.given();
		
		reqsep.baseUri("https://reqres.in");
		reqsep.basePath("/api/users");
		
		Response response = reqsep.auth().preemptive().basic(client_ID, client_secret).post();
		
		response.prettyPrint();
		System.out.println(response.getStatusLine());
		
		/////////above line will give response and we need to fetch the response from the response and user the response element in next call 
		
		//Get access token from response body 
		
		access_token = response.getBody().path("access_token");
		System.out.println("access_token:- " + access_token);
		
	
	}
	
	
	@Test(dependsOnMethods = "Get_Oath2_Request")

	public void Use_Oath2_Response() {
		
		
        Response resp = RestAssured.given().auth().oauth2(access_token).queryParam("page",3)
        		.queryParam("page_size", 4)
        		.queryParam("total_count_required", true)
        		.get("http://hjkhkjhsjkdhfkjsk");
		
        resp.prettyPrint();
        System.out.println("response :"  + resp.getStatusLine() );
        
        
		
		
		
		
		
	}

}
