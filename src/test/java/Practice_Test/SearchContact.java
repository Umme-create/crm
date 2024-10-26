package Practice_Test;
/**
 * @author user1
 * test class for contact module
 */

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContact extends BaseClass {
	/**
	 * Scenario: login()==>navigate to Contact===>create contact===>verify
	 */
	@Test
	public void searchcontactTest() {
		/*
		 * step-1:login to app
		 */
		LoginPage lp=new LoginPage(driver);
		lp.logintoapp("url", "username", "password");
	}

}
