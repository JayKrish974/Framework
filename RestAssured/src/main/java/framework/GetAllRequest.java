package framework;

import java.util.List;

import org.testng.annotations.Test;

public class GetAllRequest extends BaseRequest{
	
	@Test
	public void getAllChangeRequest()
	{
		response=headers.get();
		
		path=response.jsonPath();
		List<String> eachNumber=path.getList("result.number");
		
		int count=eachNumber.size();
		
		int random=(int) Math.floor(Math.random() * count);
		System.out.println(random);
		
		number=path.get("result[random].number");
		
/*		for(String each:eachNumber)
		{
			number=each;
			System.out.println(number);
		}*/
	
	}

}
