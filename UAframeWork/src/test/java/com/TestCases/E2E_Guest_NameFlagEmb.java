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

import base.TestBase;

public class E2E_Guest_NameFlagEmb {
	public static WebDriver driver = null;


	@BeforeClass
	public void beforeMethod()
	{
		driver=TestBase.OpenBrowser("chrome","Sheet6");


	}

	@Test
	public void login() throws InterruptedException
	{

		HomePage.PopUp_btn(driver);
		Home.departmentlisting(driver);
		ProductPage.selectProductEmbroidery(driver);
		EmbroideryPage.NameandFlagDesign(driver);
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
