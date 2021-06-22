package com.test.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.classes.HomePage;
import com.pom.classes.plantPage;

public class TestTwo {
	private WebDriver driver;
	private HomePage homepage;
	private plantPage plantpage;
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Launch the browser and enter URL");
		System.setProperty("webdriver.chrome.driver","C:\\seleniumm\\chromedriver.exe");
		driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
	    driver.get("https://www.amazon.in/");
	    driver.manage().window().maximize();
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		
		 
	}
	@Test
	public void verifySelectedPlant() throws InterruptedException, EncryptedDocumentException, IOException
	{Thread.sleep(5000);
		System.out.println("verify Selected plant");
		homepage = new  HomePage(driver);
		Thread.sleep(3000);
		homepage.sendDataOnSearchBar(0,0);
		homepage.clickOnSearchButton();
		
		homepage.selectThePlant();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(addr.get(1));
		//homepage.sendDataOnSearchBar();
		//homepage.clickOnSearchButton();
		
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Ugaoo Good Luck Jade Plant with Self Watering Pot"))
		{
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException
	{
		System.out.println("verified plant's name");
	}
	@AfterClass
	public void afterClass()
	{
//		driver.close();
	}
}
