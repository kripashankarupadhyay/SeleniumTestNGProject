package com.TestCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.PageObjects.*;
import base.TestBase;
import utility.Log;


public class E2E_RegisterdUser {

	public static WebDriver driver = null;

	  
	  @BeforeClass
	  public void beforeMethod()
	  {
		 driver=TestBase.OpenBrowser("chrome","Sheet4");
		 DOMConfigurator.configure("log4j.xml");
		 Log.startTestCase("E2E Test Case");
		 Log.info(" Excel sheet opened");
				 	  
	  }
	  
	  @Test
	  public void login()
	  {
		  TestBase.setTestcaseName("E2E Test case");
		  CreateAccount.loginAccount(driver);
		  Home.departmentlisting(driver);
		  ProductPage.selectProduct(driver);
		  MyCartPage.cartpageValidation(driver);
		  CheckoutPage.checkoutValidation(driver);
		  PaymentPage.paymentValidation(driver);
		  ConfirmationPage.confirmationvalidation(driver); 
		  TestBase.getorderID();
		  
		 
	  }
	  

	  @AfterClass
	  public void afterMethod()
	  {
		 driver.close();
	  }





}
