package framework;

import org.testng.annotations.Test;

public class DeleteRequest extends BaseRequest{
	
	@Test(dependsOnMethods= {"framework.CreateChangeRequest.createRequest"})
	public void deleteRequest()
	{
		response = headers.delete(sys_id);
		
		System.out.println("Issue got deleted successfully:"+number);
		
	}

}
