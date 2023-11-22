package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Resources.Constants;
import TestComponents.BaseTest;

public class demoTest extends BaseTest{
	
	HomePage homePage;
	
	@BeforeMethod
	public void testSetup()
	{
		homePage = new HomePage(driver);
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		System.out.println("Hello in test");
		homePage.chooseCurrency(Constants.CURRENCY_TO_USE);
		Thread.sleep(2000);
		
		
	}

}
