package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{

	    //WebElement class object define statically
		private static WebElement element = null;
		
		//Webelement for email/ username textbox
		public static WebElement Email_Address(WebDriver driver)
		 {
		    try{
		    	element = driver.findElement(By.xpath("//input[@type='email']"));
		    }catch(Exception e)
		    {
		    	System.out.println("Login_Page-Email address text box not found");
		    }
		    return element;
		 }
		
		//Webelement for password textbox
		public static WebElement Password(WebDriver driver)
		{
			try {
				element=driver.findElement(By.xpath("//input[@type='password']"));
			}catch(Exception e)
			{
				System.out.println("Login_Page - Password textbox not found");
			}
			return element;
		}
		
		//Webelement for Sign Button
		public static WebElement SignButton(WebDriver driver)
		{
			try {
				element=driver.findElement(By.xpath("//button[@button-text='trans.LoginForm_signin']"));
				}catch(Exception e)
				{
				System.out.println("Login_Page - Submit button not found");
				}
			return element;
		}
		
		//WebElement for Fogot password link
		public static WebElement ForgotPassword(WebDriver driver)
		{
			try {
				element = driver.findElement(By.xpath("//a[@class='left forgot_password']"));
			}catch(Exception e)
			{
				System.out.println("LoginPage - forgot password link text not found");
			}
			return element;
		}
		
		//WebElement for Create new account
		public static WebElement CreateAccount(WebDriver driver)
		{
			try {
				element = driver.findElement(By.xpath("//a[@class='button right']"));
			}catch(Exception e)
			{
				System.out.println("LoginPage - Create account button not found");
			}
			return element;
		}
		
}
