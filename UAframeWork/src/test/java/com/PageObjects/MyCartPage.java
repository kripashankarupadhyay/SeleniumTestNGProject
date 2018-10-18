package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class MyCartPage {
	
	static By productname = By.xpath("(.//*[@id='UpdateForm']//following-sibling::a//h3)[1]");
	static By stylenumber = By.xpath(".//*[@id='Style'])[1]");
	static By checkoutBtn = By.xpath(".//*[@value='CHECKOUT']");	
	static By continueshoppingBtn = By.xpath(".//*[@value='CONTINUE SHOPPING']");
	static By sourcecodeText = By.xpath(".//*[@id='EditSourceCodePanel']/input");
	static By sourcecodeApplyBtn = By.xpath(".//*[@id='EditSourceCodePanel']/span/input");
	
	
	public static void cartpageValidation(WebDriver driver) 
	   {
		 try {
		TestBase.waitFor(5);
		String productnameMycartPage = driver.findElement(productname).getText();
		System.out.println(productnameMycartPage);
		TestBase.waitFor(1);
		/*String stylenumbername = driver.findElement(stylenumber).getText();
		System.out.println(stylenumbername);*/
		TestBase.waitFor(1);
		driver.findElement(checkoutBtn).click();
		TestBase.waitFor(5);
		
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	

}
