package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.Webdriverutility;
/**
 * @author user1
 * Contains Login Page Elements and business library like login()
 */

public class LoginPage extends Webdriverutility{
	WebDriver driver;
	//rule 1-create a separate java class
	
    //rule -2 object creation(identify all the elements using @findby annotation)
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	//rule 3-Object initialization
	public LoginPage(WebDriver driver) { //constructor
		
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	//rule 4 - Object Encapsulation
	
	

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//rule 5-provide action(business library)
	/**
	 * login to application based on username , password , url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void logintoapp(String url,String username,String password) {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//instead of this call the method from webdriver utility
		waitforpagetoload(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
	
	

}
