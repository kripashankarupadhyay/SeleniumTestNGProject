package com.TestCases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageObjects.Home;
import com.PageObjects.HomePage;

import base.TestBase;

public class SiteMapValidation {
	
	public static WebDriver driver = null;
	  
	  @BeforeClass
	  public void beforeMethod()
	  {
		 driver=TestBase.OpenBrowser("chrome","Sheet4"); 
		 try {
			HomePage.PopUp_btn(driver);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
				 	  
	  }
	  
	  @Test
	  public void linkRedirection() 
	  {
		Home.siteMapValidation(driver);  
	  }
	  
	  @AfterClass
	  public void afterMethod()
	  {
		 driver.close();
	  }

}
