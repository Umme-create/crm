package Practice_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.Excelutility;

public class Getproductinfo_Dataprovider {
	@Test(dataProvider ="getData" )
	public void getproductinfoTest(String brandname,String productname) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture product info
		
		String x="//span[text()='"+productname+"']/../../../..//div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]/span/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		Excelutility elib=new Excelutility();
		int rowcount = elib.getrowcount("product");
		
		
		Object[][] objarr=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
			objarr[i][0]=elib.getdatafromexcel("product",i+1, 0);
			objarr[i][1]=elib.getdatafromexcel("product",i+1, 1);
		}
		
		
//		objarr[0][0]="iphone";
//		objarr[0][1]="Apple iPhone 15 (128 GB) - Black";
//		
//		objarr[1][0]="iphone";
//		objarr[1][1]="Apple iPhone 13 (128GB) - Midnight";
//		
//		objarr[2][0]="iphone";
//		objarr[2][1]="Apple iPhone 13 (128GB) - Starlight";
		
		return objarr;
	}

}
