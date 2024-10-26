package Practice_Test;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

//@Listeners(com.comcast.crm.listenerutility.listenerimpclass.class)
public class Invoicee  {
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerimp.class)
	public void activatesim() {
		System.out.println("execute createinvoiceTest");
		//String acttitle = driver.getTitle();
		//Assert.assertEquals("", "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
		
	}


}
