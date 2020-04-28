package task;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateJiraIssue {
	
	@Test
	public void createJIRAIssue()
	{
		RestAssured.baseURI="https://vishveshwarduraiswamy.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("vichuharish06@gmail.com", "9rQI3ccdhZrexSAjYgaD9552");
		
		File createIssueFile=new File("./data/createissue.json");
		
		Response response = RestAssured.given().contentType(ContentType.JSON).
				header(new Header("accept","application/json")).
				body(createIssueFile).post();
		
		response.prettyPrint();
		
		JsonPath path=response.jsonPath();
		String issueId=path.get("id");
		String key=path.get("key");
		
		System.out.println(issueId+"="+key);
		
	}

}
