package com.pom.classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class plantPage {
//	@FindBy (xpath="//select[@name='quantity']")
//	private WebElement quantity;
	
	@FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement cart;
	
	@FindBy (xpath="//span[@id='nav-cart-count']")
	private WebElement cartcontains;
	@FindBy (xpath="//div[@data-name='Active Cart']")
	private WebElement shoppingcart;
	@FindBy (xpath="//div[@class='a-column a-span2 a-text-right sc-item-right-col a-span-last']")
	private WebElement amount;
	//
	@FindBy (xpath="//span[@id='sc-subtotal-amount-activecart']")
	private WebElement totalamount;
	//
	
	@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
	private WebElement proceedtobuy;
	
	
	public plantPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	 public void addToCart() 
	    {
		 	cart.click();
	    }
	 public void insideCart()
	 {
		 cartcontains.click();
		
	 }public String noOfItemsInCart()
	 {
		 String cartt= cartcontains.getText();
	
		 //System.out.println(cartt);
		return cartt;
	 }
	 public String ShoppingCart()
	 {
		 String s= shoppingcart.getText();
		 return s;
		 }
	 public String amountofItem()
	 {
		 String a = amount.getText();
		 return a;
	 }
	 public String amountInCart()
	 {
		 String price = totalamount.getText();
		 return price;
	 }
	 public void proceedToBuy()
	 	{
		 	proceedtobuy.click();
	 	}
}
