package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageObjects.CheckoutPage;
import com.PageObjects.CreateAccount;
import com.PageObjects.EmbroideryPage;
import com.PageObjects.Home;
import com.PageObjects.HomePage;
import com.PageObjects.MyCartPage;
import com.PageObjects.PaymentPage;
import com.PageObjects.ProductPage;
import utility.*;

import base.TestBase;
/*
 * Author - Meenal 27Sep'18
 */
public class E2E_Guest_NameEmb {
	public static WebDriver driver = null;


	@BeforeClass
	public void beforeMethod()
	{
		driver=TestBase.OpenBrowser("chrome","Sheet5");
		Log.startTestCase("E2E Test Case");
		


	}

	@Test
	public void login() throws InterruptedException
	{

		HomePage.PopUp_btn(driver);
		Home.departmentlisting(driver);
		ProductPage.selectProductEmbroidery(driver);
		EmbroideryPage.NameEmbroidery(driver);
		MyCartPage.cartpageValidation(driver);
		CreateAccount.GuestUserLoginValidation(driver);
		CheckoutPage.checkoutValidation(driver);
		PaymentPage.paymentValidation(driver);
	}


	@AfterClass
	public void afterMethod()
	{
		driver.close();
	}
}
