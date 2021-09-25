package com.automationtestV1.pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ShopPage {
	ChromeDriver localdriver;
	
	
	
	
	public ShopPage (ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	/*
	
	
	@FindBy(className = "sf-with-ul")
	@CacheLookup
	WebElement womanTab;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
	@CacheLookup
	WebElement sumDress;
	
	
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
	@CacheLookup
	WebElement confirm;
	String confirmMsg = "Your order on My Store is complete.";
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
	@CacheLookup
	WebElement quickView;
	
	@FindBy (xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[2]/span")
	@CacheLookup
	WebElement quickViewBut;
	
	
	///
	@FindBy (xpath = "//*[@id=\"add_to_cart\"]")
	@CacheLookup
	WebElement elementButton;
	
	*/
	

	public void cartOrder (ChromeDriver driver, Actions actions) throws InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// Open the web page
			driver.navigate().to("http://automationpractice.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// Select the women tab
			
			
			WebElement womanTab = driver.findElement(By.className("sf-with-ul"));
			actions.moveToElement(womanTab).perform();
			System.out.println("Done");
			
			WebElement sumDress = driver.findElementByXPath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a");
			sumDress.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebElement quickView = driver.findElementByXPath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
			actions.moveToElement(quickView).perform();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			actions.moveToElement(quickView);
			WebElement quickViewBut = driver.findElementByXPath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[2]/span");
			quickViewBut.click();
			
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebElement elementButton = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add_to_cart\"]")));
			elementButton.click();
	}
	
	public void dropDownNav (ChromeDriver driver, Actions actions) throws InterruptedException {
				
				
			try {
				// Continue Shopping Button
				WebElement contShop = driver.findElementByXPath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span");
				contShop.click();
			
			
				WebElement cartDrop = driver.findElementByXPath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
				actions.moveToElement(cartDrop);
			
				WebElement checkOut = driver.findElementByXPath("//*[@id=\"button_order_cart\"]");
				checkOut.click();
				
	
			// Summary Checkout
			
			} catch (NoSuchWindowException e) {
				System.out.println("No Window");
			}
	}
	
	public void SummaryCheckout (ChromeDriver driver, Actions actions) throws InterruptedException {
			
			WebElement pCheckOut = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
			pCheckOut.click();
			
			WebElement pCheckOutBot = driver.findElementByXPath("//*[@id=\"center_column\"]/p[2]/a[1]");
			pCheckOutBot.click();
			
			// Random Integer
			
			Random randemail = new Random();
			System.out.println(randemail.nextInt());
			
			StringBuilder emailstr = new StringBuilder();
			emailstr.append("mayooran");
			emailstr.append(randemail.nextInt(100));
			emailstr.append("@gmail.com");

			
			WebElement createAccount = driver.findElementByXPath("//*[@id=\"email_create\"]");
			createAccount.sendKeys(emailstr);
			
			WebElement createAccBut = driver.findElementByXPath("//*[@id=\"SubmitCreate\"]/span");
			createAccBut.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
	}
			
	public void addressInformation (ChromeDriver driver, Actions actions) throws InterruptedException {	
			
			//Create Account
			
			WebElement title = driver.findElement(By.id("id_gender1"));
			title.click();
			
			WebElement firstName = driver.findElementByXPath("//*[@id=\"customer_firstname\"]");
			firstName.sendKeys("Mayooran");
			
			WebElement zip = driver.findElementByXPath("//*[@id=\"postcode\"]");
			actions.moveToElement(zip);
			
			
			WebElement lastName = driver.findElementByXPath("//*[@id=\"customer_lastname\"]");
			lastName.sendKeys("Thavajogarasa");
			
			
		
			
			
			WebElement password = driver.findElement(By.id("passwd"));
			password.click();
			password.sendKeys("password");
			
			WebElement address = driver.findElementByXPath("//*[@id=\"address1\"]");
			address.sendKeys("11 Castle Rd");
			
			WebElement city = driver.findElementByXPath("//*[@id=\"city\"]");
			city.sendKeys("Mississauga");
			
			
			WebElement state = driver.findElement(By.id("id_state"));
			Select objSelect = new Select(state);
			objSelect.selectByVisibleText("Arizona");
			

			state.click();
			zip.sendKeys("33333");
			
			WebElement mobilePhone = driver.findElementByXPath("//*[@id=\"phone_mobile\"]");
			mobilePhone.sendKeys("6473310099");
			
			WebElement alias = driver.findElementByXPath("//*[@id=\"alias\"]");
			alias.clear();
			alias.sendKeys("thava@live.ca");
			
			WebElement register = driver.findElementByXPath("//*[@id=\"submitAccount\"]");
			register.click();
	
			// Address
			WebElement proceedCheckoutAdd = driver.findElementByXPath("//*[@id=\"center_column\"]/form/p/button");
			proceedCheckoutAdd.click();
	}
	
	public void shipInformation (ChromeDriver driver, Actions actions) throws InterruptedException {
			
			WebElement termsOfService = driver.findElementByXPath("//*[@id=\"cgv\"]");
			termsOfService.click();
			
			WebElement proceedCheckoutShip = driver.findElementByXPath("//*[@id=\"form\"]/p/button");
			proceedCheckoutShip.click();
	}
	
	public void paymentMethod (ChromeDriver driver, Actions actions) throws InterruptedException {
			
			WebElement payWire = driver.findElementByXPath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
			payWire.click();
			WebElement confirmOrder = driver.findElementByXPath("//*[@id=\"cart_navigation\"]/button");
			confirmOrder.click();
	}
	
	public void orderConfirm (ChromeDriver driver, Actions actions) throws InterruptedException {
			
			String confirm = driver.findElementByXPath("//*[@id=\"center_column\"]/div/p/strong").getText();
			String confirmMsg = "Your order on My Store is complete.";
			assertEquals(confirm,confirmMsg);
				
	}

	/*
	public void selectTab() {
		Actions actions = new Actions(localdriver);
		actions.moveToElement(womanTab).perform();
		localdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sumDress.click();
		localdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(quickView).perform();
		localdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		quickViewBut.click();

	}
	*/

}
