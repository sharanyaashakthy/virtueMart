package com.vmd.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vmd.pages.VirtueMartHomePage;
import com.vmd.utilities.Constants;

public class VirtueMartHomePageTest {
	  WebDriver driver = null;
	  VirtueMartHomePage virtuehomepage = new VirtueMartHomePage(driver);
		
		@BeforeTest
		public void setUpTest() {
			String projectlocation = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",
					projectlocation+"\\lib\\chromedriver\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		@Test
		public  void goToVirtueMart() throws Exception{
			
			//Go to virtueMart.com
			System.out.println("Step 1: Navigating to the URL");
			driver.get("http://demo.virtuemart.net/");
			driver.manage().window().maximize();
			System.out.println("---------------------------------------------------------");
			
			//virtuehomepage.clickOnIUnderstand();
			
			
			//Login to the website using username and password as demo
			System.out.println("Step 2: Entering the credentials for login");
			virtuehomepage.enterUserName(driver).sendKeys(Constants.userName);
			virtuehomepage.enterPassword(driver).sendKeys(Constants.password);
			System.out.println("---------------------------------------------------------");
			virtuehomepage.clickOnIUnderstand();
			
			//Click on the login button
			System.out.println("Step 3: Clicking on the login button");
			virtuehomepage.clickOnLoginButton(driver);
			System.out.println("---------------------------------------------------------");
			
			//Verify the successful login by the text message "Hi demo"
			System.out.println("Step 4: Verifying the login");
			virtuehomepage.verifyLogin(driver);
			System.out.println("---------------------------------------------------------");
			
			virtuehomepage.clickOnIUnderstand();
			
			//Choose cowboy hat from the products
			System.out.println("Step 5: Searching for cowboy Hat");
			virtuehomepage.enterCowBoyHatInSearchbar(driver).sendKeys(Constants.productName);
			//System.out.println("---------------------------------------------------------");
			
		    //click on search in shop button
			virtuehomepage.clickOnSearchInShop(driver);
			virtuehomepage.clickOnIUnderstand();
			System.out.println("---------------------------------------------------------");
			
			//click on add to cart
			System.out.println("Step 6: Adding the product to cart");
			virtuehomepage.clickOnAddToCart(driver);
			//virtuehomepage.clickOnIUnderstand();
			//System.out.println("---------------------------------------------------------");
			
			//click on show cart
			virtuehomepage.clickOnIUnderstand();
			virtuehomepage.clickOnShowCart(driver);		
			System.out.println("---------------------------------------------------------");
			
			//if any other item other than cowboy hat is present remove that item
			System.out.println("Step 7: Checking the product list");
			virtuehomepage.checkProductList(driver);
			System.out.println("---------------------------------------------------------");
			
			//verify the total amount
			System.out.println("Step 8: Verifying the product price");
			virtuehomepage.verifyPrice(driver);
			System.out.println("---------------------------------------------------------");
			
			//check the terms and condition box at the end of the page
			System.out.println("Step 9: Clicking on the Terms and Conditions checkBox");
			virtuehomepage.checkTermsAndConditionBox(driver);
			System.out.println("---------------------------------------------------------");
			
		//clickOnCheckOutNow
		//	virtuehomepage.clickOnCheckOutNowButton(driver);
			
			//enter billing details
			/*virtuehomepage.enterEmailAddress(driver).sendKeys(Constants.emailAddress);
			virtuehomepage.enterFirstName(driver).sendKeys(Constants.firstName);
			virtuehomepage.enterLastName(driver).sendKeys(Constants.lastName);
			virtuehomepage.enterAddress1(driver).sendKeys(Constants.address1);
			virtuehomepage.enterZipCode(driver).sendKeys(Constants.zipCode);
			virtuehomepage.enterCity(driver).sendKeys(Constants.city);*/
			
			
			//confirm the purchase
			System.out.println("Step 10: clicking on confirm purchase button");
			virtuehomepage.clickonConfirmPurchase(driver);
			System.out.println("---------------------------------------------------------");
			
			//verify the purchase
			System.out.println("Step 11: Verifying the purchase");
			virtuehomepage.verifyPurchase(driver);
			System.out.println("---------------------------------------------------------");
			
			//Logout from the application
			System.out.println("Step 12: Logging out from the account");
		    virtuehomepage.clickOnLogoutButton(driver);
			System.out.println("---------------------------------------------------------");
		}
		
		
		
		@AfterTest 
		public void teardownTest() {
			//close browser	
		//	driver.close();
			
		}


}
