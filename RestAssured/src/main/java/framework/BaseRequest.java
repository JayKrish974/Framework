package framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static RequestSpecification headers;
	public static String sys_id,number;
	
	public static Response response;
	public static JsonPath path;
	
	@BeforeSuite
	public void init()
	{
		RestAssured.baseURI="https://dev90533.service-now.com/api/now/v2/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Viswa@55");
		
		headers = RestAssured.given().log().headers();
	}
	
	
	@DataProvider(name="getData")
	public Object[] getData()
	{
		String[] filename=new String[1];
		filename[0]="data1.json";
		return filename;
	}
	
	@AfterClass
	public void endClass()
	{
		System.out.println(response.getStatusCode());
	}
	
	@AfterSuite
	public void endSuite()
	{
		
	}

}
