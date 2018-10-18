package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.TestBase;

public class GuestUserLogin {

	static By GuestUserEmail = By.xpath("(.//*[@id='EmailAddress'])[1]");
	static By GuestCheckout = By.xpath(".//*[@class='btn guestLoginButton']");


	public static void GuestUserLoginValidation(WebDriver driver) 
	   {
		 try {
		TestBase.waitFor(5);
	
		String GuestUserEmailAddress = driver.findElement(GuestUserEmail).getText();
		System.out.println(GuestUserEmailAddress);
		TestBase.waitFor(6);
		driver.findElement(GuestCheckout).click();
		TestBase.waitFor(5);
		
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	



}
