package base;

import java.io.File;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostRequestUsingDataProvider {
	
	@DataProvider(name="getData",parallel=true)
	public Object[] getData()
	{
		String[] filename=new String[3];
		filename[0]="data1.json";
		filename[1]="data2.json";
		filename[2]="data3.json";
		return filename;
	}
	
	@Test(dataProvider="getData",invocationCount=2)
	public void postANewChangeRequestWithFile(String filename)
	{
		RestAssured.baseURI="https://dev90533.service-now.com//api/now/v2/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Viswa@55");

		File data=new File("./data/"+filename);
		
		Response post = RestAssured.given().contentType(ContentType.JSON).body(data).post();
		
		JsonPath response=post.jsonPath();
		String responseBody=response.get("result.number");
		String resId=response.get("result.sys_id");
		System.out.println(responseBody+"="+resId);
		
		
	}

}
