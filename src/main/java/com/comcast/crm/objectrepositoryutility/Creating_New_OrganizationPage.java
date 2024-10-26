package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Creating_New_OrganizationPage {
	
	WebDriver driver;
public Creating_New_OrganizationPage(WebDriver driver) { //constructor
		
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

     @FindBy(name="accountname")
     private WebElement orgnameEdt;
     
     @FindBy(xpath="//input[@title='Save [Alt+S]']")
     private WebElement saveBtn;
     
     @FindBy(name="industry")
     private WebElement industrydrpdwn;
     
     @FindBy(name="accounttype")
     private WebElement typedrpdwndrpdwn;
     
     
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createorg(String orgname) {
		orgnameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	
	public void createorg(String orgname,String industry,String type) {
		orgnameEdt.sendKeys(orgname);
		Select s1=new Select(industrydrpdwn);
		s1.selectByVisibleText(industry);
		Select s2=new Select(typedrpdwndrpdwn);
		s2.selectByVisibleText(type);
		saveBtn.click();
	}

}
