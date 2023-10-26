package rest_assured;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;


public class queryParameter {
	
	@Test
	public void queryParm() {
		
		
		RequestSpecification reqsep = RestAssured.given();
		
		reqsep.baseUri("https://reqres.in");
		reqsep.basePath("/api/users");
		reqsep.queryParam("page", 2).queryParam("id", 10);
		
		Response resp =reqsep.get();
		String resp_string = resp.getBody().asString();
		
		System.out.println("resp body : "  + resp_string);
		
		JsonPath jsonPath = resp.jsonPath();
		
		String firstname = jsonPath.get("data.first_name");
		
		Assert.assertEquals(firstname, "Byron" );
		
	}
	

}
