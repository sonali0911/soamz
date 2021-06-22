package com.pom.classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelData;

public class signInPage {

	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement mobileno;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement clickcontinue;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement pass;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signin;
	
	public signInPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendUserName(int a,int b) throws EncryptedDocumentException, IOException
	{
		mobileno.sendKeys(ExcelData.getDataFromExcelSheet(a,b));
		
	}
	
	
	public void clickOnContinueButton()
	{
		clickcontinue.click();
	}
	public void sendPassword(int a, int b) throws EncryptedDocumentException, IOException
	{
		pass.sendKeys(ExcelData.getDataFromExcelSheet1(a,b));
		
	}

	public void clickOnSignIn()
	{
		signin.click();
	}

}
