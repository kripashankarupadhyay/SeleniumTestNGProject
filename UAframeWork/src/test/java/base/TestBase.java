package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.Netapi32Util.User;

import common.ReadExcel; 


	public class TestBase 

	{
		static WebDriver driver = null;
		static WebDriverWait wait;
		static int i = 0;
		
		private static Connection connection;
		private static Statement statement;
		private static ResultSet rs;	
		private static String sTestCaseName = null;
			
		private static final Logger logger = Logger.getLogger(TestBase.class.getName());
		
		
		public static  void loadlog4J(){
			String log4jConfPath = System.getProperty("user.dir")+"\\log4j.xml";
			PropertyConfigurator.configure(log4jConfPath);
		}
		
		public static void setTestcaseName(String sTCName) {
			sTestCaseName = sTCName;
		}
		
		
		public static WebDriver OpenBrowser(String browser, String sheet){
			 
		String url=base.Constant.URLUA;
		String DBName = base.Constant.DataBaseName;
		
	 
			try{
				if(browser.equals("chrome"))
				{					
					TestBase.loadlog4J();
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.get(url);
					driver.manage().window().maximize();
					//BaseClass.implicitTime(15, driver);
					//wait=new WebDriverWait(msm, 20);
					System.out.println("open browser Successfully !");
					//use excel file
					ReadExcel.setExcelFile(base.Constant.Path_TestData + base.Constant.File_TestData,sheet);
					TestBase.setUp();
					
				}
				if(browser.equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.get(url);
					driver.manage().window().maximize();
					//BaseClass.implicitTime(15, driver);
					//wait=new WebDriverWait(msm, 20);
					System.out.println("open browser Successfully !");
					//use excel file
					ReadExcel.setExcelFile(base.Constant.Path_TestData + base.Constant.File_TestData,sheet);
					TestBase.setUp();
				}
			}
	 
			catch (Exception e)
			{
				System.out.println("Problem in open browser !");
				e.printStackTrace();	
			
			}
	 
			return driver;
	 
		}
		
		public static WebDriverWait WaitTime(WebDriver driver)
		{
			try 
			{
				wait=new WebDriverWait(driver, 20);
			}
			catch(Exception e)
			{
				System.out.println("Problem in WebDriverWait !");
				e.printStackTrace();
			}
			
			return wait;
		}
		
		public static void implicitTime(int t,WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
			
		}
		
		public static void ExtentReports(WebDriver driver)
		{
			
		}

		public WebDriver getDriver() {
			// TODO Auto-generated method stub
			return null;
		}
	 
		
		public static boolean waitFor(int iSeconds) {
            try 
            {
                  Thread.sleep(iSeconds * 1000);
            } catch (Exception e) 
            {
                  System.out.println("Not able to Wait --- " + e.getMessage());
                  return false;
            }
            return true;
     }
		
		/*
		 * Author -Kripa
		 * Method - Selecting Department and sub department
		 */
		public static void subdepartmentclick(WebDriver driver, String department, String Subdepartment) throws InterruptedException
		{
			waitFor(1);
			WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(),'" + department + "')]"));
			Actions action = new Actions(driver);
			action.moveToElement(ele1).build().perform();
			waitFor(2);
			driver.findElement(By.xpath("//a[contains(text(),'" + Subdepartment + "')]")).click();
		}
		
		/*
		 * Author - Kripa
		 * Method - Selecting the Size of product
		 */
		public static void selectSize(WebDriver driver )
		{
			List<WebElement> getlist=driver.findElements(By.xpath(".//*[@class='clearfix']//div"));
			
			for (WebElement webElement : getlist)
            {      
                   i = i+1;
                   String sizel = "//*[@class='clearfix']//div["+i+"]";
                         WebElement size =driver.findElement(By.xpath(sizel));
                         
                         Actions mo = new Actions(driver);
                         mo.moveToElement(size).build();
                         mo.perform();
                         TestBase.waitFor(1);
                         WebElement colorfont = driver.findElement(By.xpath(".//*[@data-dtm='sizeblock']["+i+"]"));
            
                         String getattribute = colorfont.getAttribute("class");
                        		 System.out.println(getattribute);
                         String Sizeblock = "sizeblock";
                         if(Sizeblock.equals(getattribute))
                         {
                        	 colorfont.click();
                        	 System.out.println("Click on-> "+i);
                        	 break;
                         }
                         else
                         {
                         System.out.println("out of stock"+i);
                         
                         }
             }		
		}
		
		public static void scrollDown(WebDriver driver )
		{
	     	 JavascriptExecutor jse = (JavascriptExecutor)driver;
		     jse.executeScript("window.scrollBy(0,250)", "");
	    } 
		
		public static void scrollUp(WebDriver driver )
		{
	     	 JavascriptExecutor jse = (JavascriptExecutor)driver;
	     	 jse.executeScript("window.scrollBy(0,-250)", "");
	    } 
		
		
		
		
		
		public static void setUp() throws InstantiationException, IllegalAccessException 
		{
	            String databaseURL = "jdbc:sqlserver://UAc-S-WB-app-3;DatabaseName=AXtoEcom;integratedSecurity=false";
	            String user = "websites";
	            String password = "uaweb()";
	            connection = null;
	            
	            try {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	                System.out.println("Connecting to Database...");

	                //connection = DriverManager.getConnection(databaseURL);
	                connection = DriverManager.getConnection(databaseURL, user, password);
	                if (connection != null) {
	                    System.out.println("Connected to the Database...");
	                }//
	            } 
	            catch (SQLException ex)
	            {
	               ex.printStackTrace();
	            }
	            catch (ClassNotFoundException ex)
	            {
	               ex.printStackTrace();
	            }
	   
		}
		 
		 public static void getorderID() 
		{
	        try {
	        	String query = "select top 1 OrderID from [uascrubs].[dbo].carts where email = '"+ReadExcel.getCellData(Constant.TestCase, Constant.UserName)+"' order by OrderId desc";
	        	
	        	statement = connection.createStatement();
	            ResultSet results = statement.executeQuery(query);
	            while(results.next()) {
	            System.out.println("Order Id: " + results.getNString("OrderID"));
	            	//System.out.println("Order Id: " + results.getInt("OrderID") + "  "+ "Catalog Order Key" + results.getLong("sr_catalog_order_key"));
	            }
	            System.out.println(query);
	               
	        }
	      catch(Exception e)
	        {
	    	  e.printStackTrace();
	        }
		}
	}