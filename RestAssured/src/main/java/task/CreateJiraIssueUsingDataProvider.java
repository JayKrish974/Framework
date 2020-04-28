package task;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateJiraIssueUsingDataProvider {
	
	@DataProvider(name="getFiles",parallel=true)
	public Object[] getData()
	{
		String[] filename=new String[2];
		filename[0]="createissue.json";
		filename[1]="createissue1.json";
		return filename;
	}
	
	@Test(dataProvider="getFiles",invocationCount=2)
	public void createJIRAIssue(String filename)
	{
		RestAssured.baseURI="https://vishveshwarduraiswamy.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("vichuharish06@gmail.com", "9rQI3ccdhZrexSAjYgaD9552");
		
		File createIssueFile=new File("./data/"+filename);
		
		Response response = RestAssured.given().contentType(ContentType.JSON).
				header(new Header("accept","application/json")).
				log().all().
				body(createIssueFile).post();
		
		JsonPath path=response.jsonPath();
		String issueId=path.get("id");
		String key=path.get("key");
		
		System.out.println(issueId+"="+key);
		
	}

}
