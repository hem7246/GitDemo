package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	//Main class for return Driver Set up....
	
	public WebDriver initiazlizerDriver() throws IOException {
		prop=	new Properties();
	FileInputStream Fs =new FileInputStream("C:\\Users\\hemant\\ProjectAll\\src\\main\\java\\Resources\\data.properties");
	prop.load(Fs);
	String browser =prop.getProperty("browser")	;
	
	if (browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","F:\\2019\\selenium\\v73\\chromedriver.exe");

		driver= new ChromeDriver();
	}
	
	else if (browser.equalsIgnoreCase("FireFox"))
	{
		System.setProperty("webdriver.gecko.driver", "F:\\2019\\selenium\\driver\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("IE"))
	{
	}
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}//initiazlizerDriver
	
	public void getScreenshot(String result) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}
	}//BaseClass
	

