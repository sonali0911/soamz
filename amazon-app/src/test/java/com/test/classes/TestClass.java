package com.test.classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pom.classes.HomePage;
import com.pom.classes.plantPage;
import com.pom.classes.signInPage;

public class TestClass {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	System.setProperty("webdriver.chrome.driver","C:\\seleniumm\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40);
	//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	
    driver.get("https://www.amazon.in/");
    SoftAssert softassert = new SoftAssert();
    driver.manage().window().maximize();
	
	HomePage homepage = new HomePage(driver);
	homepage.sendDataOnSearchBar(0,0);
	homepage.clickOnSearchButton();
	homepage.selectThePlant();
	 
	String s1=driver.getCurrentUrl();
	System.out.println(s1);
	
	String s2 = "https://www.amazon.in/Nurturing-Green-Lucky-Bamboo-Layer/dp/B00O73ISWI/ref=sr_1_5?dchild=1&keywords=plants&qid=1623141485&sr=8-5";
	Assert.assertEquals(s1,s2);
	//Assert.assertNotEquals(s1,s2);
	//Assert.assertTrue(true, "corect");
	//homepage.getDetailsOfBook();
	//homepage.selectPaperBackFormat();
 ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
 driver.switchTo().window(addr.get(1));
 plantPage plantpage = new plantPage(driver);
 
	//homepage.selectQuantity();
// WebDriverWait wait = new WebDriverWait(driver, 40);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']")));
	
	plantpage.addToCart();
	String ss2=driver.getCurrentUrl();
	System.out.println(ss2);
	plantpage.proceedToBuy();
	
	signInPage signinpage = new signInPage(driver);
	signinpage.sendUserName(1,0);
	signinpage.clickOnContinueButton();
	
	softassert.assertAll();
	}
}
