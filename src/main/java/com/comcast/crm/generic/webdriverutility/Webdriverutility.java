package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
	public void waitforpagetoload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public void waitforelementpresent(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void switchtotabonurl(WebDriver driver,String partialurl) {
		Set<String> set =driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			
			
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(partialurl)) {
				break;
			}
		}
	}
	public void switchtotabontitle(WebDriver driver,String partialtitle) {
		Set<String> set =driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			
			
			String acturl = driver.getTitle();
			if(acturl.contains(partialtitle)) {
				break;
			}
		}
	}
	
	public void switchtoframe(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoframe(WebDriver driver,String nameid) {
		driver.switchTo().frame(nameid);
	}
	public void switchtoframe(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchtoalertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchtoalertandCancle(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String text) {
		Select s1=new Select(element);
		s1.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index) {
		Select s1=new Select(element);
		s1.selectByIndex(index);
	}
	
	public void mousemoveonElement(WebDriver driver,WebElement element) {
		Actions a1=new Actions(driver);
		a1.moveToElement(element).perform();
	}
	
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions a1=new Actions(driver);
		a1.doubleClick(element).perform();
	}
	

}
