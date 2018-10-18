package com.PageObjects;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class PaymentPage {

	static By cardNumberText = By.xpath("//input[@id='CreditCard_CardNumberMasked']");
	static By expMonthText = By.xpath("//select[@name='CreditCard.ExpirationMonth']");
	static By expYearText = By.xpath("//select[@name='CreditCard.ExpirationYear']");
	static By securitycodeText = By.xpath("//input[@title='The Security Code is required']");
	static By reviewOrderBtn = By.xpath("//input[@value='Review Order']");
	static By placeOrderBtn	= By.xpath("//input[@value='Place your Order']");


	public static void paymentValidation(WebDriver driver) 
	{
		try {
			TestBase.waitFor(10);
			System.out.println("Data not added");
			WebElement ele1 = driver.findElement(cardNumberText);
		
			Actions inputclick = new Actions(driver); 
			Actions inputText = inputclick.moveToElement(ele1).click().sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.cardNumber));
			inputText.build().perform();
			TestBase.waitFor(1);
			System.out.println("Data is added");
			
			Robot robot = new Robot();
			WebElement month =driver.findElement(expMonthText);
			month.click();
			TestBase.waitFor(2);
			Select se=new Select(month);
			se.selectByValue("5");
			TestBase.waitFor(2);
			
			WebElement year=	driver.findElement(expYearText);
			year.click();
			TestBase.waitFor(2);
			Select yy=new Select(year);
			yy.selectByValue("2020");
			
			driver.findElement(securitycodeText).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.securitycode));
			driver.findElement(reviewOrderBtn).click();
	        TestBase.waitFor(6);
	        driver.findElement(placeOrderBtn).click();
	        TestBase.waitFor(10);
			
			
			
			
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   }
	}

