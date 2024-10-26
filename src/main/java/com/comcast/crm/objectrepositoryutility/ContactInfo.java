package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {
	WebDriver driver;

	public ContactInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Last Name")
	private WebElement actLastName;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement enddate;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startdate;

	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActLastName() {
		return actLastName;
	}

}
