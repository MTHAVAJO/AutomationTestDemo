package com.automationtestV1.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseURL = "http://automationpractice.com";
	public static ChromeDriver driver;
	public static Actions actions;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
