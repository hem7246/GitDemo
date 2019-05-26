package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {
	
	WebDriver driver;
		public LoginPages(WebDriver driver)
		{
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
		}



	//other declation also user	By username =By.xpath("//input[@id='login1']"); than no need to pageFactory in constructor
//	public WebElement UserNameEnter()
//	{
//		return driver.findElement(username);
//		
//	}
//	
		
		 By login =By.cssSelector("a[href*='sign_in']");
		 
		 
	public WebElement login()	
	{
		return driver.findElement(login);
			
		}
		
		
	@FindBy(css = "a[href*='sign_in']")
	WebElement SignIn;
	public WebElement SignIn()	{ return SignIn;}
			
}
