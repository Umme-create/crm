package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {//rule 1-create a separate java class
	//rule -2 object creation(identify all the elements using @findby annotation)
	WebDriver driver;
public OrganizationinfoPage(WebDriver driver) { //constructor
		
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
     
     @FindBy(className="dvHeaderText")
     private WebElement headerinfo;
     
     @FindBy(id="mouseArea_Last Name")
     private WebElement actLastName;
     
     
	public WebElement getHeaderinfo() {
		return headerinfo;
	}


	public WebElement getActLastName() {
		
		// TODO Auto-generated method stub
		return actLastName;
	}
	



}
