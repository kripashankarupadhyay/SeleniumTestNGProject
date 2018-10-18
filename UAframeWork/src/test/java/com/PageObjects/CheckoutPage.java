package com.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class CheckoutPage {
	static By RecipientFirstName  = By.xpath(".//*[@id='RecipientFName']");
	static By  RecipientLastName = By.xpath(".//*[@id='RecipientLName']");
	static By Address  = By.xpath(".//*[@id='Address1']");
	static By City  = By.xpath(".//*[@id='City']");
	static By State = By.xpath(".//*[@id='State']");
	static By ZipCode  = By.xpath(".//*[@id='ZipCode']");
	static By PhoneNumber  = By.xpath(".//*[@id='DayPhone']");
	static By proceedtopaymentBtn = By.xpath(".//*[@value='Proceed to Payment']");	
	
	
	/*
	 * Author - Kripa -27/09/2018
	 */
	public static void checkoutValidation(WebDriver driver) 
	   {
		 try {
		TestBase.waitFor(5);
		driver.findElement(proceedtopaymentBtn).click();
		TestBase.waitFor(5);
		
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	
	public static void checkoutValidationGuestUser(WebDriver driver) 

	{
		try {
			TestBase.waitFor(5);
			driver.findElement(RecipientFirstName).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.FirstName));
			TestBase.waitFor(2);
			driver.findElement(RecipientLastName).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.LastName));
			TestBase.waitFor(2);
			driver.findElement(Address).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.StreetAddress));
			TestBase.waitFor(2);
			driver.findElement(City).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.City));
			WebElement state =driver.findElement(State);
			state.click();
			TestBase.waitFor(2);
			Select se=new Select(state);
			se.selectByVisibleText("Texas");
			driver.findElement(ZipCode).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.Zipcode));
			TestBase.waitFor(6);
			driver.findElement(PhoneNumber).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.Phone));
			TestBase.waitFor(6);
			driver.findElement(proceedtopaymentBtn).click();
			TestBase.waitFor(6);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
