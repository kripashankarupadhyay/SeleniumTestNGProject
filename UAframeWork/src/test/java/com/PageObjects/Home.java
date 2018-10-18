package com.PageObjects;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.Constant;
import base.TestBase;
import common.ReadExcel;

public class Home {

	static By catagorypageProduct = By.xpath("(.//*[@class='productList']//following-sibling::img)[1]");
	static By enterUsername = By.xpath("//input[@id='emailfield']");
	static By enterPassword = By.xpath("//input[@id='passwordfield']");
	static By loginButton = By.xpath("//input[@name='loginbutton']");
	
	static By sitemapLink = By.xpath("//a[contains(text(),'site map')]");

	 
	 public static void departmentlisting(WebDriver driver) 
	   {
		 try {
			 TestBase.subdepartmentclick(driver, ReadExcel.getCellData(Constant.TestCase, Constant.Department), ReadExcel.getCellData(Constant.TestCase, Constant.Subdeparment));
			 TestBase.waitFor(1);
			 driver.findElement(catagorypageProduct).click();
			 //TestBase.selectSize(driver);		   
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   }
		 
	 public static void siteMapValidation(WebDriver driver) 
	 	{
			
		  int linksCount = 0;
		  String[] links2 = null;
		  String[] links = null;
		  int Bulletno=1;
		  int countoflinks=1;
			//	private static String[] links = null;
			//	private static int linksCount = 0;
		  try {
				TestBase.waitFor(5);
		        TestBase.scrollDown(driver);
	            driver.findElement(sitemapLink).click();
	            TestBase.waitFor(5);
				List<WebElement>  allText=	driver.findElements(By.xpath("//li[@class='header5']//child::li/a"));
				   linksCount=allText.size();
				   links2=new String[linksCount];
				
				//ul[@class="couponsLink"]/li/a
				List<WebElement>  linksize=	driver.findElements(By.xpath("//li[@class='header5']//child::li/a"));
				linksCount = linksize.size();
				
				System.out.println("Total no of links Available: "+linksCount);
				//Reporter.log("Total no of links Available: "+linksCount);
				
				links= new String[linksCount];
				System.out.println("this is the string array"+links);
				
				System.out.println("List of links Available: ");  
				//Reporter.log("List of links Available: ");
				// print all the links from webpage 
				
				for(int i=0;i<linksCount;i++)
				{
			    
				links2[i]  = allText.get(i).getText();
				links[i] = linksize.get(i).getAttribute("href");
				
				System.out.println(Bulletno+": "+links2[i]+" "+ links[i]);
				//Reporter.log(Bulletno+": "+links2[i]+" "+ links[i]);
				//System.out.println("\n");
				//Reporter.log("\n");
				
				Bulletno++;
				} 
				TestBase.waitFor(3);
				// navigate to each Link on the webpage
				for(int i=0;i<linksCount;i++)
				{
				driver.navigate().to(links[i]);
				
				System.out.println("Now clicking on each link: "+"No: "+countoflinks);
			    //Reporter.log("Now clicking on each link: "+"No: "+countoflinks);
				
				String url=driver.getCurrentUrl();
				String pagetittle=driver.getTitle();
				//System.out.println(url);
				//Reporter.log(url);
				TestBase.waitFor(3);
				
				if(url.contains("404")|| pagetittle.contains("Page Not Found"))
				{
					System.err.println("URl is not looking good"+":  "+ pagetittle +" : "+url);
					//Reporter.log("URl is not looking good"+pagetittle+" "+url);
				
					
				}
				else {
					
					    System.out.println("URl is looking good"+ ":   "+pagetittle +" : "+url);
					    //Reporter.log("URl is looking good"+ ":   "+pagetittle+" "+url);
				}
				
				countoflinks++;
				}  
		  }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   }
	 
	 public static void siteMapResponse(WebDriver driver) 
	 	{
			
		  int linksCount = 0;
		  String[] links2 = null;
		  String[] links = null;
		  int Bulletno=1;
		  int countoflinks=1;
		  int count = 1;
			//	private static String[] links = null;
			//	private static int linksCount = 0;
		  try {
				TestBase.waitFor(5);
		        TestBase.scrollDown(driver);
	            driver.findElement(sitemapLink).click();
	            TestBase.waitFor(5);
				List<WebElement>  allText=	driver.findElements(By.xpath("//li[@class='header5']//child::li/a"));
				   linksCount=allText.size();
				   links2=new String[linksCount];
				
				//ul[@class="couponsLink"]/li/a
				List<WebElement>  linksize=	driver.findElements(By.xpath("//li[@class='header5']//child::li/a"));
				linksCount = linksize.size();
				
				System.out.println("Total no of links Available: "+linksCount);
				//Reporter.log("Total no of links Available: "+linksCount);
				
				links= new String[linksCount];
				System.out.println("this is the string array"+links);
				
				System.out.println("List of links Available: ");  
				//Reporter.log("List of links Available: ");
				// print all the links from webpage 
				
				for(int i=0;i<linksCount;i++)
				{
			    
				links2[i]  = allText.get(i).getText();
				links[i] = linksize.get(i).getAttribute("href");
				
				System.out.println(Bulletno+": "+links2[i]+" "+ links[i]);
				//Reporter.log(Bulletno+": "+links2[i]+" "+ links[i]);
				//System.out.println("\n");
				//Reporter.log("\n");
				
				Bulletno++;
				} 
				TestBase.waitFor(3);
				// navigate to each Link on the webpage
				for(int i=0;i<linksCount;i++)
				{
				//driver.navigate().to(links[i]);
				 
				HttpClient client = HttpClientBuilder.create().build();
			    HttpGet request = new HttpGet(links[i]);
			    HttpResponse response = client.execute(request);
			    System.out.println(+ count++ +"*URL is - "+links[i] +",*Reponse code - "+response.getStatusLine().getStatusCode());
				
				//System.out.println("Now clicking on each link: "+"No: "+countoflinks);
			    //Reporter.log("Now clicking on each link: "+"No: "+countoflinks);
				
				//String url=driver.getCurrentUrl();
				//String pagetittle=driver.getTitle();
				//System.out.println(url);
				//Reporter.log(url);
				if( response.getStatusLine().getStatusCode() == 404)
				{
					System.err.println("URl is not looking good"+ links[i]);
					//Reporter.log("URl is not looking good"+pagetittle+" "+url);
				
					
				}
				else if (response.getStatusLine().getStatusCode() == 500) {
					
					    System.err.println("URl is not looking good"+ links[i]);
					    //Reporter.log("URl is looking good"+ ":   "+pagetittle+" "+url);
				}
				else {
						System.out.println("URl is looking good"+ links[i]);
				}
				
				countoflinks++;
				}  
		  }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   }
				

}

	   


	


