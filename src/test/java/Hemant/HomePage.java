package Hemant;



import java.io.IOException;
import java.util.NoSuchElementException;

import javax.xml.xpath.XPath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.BaseClass;
import pageObjects.AfterLoginPages;
import pageObjects.LoginPages;

public class HomePage extends BaseClass{
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void InitialicationDriver() throws IOException
	{
		Log.info("Driver initiazlizerDriver.....");
			driver=initiazlizerDriver();
			Log.info("Driver initiazlizerDriver Done.....");	
	}
	
	public boolean isElementPresent(By locatorKey) {
	    try {
	        driver.findElement(locatorKey);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	public boolean isElementVisible(String cssLocator){
	    return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
	}
	
	@Test(dataProvider = "getData")
	
	public void basePageNavigation(String UserName,String Password) throws IOException, InterruptedException
	{
		//BaseClass which under academy Folder Method call,its public method
		//driver object also public in BaseClass
		Log.info("basePageNavigation indise.....");
		
		driver.get(prop.getProperty("url"));
		//Log.info("Url Get From Prop.........");
		
	
	//	driver.switchTo().alert().dismiss();
		Log.info("Login Page Object Call.........");
		LoginPages loginPage =new LoginPages(driver);
		Log.info("Login Signin Object Call.........");
		
		
		Actions act = new Actions(driver);

		Thread.sleep(6000);

		
		
		
		
			if (isElementPresent( By.xpath("//button[contains(text(),'NO THANKS')]") ))
			{
					WebElement ele =driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]"));
						act.moveToElement(ele).click().build().perform();
			}
		
				

	
		loginPage.SignIn().click();
		Thread.sleep(4000);
		Log.info("Afet Login Object Call.........");
		AfterLoginPages loginPage1 =new AfterLoginPages(driver);
		Log.info("Afet Login UserName Call.........");
		loginPage1.UserName().sendKeys(UserName);
		Log.info("Afet Login pwd Call.........");
		loginPage1.Pwd().sendKeys(Password);
	//	System.out.println(Authorized); 
		Log.info("After Login LoginClick Call.........");
			loginPage1.LoginClick().click();
	
		
		//loginPage.login().click();
		
		
	}
	//for multiple Test Case with Different username pwd..
	@DataProvider
	public Object[][] getData() {
		
		Object [][] data=new Object[2][2];
		
		data[0][0]="hem7246@gmail.com";
		data[0][1]="hemant3011";
		//data[0][2]="Restricted User";
		
		
		data[1][0]="hem7246@gmail.com";
		data[1][1]="hemant3011";
		//data[1][2]="Non Restricted User";
		
		return data;
	}
	
	
	@AfterTest
	public void CuurentopenTabclosed()
	{
			driver.close();
			driver=null;
			
			
	}
	
	


}
