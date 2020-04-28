package base;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllRequestUsingOAuthAuthentication {
	
	@Test
	public void getAllChangeRequest()
	{
		//To hit the end point
		RestAssured.baseURI="https://dev90533.service-now.com/api/now/v2/table/change_request";
		
		//To set the authentication
		RestAssured.authentication=RestAssured.
				oauth2("LuijSHoxmH7OPGZ-FhLxggRR57h58LqARZseHT5heOo4mdo49jCMBCAUvR5fxBWGSaNFAntIwaofW-id-mDeTg");
		
		//To get the response in the object using get()
		Response response = RestAssured.get();
		
		//Get the status code and status line from the response
		int statusCode = response.getStatusCode();
		System.out.println("Response for the request:"+statusCode);
		
		//Get the response 
		JsonPath path=response.jsonPath();
		List<String> result=path.getList("result.number");
		for(String each:result)
		{
			System.out.println(each);
		}
		
	}

}
