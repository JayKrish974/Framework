package base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class PrintAllChangeRequestBasedOnFilter {
	
	@Test
	public void getAllChangeRequest()
	{
		
		Map<String, Object> paramMap=new HashMap<String,Object>();
		paramMap.put("category", "network");
		paramMap.put("state", "-3");
		
		Map<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("accept", "application/xml");
		headerMap.put("Content-Type", "application/json");
		
		RestAssured.baseURI="https://dev90533.service-now.com/api/now/v2/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Viswa@55");
		
		Response response = RestAssured.
				given().headers(headerMap)
				.params(paramMap)
				.get();
		
		XmlPath responseBody=response.xmlPath();
		List<Object> numberList=responseBody.getList("response.result.number");
		printList(numberList);
		
	}
	
	public static void printList(List<Object> obj)
	{
		for(Object each:obj)
		{
			System.out.println(each);
		}
		System.out.println("Total size of the list:"+obj.size());
	}

}
