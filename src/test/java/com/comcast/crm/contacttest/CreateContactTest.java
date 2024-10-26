package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactInfo;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.Creating_New_OrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationinfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * @author user1
 */
@Listeners(com.comcast.crm.listenerutility.listenerimpclass.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = { "smokeTest", "regressionTest" })
	public void createContactTest() throws Throwable {
		// read the testScript data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = elib.getdatafromexcel("contact", 1, 2) + jlib.getrandomnumber();
		// navigate to contact module
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact link");
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		// click on + button
		
		UtilityClassObject.getTest().log(Status.INFO, "click on add contact");
		ContactPage cp = new ContactPage(driver);
		cp.getContactBtn().click();
		
		
		UtilityClassObject.getTest().log(Status.INFO, "create a contact and save");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.CreateContact(lastName);

		// verify header msg expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify header text");
		
		OrganizationinfoPage ori = new OrganizationinfoPage(driver);
		String headerText = ori.getHeaderinfo().getText().trim();
		UtilityClassObject.getTest().log(Status.PASS, "verified header text");
		boolean status = headerText.contains(lastName.trim());
		Assert.assertTrue(status);
		
		UtilityClassObject.getTest().log(Status.INFO, "verify contact creation");

		String actlastNameTxt = ori.getActLastName().getText().trim();
		SoftAssert soft = new SoftAssert();
		UtilityClassObject.getTest().log(Status.PASS, "contact created");
		soft.assertEquals(actlastNameTxt, lastName.trim());
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		// read the testScript data from excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = elib.getdatafromexcel("contact", 4, 2) + jlib.getrandomnumber();

		// navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact module");
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();
		UtilityClassObject.getTest().log(Status.INFO, "click on add contact");
		ContactPage cp = new ContactPage(driver);
		cp.getContactBtn().click();
		// Support date
		
		UtilityClassObject.getTest().log(Status.INFO, "read start date and end date from webdriver utility");
		String startDate = jlib.getsystemdateyyyyMMdd();
		String endDate = jlib.getrequireddateyyyymmdd(30);
		
		UtilityClassObject.getTest().log(Status.INFO, "create contact ");
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.CreateContact(lastName, startDate, endDate);
		
		UtilityClassObject.getTest().log(Status.INFO, "alert popup cancellation");
		wlib.switchtoalertandCancle(driver);

		// verify lastname info expected result
		UtilityClassObject.getTest().log(Status.INFO, "verify last name");
		OrganizationinfoPage ori = new OrganizationinfoPage(driver);
		String actlastNameTxt = ori.getActLastName().getText().trim();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actlastNameTxt, lastName.trim());
		soft.assertAll();
		// verify start and end date
		UtilityClassObject.getTest().log(Status.INFO, "verify start date and end date");
		ContactInfo ci=new ContactInfo(driver);
		String actstartdate = ci.getStartdate().getText();
		Assert.assertEquals(actstartdate.trim(),startDate );
		
		String actenddate = ci.getEnddate().getText();
		Assert.assertEquals(actenddate.trim(),endDate );
		}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		String lastName = elib.getdatafromexcel("contact", 7, 3);
		String orgName = elib.getdatafromexcel("contact", 7, 2) + jlib.getrandomnumber();

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateneworgBtn().click();
		Creating_New_OrganizationPage cno = new Creating_New_OrganizationPage(driver);
		cno.createorg(orgName);

		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerText.contains(orgName)) {
			System.out.println(orgName + " is verified ==pass");
		} else {
			System.out.println(orgName + " is not verified ==fail");
		}

		hp.getContactlink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getContactBtn().click();

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.CreateContact(lastName, orgName);

		String headerText1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		// verify header msg expected result
		if (headerText1.contains(lastName)) {
			System.out.println(lastName + " is verified ==pass");
		} else {
			System.out.println(lastName + " is not verified ==fail");

		}
		// verify organization name
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is verified ==pass");
		} else {
			System.out.println(orgName + " is not verified ==fail");

		}
	}

}
