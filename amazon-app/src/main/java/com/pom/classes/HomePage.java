package com.pom.classes;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelData;

public class HomePage {
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbar;
	
	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchbtn;
	
	@FindBy (xpath="(//span[text()='Ugaoo Good Luck Jade Plant with Self Watering Pot'])[1]")
	private WebElement plant;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendDataOnSearchBar(int a,int b) throws EncryptedDocumentException, IOException
	{
		boolean result = searchbar.isEnabled();
		if(result == true)
		{
			searchbar.sendKeys(ExcelData.getDataFromExcelSheet1(a,b));
		}
		else
		{
			System.out.println("searchbar is not visible");
		}
		
	}
	public void clickOnSearchButton()
	{
		searchbtn.click();
		System.out.println("hii");
	}
	public void selectThePlant()
	{
		plant.click();
	}
//	public void getDetailsOfBook()
//	{
//		System.out.println(book.getText());
//	}//
//	public void selectQuantity()
//	{Select s = new Select(quantity);
//		s.selectByValue("1");
//	}
   
//    public void proceedToBuy()
//    {
//    	proceedtobuy.click();
//    }
//    
   
	
}
