package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class ConfirmationPage {

	static By orderNumberText = By.xpath(".//*[@id='ReviewContainer']/div/p[1]");
	static By surveybizrate = By.xpath("//[contains(text(),'Close [X]')]");
	static By surveyInternal = By.xpath(".//*[@class='close']");
	
	
	
	public static void confirmationvalidation(WebDriver driver) 
	   {
		 try {
		TestBase.waitFor(10);
		String orderId = driver.findElement(orderNumberText).getText();
		String[] parts = orderId.split("#");
		//String part1 = parts[0]; // 004
		String part2 = parts[1];
		String[] splitStr = part2.split("\\s+");
		String orderNumber = splitStr[2];
		System.out.println(orderNumber);
		
		/*String[] splitStr1 = orderstr.split(".");
		String orderNumber = splitStr1[1];
		System.out.println("OrderNumber is :: "+orderNumber);*/
		
	       
        if((driver.findElement(surveyInternal))!=null)
        {
        	System.out.println("element available");
        	driver.findElement(surveyInternal).click();
        }
        else if((driver.findElement(surveybizrate))!=null)
        {
        	System.out.println("element NOT available");
        	driver.findElement(surveybizrate).click();
        }		
		TestBase.waitFor(10);
		
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	
	
	
	
	
	
}
