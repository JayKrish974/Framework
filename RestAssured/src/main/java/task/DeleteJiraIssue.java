package task;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteJiraIssue {
	
	@Test
	public void deleteRespectiveJiraIssue()
	{
		RestAssured.baseURI="https://vishveshwarduraiswamy.atlassian.net/rest/api/3/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("vichuharish06@gmail.com", "9rQI3ccdhZrexSAjYgaD9552");
		
		String issueId="Res-59";
		
		Response response=RestAssured.given().delete(issueId);
		
		Assert.assertEquals(response.getStatusCode(), 204,"Error in issue id:"+issueId);
		
		System.out.println("Issue deleted successfully");
	}

}
