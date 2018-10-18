package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.PageObjects.CreateAccount;


import base.TestBase;

public class LoginAccount {
	
	public static WebDriver driver = null;
	  
	  @BeforeClass
	  public void beforeMethod()
	  {
		 driver=TestBase.OpenBrowser("chrome","Sheet3");
		 
				 	  
	  }
	  
	  @Test
	  public void login()
	  {
		  CreateAccount.loginAccount(driver);
		  //CreateMethod.loginAccount(driver);
	  }
	  

	  @AfterClass
	  public void afterMethod()
	  {
		 driver.close();
	  }

}
