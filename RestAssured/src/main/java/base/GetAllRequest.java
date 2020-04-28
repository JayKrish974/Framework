package base;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllRequest {
	
	@Test
	public void getAllChangeRequest()
	{
		//To hit the end point
		RestAssured.baseURI="https://dev90533.service-now.com/api/now/v2/table/change_request";
		
		//To set the authentication
		RestAssured.authentication=RestAssured.basic("admin", "Viswa@55");
		
		//To get the response in the object using get()
		Response response = RestAssured.get();
		
		//Get the status code and status line from the response
		int statusCode = response.getStatusCode();
		System.out.println("Response for the request:"+statusCode);
		
		
	}

}
