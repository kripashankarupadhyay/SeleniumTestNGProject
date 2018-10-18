package com.PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import base.TestBase;
public class HomePage
{
	//WebElement class object define statically
	private static WebElement element = null;

	//Element for Sign_In dropdown 
	public static WebElement Sign_In(WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//i[@class='fa fa-chevron-down uk-login-menu__icon']"));
		}
		catch(WebDriverException we)
		{
			TestBase.implicitTime(20, driver);
			return element;
		}
		catch(Exception e)
		{
			System.out.println("Home_Page-Sign in drop down not found");
			e.printStackTrace();
		}
		return element;
	}


	//Element for Sign_In button
	public static WebElement SignIn_btn(WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//a[@href='/en/Home/Login/']"));
		}catch(Exception e)
		{
			System.out.println("Home_Page-Sign in button not found");
			e.printStackTrace();
		}
		return element;
	}


	//Element for POP_UP close button
	public static void PopUp_btn(WebDriver driver) throws InterruptedException
	{
		try
		{
			Thread.sleep(10000);
			WebElement signupPopup = driver.findElement(By.xpath("(//a[@title = 'Close'])[2]"));
			boolean popup = signupPopup.isDisplayed();
			System.out.println("Signup popup is displayed: "+popup);
			if(signupPopup.isDisplayed())
			{
				signupPopup.click();
				Thread.sleep(10000);
				//     internationalPopup.click();
			}	                  
			else
			{
				System.out.println(" else block: no pop is dislpayed");
			}
			Thread.sleep(2000); 
		}
		catch(Exception e)
		{
			System.out.println("catch block :no pop is dislpayed");
		}      

		try 
		{
			WebElement internationalPopup = driver.findElement(By.xpath("//button[@class='close']"));
			boolean popup1 = internationalPopup.isDisplayed();
			System.out.println("International shipping popup is displayed: "+popup1);
			internationalPopup.click();
		}
		catch(Exception e)
		{
			System.out.println("Second popup not displayed ");
		}		
		Thread.sleep(5000);

	}
}
