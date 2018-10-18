package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class CreateAccount

{
	//WebElement class object define statically
	static By signInButton = By.xpath("//a[contains(text(),'Log In')]");
	static By enterUsername = By.xpath("//input[@id='emailfield']");
	static By enterPassword = By.xpath("//input[@id='passwordfield']");
	static By loginButton = By.xpath("//input[@name='loginbutton']");

	static By GuestUserEmail = By.xpath("(.//*[@id='EmailAddress'])[1]");
	static By GuestCheckout = By.xpath(".//*[@class='btn guestLoginButton']");

	public static void loginAccount(WebDriver driver) 
	{
		try {
			HomePage.PopUp_btn(driver); 

			TestBase.waitFor(5);
			driver.findElement(signInButton).click();
			TestBase.waitFor(4);
			driver.findElement(enterUsername).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.UserName));
			driver.findElement(enterPassword).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.Password));
			driver.findElement(loginButton).click();
			TestBase.waitFor(2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * Author - Meenal 27 Sep'18
	 */
	public static void GuestUserLoginValidation(WebDriver driver) 
	{
		try {
			TestBase.waitFor(5);
			driver.findElement(GuestUserEmail).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.UserName));
			TestBase.waitFor(1);
			driver.findElement(GuestCheckout).click();
			TestBase.waitFor(5);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
