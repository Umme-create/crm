package com.comcast.crm.baseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseutility;
import com.comcast.crm.generic.fileutility.Excelutility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.Webdriverutility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	//create object
	     public DataBaseutility dblib=new DataBaseutility();
	     public Fileutility flib=new Fileutility();
		 public	Excelutility elib=new Excelutility();
		 public	Javautility jlib=new Javautility();
	   	public Webdriverutility wlib=new Webdriverutility();
		 public  WebDriver driver=null;
		 public static  WebDriver sdriver=null;
	
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws Throwable {
		System.out.println("=======Connect to DB, Report Config======");
		dblib.getDbconnection();
		
		
	}
	
	
	
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {//yape configBC(String browser)
		System.out.println("=========launch browser=======");
		//String Browser=flib.getdatafrompropertiesfile("browser");// = Browser;
		String BROWSER=System.getProperty("browser" ,flib.getdatafrompropertiesfile("browser"));
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject .setDriver(driver);
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void congigBM() throws Throwable {
		System.out.println("======login=====");
//		String Url = flib.getdatafrompropertiesfile("url");
//		String Username = flib.getdatafrompropertiesfile("username");
//		String password = flib.getdatafrompropertiesfile("password");
		String URL=System.getProperty("url" ,flib.getdatafrompropertiesfile("url"));
		String USERNAME=System.getProperty("username" ,flib.getdatafrompropertiesfile("username"));
		String PASSWORD=System.getProperty("password" ,flib.getdatafrompropertiesfile("password"));
		
		LoginPage lp=new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("=======logout==========");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void congigAC() {
		System.out.println("=========close the browser========");
		driver.quit();
		
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void congigAS() throws Throwable {
		System.out.println("=========Close DB , Report Backup=======");
		dblib.closeDbconnection();
		
	
	}
	

	
	

}
