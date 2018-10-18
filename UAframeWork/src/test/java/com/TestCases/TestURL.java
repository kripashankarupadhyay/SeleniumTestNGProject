package com.TestCases;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageObjects.Home;
import com.PageObjects.HomePage;

import base.TestBase;

public class TestURL {
	
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
		ArrayList<String> text=new ArrayList<String>();
		ArrayList<String> link=new ArrayList<String>();
		String url,htext;
		 HttpURLConnection huc = null;
		 int respCode = 0,pass=0,fail=0,j=0;
		 
		 
		 TestBase.waitFor(5);
		 List<WebElement> getlist=driver.findElements(By.xpath("//div[@class='static-generalPage sitemapPage']//child::a"));
		 for (WebElement webElement : getlist)
			{
	            String txt=webElement.getText();
	            String str=webElement.getAttribute("href");
	       
	            text.add(txt);
	            link.add(str);            
	        }
		 Reporter.log("<table style=\"width:100%\">");
		  
		  Reporter.log("<tr>" + 
		  		"    <th>Sr.No.</th>" + 
		  		"    <th>Resp. Code</th> " + 
		  		"    <th>UI Text</th>" + 
		  		"    <th>Link</th>" + 
		  		"    <th>Result</th>" +
		  		"  </tr>");
		  
		  
		  //Verify all links
		  
		  for(int i=0;i<link.size();i++)
			 // for(int i=0;i<15;i++)
			{
				url=link.get(i);
				htext=text.get(i);
				j=i+1;
				System.out.println(i);
				//verify the empty url
				if(url == null || url.isEmpty())
				{
					//System.out.println(i+"----For"+htext+" url is empty");
				//	Reporter.log("<h4>"+i+"----For"+htext+" URL IS EMPTY</h4>");
					
					Reporter.log("<tr>" + 
							"    <td>"+j+"</td>" + 
							"    <td>NA</td> " + 
							"    <td>"+htext+"</td>" + 
							"    <td>NULL</td>" + 
							"    <td><font color=\"blue\">URL Blank</font></td>" + 
							"  </tr>");
					fail=fail+1;
					
					continue;
				}
				
				
				//Verify the response code
				try 
				{		
					
					HttpClient client = HttpClientBuilder.create().build();
	                HttpGet request = new HttpGet(url);
	                HttpResponse response = client.execute(request);
	                //System.out.println(+ count++ +"*URL is - "+URL +",*Reponse code - "+response.getStatusLine().getStatusCode());
	                respCode = response.getStatusLine().getStatusCode();

		                
		                if(respCode >= 400){
		                 //   System.out.println(i+"---"+respCode+"--"+htext+"----"+url+" is a broken link");
		                   // Reporter.log(i+"---"+respCode+"--"+htext+"----"+url+" is a broken link");
		                  //  j=i+1;
		                    Reporter.log("<tr>" + 
		    						"    <td>"+j+"</td>" + 
		    						"    <td>"+respCode+"</td> " + 
		    						"    <td>"+htext+"</td> " + 
		    						"    <td>"+url+"</td>" + 
		    						"    <td><font color=\"red\">InValid link</font></td> </tr>");
		                    
		                    fail=fail+1;
		                    
		                }
		                else{
		                   // System.out.println(i+"---"+respCode+"--"+htext+"----"+url+" is a valid link");
		                   // Reporter.log(i+"---"+respCode+"--"+htext+"----"+url+" is a valid link");
		                	// j=i+1;
		                    Reporter.log("<tr>\n" + 
		    						"    <td>"+j+"</td>" + 
		    						"    <td>"+respCode+"</td>" + 
		    						"    <td>"+htext+"</td>" + 
		    						"    <td>"+url+"</td>" + 
		    						"    <td><font color=\"green\">Valid link</font></td> </tr>");
		                    
		                    pass=pass+1;
		                }
		                    
		            } 
				 	catch (Exception e)
		            {
				 		Reporter.log("<tr>" + 
	    						"    <td>"+j+"</td>" + 
	    						"    <td>"+respCode+"</td> " + 
	    						"    <td>"+htext+"</td> " + 
	    						"    <td>"+url+"</td>" + 
	    						"    <td><font color=\"red\">InValid link</font></td> </tr>");
				 		fail=fail+1;
		            } 
				
				
				
				
			}
			  Reporter.log("</table>");
		  
			  Reporter.log("Valid Links=>"+pass);
			  Reporter.log("InValid Links=>"+fail);
		 
		 
	  }
	  
	  
	  @AfterClass
	  public void afterMethod()
	  {
		 driver.close();
	  }

}
