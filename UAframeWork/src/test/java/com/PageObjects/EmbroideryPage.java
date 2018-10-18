package com.PageObjects;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import base.Constant;
import base.TestBase;
import common.ReadExcel;
/*
 * Author - Meenal 27 Sep'18
 */
public class EmbroideryPage {

	static By NameEmbroideryOpt = By.xpath("//input[@type='checkbox']");
	static By FlagDesignOpt= By.xpath("//input[@id='opt8']");
	static By LineFontSyle = By.xpath("//div[@id=\"name_section_1\"]//div[@class=\"inline_container radio_list_container\"]/div/input");
	static By LineFontColor = By.xpath("//select[@id='Name_Line1_Color']");
	static By Placement1 = By.xpath("//div[@class='placement_radio_btn_container left_img_background'][1]");
	static By Placement2 = By.xpath(".//*[@id='Flag_Line1_Position_P1R']");
	static By Text = By.xpath("//input[@id='Name_Line1_Text']");
	static By TextCase1 = By.xpath("//select[@id='Name_Line1_Case']");
	static By EmbroideryPreview =By.xpath(".//*[@id='expcol']");
	static By PreviewImage= By.xpath(".//*[@id='img_Name_Line1_Text']");
	static By Embroiderycheckbox= By.xpath(".//*[@id='embroidery_acknowledgment']");
	static By AddEmbrToCartBtn= By.xpath("//a[contains(text(),'ADD EMBROIDERY ITEM TO CART')]");
	static By Thankyoupopup = By.xpath("//img[@src='/img/continue_shopping_btn_navy.gif']");
	static By minicart = By.xpath("//i[@class='fa fa-shopping-cart']");	
	static By Flagsize = By.xpath("//input[@id='Flag_Line1_Size_S']");
	static By CountryFlag = By.xpath(".//*[@id='Flag_Line1_Style']");
	static By positioning = By.xpath(".//*[@id='Flag_Line1_RelativePosition']");

	public static void NameEmbroidery(WebDriver driver) 
	{
		try {

			TestBase.waitFor(4);
			WebElement FontStyle= driver.findElement(LineFontSyle);
			FontStyle.click();
			TestBase.waitFor(3);
			WebElement Color =driver.findElement(LineFontColor);
			Color.click();
			TestBase.waitFor(2);
			Select se=new Select(Color);
			se.selectByVisibleText("C03. Peach");
			driver.findElement(Placement1).click();
			driver.findElement(Text).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.text1));
			TestBase.waitFor(2);
			driver.findElement(TextCase1).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.TextCase));
			TestBase.waitFor(2);
			driver.findElement(Embroiderycheckbox).click();
			TestBase.waitFor(4);
			driver.findElement(AddEmbrToCartBtn).click();
			TestBase.waitFor(4);
			driver.findElement(Thankyoupopup).click();
			TestBase.waitFor(5);
			driver.findElement(minicart).click();
			TestBase.waitFor(2);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		
	}
}

	 public static void NameandFlagDesign(WebDriver driver) 
	   {
		 try {
			 TestBase.waitFor(4);
			driver.findElement(FlagDesignOpt).click();
			WebElement FontStyle= driver.findElement(LineFontSyle);
			FontStyle.click();
			WebElement Color =driver.findElement(LineFontColor);
			Color.click();
			TestBase.waitFor(4);
			Select se=new Select(Color);
			se.selectByVisibleText("C12. Navy");
			driver.findElement(Placement1).click();
			driver.findElement(Text).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.text1));
			TestBase.waitFor(2);
			driver.findElement(TextCase1).sendKeys(ReadExcel.getCellData(Constant.TestCase, Constant.TextCase));
			TestBase.waitFor(2);
			driver.findElement(Flagsize).click();
			WebElement selectCountry =driver.findElement(CountryFlag);
			selectCountry.click();
			TestBase.waitFor(2);
			Select select=new Select(selectCountry);
		//	select.selectByValue("4");
			select.selectByVisibleText("United Kingdom");
			TestBase.waitFor(4);
			TestBase.scrollDown(driver);
			driver.findElement(Placement2).click();
	
			//WebElement position = driver.findElement(positioning);
			//Select select1 = new Select(position);
			//select1.selectByVisibleText("Below Text");
			TestBase.waitFor(4);
			driver.findElement(Embroiderycheckbox).click();
			TestBase.waitFor(4);
			driver.findElement(AddEmbrToCartBtn).click();
			TestBase.waitFor(4);
			driver.findElement(Thankyoupopup).click();
			TestBase.waitFor(5);
			driver.findElement(minicart).click();
			TestBase.waitFor(2);
		 
		 
		 }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
	 
	 

}


