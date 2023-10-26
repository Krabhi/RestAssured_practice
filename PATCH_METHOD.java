package rest_assured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PATCH_METHOD {
	
	@Test
	public void patchMethod() {
		
		
		JSONObject jsonData = new JSONObject();
	jsonData.put("name", "kumar");
	jsonData.put("job", "QAE");

	RestAssured.baseURI= "https://reqres.in/api/users/203";
	RestAssured.
	given().header("Content-type", "application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString()).
	
	when().
	patch()
	.then()
	.statusCode(200).log().all();
	
	}

}
