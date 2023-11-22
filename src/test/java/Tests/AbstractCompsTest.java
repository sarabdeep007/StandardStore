package Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.RegisterPage;
import Resources.Constants;
import TestComponents.BaseTest;


public class AbstractCompsTest extends BaseTest {
	
	HomePage homePage;
	ProductPage productPage;
	RegisterPage registerPage;
	Logger logger = (Logger) LogManager.getLogger();
	@BeforeMethod
	public void testSetup()
	{
		homePage = new HomePage(driver);
		productPage = new ProductPage(driver);
		registerPage = new RegisterPage(driver);
	}

	//logger.info(" ");
	@Test (enabled=true)
	public void verifyCurrencySelection() throws InterruptedException
	{
		String actualSelection = homePage.chooseCurrency(Constants.CURRENCY_TO_USE);
		Assert.assertEquals(Constants.CURRENCY_TO_USE, actualSelection);
		logger.info("Expected currency selection Passed ");
		
		
	}
	
	@Test(enabled=true)
	public void verifyOrderTracking_InvalidTrackingID()
	{
		String expected_invalidOrderTrackingMessage = "No tracking number associated with this order";
		String actual_invalidOrderTrackingMessage = homePage.getTrackOrder().getTracking(Constants.INVALID_ORDER_TRACKING);
		Assert.assertEquals(expected_invalidOrderTrackingMessage, actual_invalidOrderTrackingMessage);
		logger.info("Order ID Tracking for invalidID verified correctly with expected Invalid Order Tracking Text");
		
	}
	
	@Test(enabled=true)
	public void searchAndAddItemToCart() throws InterruptedException
	{
		homePage.chooseCurrency(Constants.CURRENCY_TO_USE);	
		logger.info("Currency is set to: "+Constants.CURRENCY_TO_USE);
		homePage.searchItem(Constants.ITEM_TO_SEARCH_1).selectAnItemFromSearchResults().addPatkaToCart();
		logger.info("Item Added to Cart");
		//productPage.addPatkaToCart();
		homePage.viewCart();
		logger.info("Cart Viewed");
		
		
		
		
	}
	
	@Test(enabled=true)
	public void verifyFloatingButtons_ScrollingToBottomOfScreen() throws InterruptedException
	{
		//go to the bottom of the screen
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		logger.info("Moved to the bottom of the Screen ");
		
		//verify the tracking order floating button is visible and active
		homePage.clickFloatingTrackingButton();
		
		logger.info("Clicked floating tracking button on Home Page ");
		driver.navigate().back();
		logger.info("Switched back to the Home Page ");
		js.executeScript("window.scrollTo(0, 0)");
		logger.info("Moved to the top of the screen ");
		
		homePage.clickFloatingWhatsAppButton();
		logger.info("Clicked floating WhatsApp Button ");
		
		if(driver.getTitle().equalsIgnoreCase("Share on WhatsApp"))
		{
			logger.info("Share on WhatsApp Page opened");
		}

	}
	
	@Test(enabled=true)
	public void verifyRegisterationPage()
	{
		homePage.gotoRegister().clickContinueButton();
		logger.info("Clicked continue button on Register Page without checking Privacy Policy CheckButton");
		Assert.assertEquals(Constants.PRIVACY_WARNING_MESSAGE, registerPage.privacyWarningMessage());
		logger.info("Expected Privacy warning Message displayed");
	}
}
