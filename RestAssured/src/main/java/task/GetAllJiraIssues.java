package task;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllJiraIssues {
	
	@Test
	public void getJiraIssues()
	{
		RestAssured.baseURI="https://vishveshwarduraiswamy.atlassian.net/rest/api/2/search";
		RestAssured.authentication=RestAssured.preemptive().basic("vichuharish06@gmail.com", "9rQI3ccdhZrexSAjYgaD9552");
		
		Response response=RestAssured.given().contentType(ContentType.JSON).get();
		
		JsonPath path=response.jsonPath();
		List<String> issuesId=path.getList("issues.id");
		
		for(String each:issuesId)
		{
			System.out.println(each);
		}
		
		System.out.println(issuesId.size());
		
	}

}
