package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DELETE_METHOD {
	
	@Test
	public void deleteMethod () {
		
		
		//https://reqres.in/api/users/2
		
		
		RestAssured .baseURI = "https://reqres.in/api/users/203";
		RestAssured.given().
		when().
		delete().
		then().
		log().all().statusCode(204);
	}

}
