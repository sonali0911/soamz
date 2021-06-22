package com.test.classes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.beust.jcommander.Parameters;
import com.pom.classes.HomePage;
import com.pom.classes.plantPage;

import testBrowserSetup.Pojo;
import utilities.Utility;



public class Testone extends Pojo {
	 WebDriver driver;
	private HomePage homepage;
	private plantPage plantpage;
	int testID;
	static ExtentTest test;
	//static ExtentHtmlReporter reporter;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		reporter = new ExtentHtmlReporter("test-output//ExtendReport//Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
		 if(browser.equalsIgnoreCase("Chrome"))
		 {
			 driver = openChromeBrowser();
		 }
		 else if(browser.equalsIgnoreCase("Firefox"))
		 {
			 driver = openFirefoxBrowser();
		 }
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Launch the browser and enter URL");
//		System.setProperty("webdriver.chrome.driver","C:\\seleniumm\\chromedriver.exe");
//		driver = new ChromeDriver();
//		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
//		
	    driver.get("https://www.amazon.in/");
	    
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		//homepage.selectThePlant();
	}
	@Test
	public void verifyPlantsPage() throws InterruptedException, EncryptedDocumentException, IOException
	{Thread.sleep(5000);
		System.out.println("verify plants page");
		homepage = new  HomePage(driver);
		Thread.sleep(3000);
		homepage.sendDataOnSearchBar(0,0);
		homepage.clickOnSearchButton();
		//homepage.clickOnTask();
		String url = driver.getCurrentUrl();
		
		if(url.equals("https://www.amazon.in/s?k=plants&ref=nb_sb_noss"))
		{
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
		
	}
//	
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshot(driver, testID);
		}
		Thread.sleep(10000);
		System.out.println("after method");
	}
	@AfterClass
	public void afterClass()
	{
		//driver.close();
	}
	
	@AfterTest
	public void closedBrowser()
	{
		System.out.println("After Test");
//		driver.quit();
//		driver = null;
//		System.gc();
	}
	
	
	
}
