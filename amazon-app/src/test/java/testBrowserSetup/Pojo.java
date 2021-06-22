package testBrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;

public class Pojo {
	
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\seleniumm\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","C:\\seleniumm\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
