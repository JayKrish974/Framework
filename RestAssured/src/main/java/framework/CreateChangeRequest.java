package framework;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.Header;

public class CreateChangeRequest extends BaseRequest{
	
	@Test(dataProvider="getData")
	public void createRequest(String filename)
	{
		File data=new File("./data/"+filename);

		response = headers.header(new Header("Content-Type","application/json")).body(data)
				.post();
		
		path=response.jsonPath();
		number=path.get("result.number");
		sys_id=path.get("result.sys_id");
		System.out.println(number+"="+sys_id);
		
	}

}
