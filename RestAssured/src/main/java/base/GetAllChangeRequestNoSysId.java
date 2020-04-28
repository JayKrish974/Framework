package base;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequestNoSysId {
	
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
		
		if(statusCode==200)
		{
			System.out.println("Status code is successful as expected");
		}
		else
		{
			System.err.println("Status code not matching");
		}
		
		//Check the content type
		String contentType = response.getContentType();
		System.out.println("Content Type:"+contentType);
		
		//To know the response format using accept header
		String responseAcceptHeader=response.getHeader("accept");
		System.out.println(responseAcceptHeader);
		
		//Print the response in pretty format
		//response.prettyPrint();
		
		
		//Get the response in json format
		JsonPath jsonPath = response.jsonPath();
		List<Object> number=jsonPath.getList("result.number");
		printList(number);
		List<Object> sys_id=jsonPath.getList("result.sys_id");
		printList(sys_id);
		
		
		
	}
	
	public static void printList(List<Object> obj)
	{
		for(Object each:obj)
		{
			System.out.println(each);
		}
	}

}
