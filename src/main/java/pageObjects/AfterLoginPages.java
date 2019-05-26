package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterLoginPages {
	
	WebDriver driver;
		public AfterLoginPages(WebDriver driver)
		{
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
		}


		
	@FindBy(id = "user_email")
	WebElement UserName;
	public WebElement UserName()	{ return UserName;}
	
	@FindBy(id = "user_password")
	WebElement Pwd;
	public WebElement Pwd()	{ return Pwd;}
	
	@FindBy(xpath = "//input[@name='commit']")
	WebElement LoginClick;
	public WebElement LoginClick()	{ return LoginClick;}
			
			
}
