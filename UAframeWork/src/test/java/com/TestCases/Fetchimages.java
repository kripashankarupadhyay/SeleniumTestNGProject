package com.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fetchimages {
	
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		List<WebElement> list = driver.findElements(By.xpath("//img"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).hashCode());
		}
		System.out.println(list.size());
	}
}
