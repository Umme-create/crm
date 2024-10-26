package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) { // constructor

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	@FindBy(linkText = "Products")
	private WebElement productlink;

	public WebElement getProductlink() {
		return productlink;
	}

	@FindBy(linkText = "Organizations")
	private WebElement orglink;

	@FindBy(linkText = "Contacts")
	private WebElement contactlink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;

	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;

	public void navigatetocampaignpage() {
		Actions a1 = new Actions(driver);
		a1.moveToElement(morelink).perform();
		campaignlink.click();
	}

	public void logout() {
		Actions a1 = new Actions(driver);
		a1.moveToElement(adminimg).perform();
		signoutlink.click();
	}

	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

}
