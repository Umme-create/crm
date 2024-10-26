package Practice_Test;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;

//@Listeners(com.comcast.crm.listenerutility.listenerimpclass.class)
public class Invoice extends BaseClass {
	@Test
	public void createinvoiceTest() {
		System.out.println("execute createinvoiceTest");
		String acttitle = driver.getTitle();
		Assert.assertEquals(acttitle, "login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
		
	}
	
	@Test
	public void createinvoicewithContactTest() {
		System.out.println("execute createinvoicewithContactTest");
		
		
	}

}
