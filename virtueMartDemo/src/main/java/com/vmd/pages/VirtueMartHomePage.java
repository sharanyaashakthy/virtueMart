package com.vmd.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vmd.core.BasePage;

public class VirtueMartHomePage extends BasePage {
	
	private static WebDriver driver;
	 private static WebElement element = null;

	public VirtueMartHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[text()='Cowboy Hat']//parent::td//parent::tr//following-sibling::button[contains(@name,'delete')]")
	private WebElement Cowboyhat;
	@FindBy(xpath = "//a[text()='Zipper pullover']//parent::td//parent::tr//following-sibling::button[contains(@name,'delete')]")
	private WebElement ZipperPullOver;
	
	@FindBy(xpath = "//input[@id='modlgn-username']")
	private WebElement userName_textBox;
	
	@FindBy(xpath = "//input[@id='modlgn-passwd']")
	private WebElement password_textBox;
	
	
	@FindBy(xpath = "//input[@name='Submit']")
	private WebElement logInButton;
	
	@FindBy(xpath = "//div[@class='accept']")
	private WebElement IUnderstandButton;
	
	
	public  WebElement enterUserName(WebDriver driver) throws Exception {
		element = driver.findElement(By.xpath("//input[@id='modlgn-username']"));
		return element;
	}
	
	public WebElement enterPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='modlgn-passwd']"));
		return element;
	}
	
	public WebElement clickOnLoginButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='Submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
	//	Assert.assertTrue(ExpectedConditions.titleContains("facebook").apply(driver).booleanValue());
		System.out.println("Successfully logged into the account");
		return element;
	}
	
	public void clickOnIUnderstand() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert cookieAlert = driver.switchTo().alert();
			cookieAlert.accept();
			driver.findElement(By.xpath("//div[@class='accept']")).click();
			System.out.println("Unexpected alert accepted");
		}catch (Exception e) {
            //System.out.println("unexpected alert not present");
        }
	}
	
	public void verifyLogin(WebDriver driver) {
		String greeting = "Hi Demo";
		 element = driver.findElement(By.xpath("//*[contains(text(),'Hi')]"));
		 if(element.isDisplayed()) {
			 System.out.println("Authentication successful");
			 System.out.println("Text: " + greeting + " is present");
		 }else {
	         System.out.println("Text: " + greeting + " is not present");
	     }
	}
	
	
	public WebElement enterCowBoyHatInSearchbar(WebDriver driver) {
		 element = driver.findElement(By.xpath("//div[@class='vm-search-custom-search-input']//input[@class='inputbox']"));
		 return element;
	}

	public WebElement clickOnSearchInShop(WebDriver driver) {
		  element = driver.findElement(By.xpath("//div[@class='vm-search-custom-search-input']//input[@class='button']"));
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("arguments[0].click()", element);
		  return element;
		
	}
	
	public WebElement clickOnAddToCart(WebDriver driver) {
		element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[5]/div[1]/form[1]/div[2]/span[3]/input[1]"));
		//element = driver.findElement(By.xpath("//input[@type='submit' and @value='Add to Cart']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;	
	}
	
	public WebElement clickOnShowCart(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'showcart') and @href='/cart']")));
		//element = driver.findElement(By.xpath("//body/div[@id='fancybox-wrap']/div[@id='fancybox-outer']/div[@id='fancybox-content']/div[1]/a[2]"));
		element = driver.findElement(By.xpath("//a[contains(@class,'showcart') and @href='/cart']"));
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click()", element);
		return element;
	}

	public void verifyShoppingCartPageisDisplayed(String shoppingcartpagetitle) {
		assertTrue(driver.getTitle().contains(shoppingcartpagetitle));
		
	}

	public WebElement checkProductList(WebDriver driver) {
	
		
	   List<WebElement> productList = driver.findElements(By.className("vm-cart-item-name"));
		for(int i = 1; i< productList.size(); i++) {
			//System.out.println(productList.get(i).getText());
			if(productList.size() > 2 ) {
				WebDriverWait wait = new WebDriverWait(driver, 100);
				element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Zipper pullover']//parent::td//parent::tr//following-sibling::button[contains(@name,'delete')]")));
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("arguments[0].click()", element);
					
			}
			
		}
		return element;	
	
		
			/*element = driver.findElement(By.xpath("//*[contains(text(),'Cowboy Hat')]"));
			if(element.isDisplayed()) {
				System.out.println("Cowboy Hat product is retained");
			}
			else {
				//productList.remove(i);
				element = driver.findElement(By.xpath("//button[@title='Delete Product From Cart']"));
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("arguments[0].click()", element);
				//System.out.println("other product is removed");
			}
		}*/
		
		// //a[text()="Zipper pullover"]//parent::td//parent::tr//following-sibling::button[contains(@name,'delete')]
		// //a[text()="Cowboy Hat"]//parent::td//parent::tr//following-sibling::button[contains(@name,'delete')]
		/*element = driver.findElement(By.xpath("//a[text()='Zipper pullover']//preceding::tr[@class='sectiontableentry1']//following::button[@name='delete.0']"));
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].click()", element);
		return element;*/
		
		//WebElement CowboyHat = driver.findElement(By.xpath("//a[text()='Cowboy Hat']//parent::td//parent::tr//following-sibling::button[contains(@name,'delete')]"));
		/*WebElement ZipperPullOver = driver.findElement(By.xpath("//a[text()='Zipper pullover']//parent::td//parent::tr//following-sibling::button[contains(@name,'delete.0')]"));
		if(ZipperPullOver.isDisplayed()) {
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("arguments[0].click()", ZipperPullOver);
			//ZipperPullOver.click();
		}*/
		
}	
		
		
	

	public WebElement checkTermsAndConditionBox(WebDriver driver) {
		
	//	jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='terms-of-service required' and @value='1']")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
		
	}

	public WebElement clickOnCheckOutNowButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='checkoutFormSubmit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
	}

	public WebElement enterEmailAddress(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='email_field']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
	}

	public WebElement enterFirstName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='first_name_field']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
		
	}

	public WebElement enterLastName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='last_name_field']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
	}

	public WebElement enterAddress1(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='address_1_field']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
		
	}

	public WebElement enterZipCode(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='zip_field']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
	}

	public WebElement enterCity(WebDriver driver) {
		element =  driver.findElement(By.xpath("//input[@id='city_field']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
		
	}

	public WebElement clickonConfirmPurchase(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='confirm']//span[text()='Confirm Purchase']")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
		
	}

	public void verifyPurchase(WebDriver driver) {
		String thankyou = "Thank you for your order!";
		 element = driver.findElement(By.xpath("//*[contains(text(),'Thank you for your order!')]"));
		 if(element.isDisplayed()) {
			 System.out.println("Text: " + thankyou + " is present");
		 }else {
	         System.out.println("Text: " + thankyou + " is not present");
	     }
		
	}

	public WebElement clickOnLogoutButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@value='Logout']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		return element;
		
	}


	@FindBy(xpath = "//input[@class='quantity-input js-recalculate' and @name='quantity[1]']")
	private WebElement quantityBox;
	
	public WebElement verifyPrice(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		//  //input[@class='quantity-input js-recalculate' and contains(@name,'quantity')]
		//String quantity = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/input[1]")).getText();
	//	System.out.println("product quantity is "+quantity);
		//String price = driver.findElement(By.xpath("//span[@class='PricediscountedPriceWithoutTax']")).getText();
		int quantityval = 1;
				//Integer.parseInt(quantity);
		//double priceVal = Double.parseDouble(price);
		double priceVal = 12.00;
		double totalVal = quantityval * priceVal;
		
		String calculatedPrice = Double.toString(totalVal);
		System.out.println("Calculated price is "+calculatedPrice);
		
		
		
		/*String displayedPrice = driver.findElement(By.xpath("//span[@class='PricesalesPrice']")).getText();
		System.out.println("Displayed price is "+displayedPrice);
		if(calculatedPrice.equals(displayedPrice)) {
			System.out.println("The price for"+quantity+" number of the product is "+calculatedPrice);
		}*/
		
		
		
		
		return null;
	}

		
	}

	
	
	

		
	
	


