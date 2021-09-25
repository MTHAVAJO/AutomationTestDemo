package com.automationtestV1.testCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationtestV1.pageObjects.ShopPage;



public class TC_CheckOut extends BaseClass {
	
	@Test
	public void checkOut() throws InterruptedException {
		Actions localactions = new Actions(driver);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		ShopPage sp = new ShopPage(driver);
		
		
		sp.cartOrder(driver, localactions);
		sp.dropDownNav(driver, localactions);
		sp.SummaryCheckout(driver, localactions);
		sp.addressInformation(driver, localactions);
		sp.shipInformation(driver, localactions);
		sp.paymentMethod(driver, localactions);
		sp.orderConfirm(driver, localactions);
		
		
		
		
		
		
	}

}
