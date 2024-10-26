package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.Webdriverutility;
import com.comcast.crm.listenerutility.listenerimpclass;
import com.comcast.crm.objectrepositoryutility.Creating_New_OrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationinfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.listenerimpclass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void CreateOrganizationtest() throws Throwable {
		// generate the random number
		int random = jlib.getrandomnumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read test script data from excel
		String orgname = elib.getdatafromexcel("org", 1, 2) + random;
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to orgpage");
		// step-2:navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		
		// hp.navigatetocampaignpage();
		UtilityClassObject.getTest().log(Status.INFO, "navigate to createorgpage");
		// step-3:click on create organization button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateneworgBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		// step-4:enter all the details and create organization
		Creating_New_OrganizationPage cnop = new Creating_New_OrganizationPage(driver);
		cnop.createorg(orgname);
		UtilityClassObject.getTest().log(Status.INFO,orgname+ "====>create new org");
		
		// Verify Header msg Expected Result
		OrganizationinfoPage oip = new OrganizationinfoPage(driver);
		String actorgname = oip.getHeaderinfo().getText();
		Assert.assertEquals(true, actorgname.contains(orgname) );

		// Verify Header msg Expected Result
//		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(headerinfo.contains(orgname)) {
//			System.out.println(orgname + "is created===pass");
//		}else {
//			System.out.println(orgname + "is not created===fail");
//		}
//		 
		// Verify Header orgname info Expected Result
//		String actorgname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		/*
		 * if(actorgname.contains(orgname)) { System.out.println(orgname +
		 * "is created===pass"); }else { System.out.println(orgname +
		 * "is not created===fail"); }
		 */

	}

	@Test(groups = "regressionTest")
	public void CreateOrganizationWithIndustriesTest() throws Throwable {
		// read the testScript data from excel file
		String orgname = elib.getdatafromexcel("org", 4, 2) + jlib.getrandomnumber();
		String industry = elib.getdatafromexcel("org", 4, 3);
		String type = elib.getdatafromexcel("org", 4, 4);

		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		// click on organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateneworgBtn().click();
		Creating_New_OrganizationPage cno = new Creating_New_OrganizationPage(driver);
		cno.createorg(orgname, industry, type);
		// verify the dropdown industry and type info
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.equals(industry)) {
			System.out.println(industry + " information is verified ==pass");
		} else {
			System.out.println(industry + " information is not verified ==fail");
		}

		// verify header orgName info expected result
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.contains(type)) {
			System.out.println(type + " information is verified ==pass");
		} else {
			System.out.println(type + " information is not verified ==fail");
		}

	}

//	@Test
//	public void CreateOrganizationwithPhoneNumberTest() {
//
//	}

	@Test(groups = "regressionTest")
	public void Deleteorgtest() throws Throwable {
		String orgname = elib.getdatafromexcel("org", 10, 2) + jlib.getrandomnumber();
		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
		// navigate to campaign page
		// hp.navigateToCampaignPage();
		// click on organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateneworgBtn().click();

		Creating_New_OrganizationPage cnop = new Creating_New_OrganizationPage(driver);
		cnop.createorg(orgname);

		OrganizationinfoPage oi = new OrganizationinfoPage(driver);
		String headerText = oi.getHeaderinfo().getText();

		if (headerText.contains(orgname)) {
			System.out.println(orgname + " is verified ==pass");
		} else {
			System.out.println(orgname + " is not verified ==fail");

		}
		// go back to organization page
		hp.getOrglink().click();
		// search for organization
		op.getSearchEdt().sendKeys(orgname);
		wlib.select(op.getSearchdrpdwn(), "Organization Name");
		op.getSearchBtn().click();

		driver.findElement(By.xpath("//a[text()='" + orgname + "']/../../td[8]/a[text()='del']")).click();
		op.switchToAlertAndAccept(driver);

	}

}
