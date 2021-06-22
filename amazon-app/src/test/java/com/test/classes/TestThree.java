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
import com.pom.classes.signInPage;

public class TestThree {
	private WebDriver driver;
	private HomePage homepage;
	private plantPage plantpage;
	private signInPage signinpage;
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
	public void beforeMethod() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		homepage = new  HomePage(driver);
		Thread.sleep(3000);
		homepage.sendDataOnSearchBar(0,0);
		homepage.clickOnSearchButton();
		
		homepage.selectThePlant();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(addr.get(1));
		 
	}
	
		
	@Test
	public void VerifyItemsInCart() throws InterruptedException
	{ 
		Thread.sleep(3000);
		plantpage =new plantPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));
		//cart.click();
		plantpage.addToCart();
		Thread.sleep(3000);
		String s2=driver.getCurrentUrl();
		System.out.println(s2);
		
		//plantpage.proceedToBuy();
		plantpage.insideCart();
		Thread.sleep(3000);
		System.out.println("---------------------------------------------------------------");
	String a =plantpage.noOfItemsInCart();
	ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(addr.get(1));
	// System.out.println(driver.getCurrentUrl());
	//driver.navigate().to("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
	String ss=plantpage.ShoppingCart();
	System.out.println(ss);
	System.out.println("-------------------------------------------------------------------");
	if(ss.contains("Ugaoo Good Luck Jade Plant with Self Watering Pot"))
	
		
		{
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
	
	String p = plantpage.amountInCart();
	System.out.println(p);
	String b = plantpage.amountofItem();
	System.out.println(b);
	Thread.sleep(3000);
	if(p.equals(b))
	{
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException, EncryptedDocumentException, IOException
	{
		plantpage.proceedToBuy();
		signinpage = new signInPage(driver);
		signinpage.sendUserName(1,0);
		signinpage.clickOnContinueButton();
	}
	@AfterClass
	public void afterClass()
	{
//		driver.close();
	}
}
