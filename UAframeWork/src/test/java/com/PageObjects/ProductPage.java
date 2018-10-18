package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class ProductPage {
	static By catagorypageProduct = By.xpath("(.//*[@class='productList']//following-sibling::img)[1]");
	static By addtocartbtn = By.xpath("//button[contains(text(),'Add to Cart')]");
	static By proceedtocheckoutbtn = By.xpath("//button[contains(text(),'Proceed to Checkout')]");
	static By continueshoppingbtn = By.xpath("//button[contains(text(),'Continue Shopping')]");
	static By Embroiderycheckbox= By.xpath("//input[@id='chkEmbroidery']");

	 
	 public static void selectProduct(WebDriver driver) 
	   {
		 try {
			 
			 TestBase.selectSize(driver);
			 TestBase.waitFor(1);
			 driver.findElement(addtocartbtn).click();
			 TestBase.waitFor(10);
			 driver.findElement(proceedtocheckoutbtn).click();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	 /*
	  * Author - Meenal 27 Sep'18 
	  * 	  */
	 public static void selectProductEmbroidery(WebDriver driver) 
	   {
		 try {
			 TestBase.waitFor(4);
			 TestBase.selectSize(driver);
			 TestBase.waitFor(5);
			 driver.findElement(Embroiderycheckbox).click();
			 TestBase.waitFor(6);
			 driver.findElement(addtocartbtn).click();
			 TestBase.waitFor(8);
			
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	 
	 

}
