package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
public OrganizationsPage(WebDriver driver) { //constructor
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createneworgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchdrpdwn;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchdrpdwn() {
		return searchdrpdwn;
	}

	public WebElement getCreateneworgBtn() {
		return createneworgBtn;
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		 Alert alert = driver.switchTo().alert();
         
         // Print the alert message (optional)
         System.out.println("Alert message: " + alert.getText());
         
         // Accept the alert (click OK)
         alert.accept();
		// TODO Auto-generated method stub
		
	}
	

}
