package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.OrderTrackingPage;
import PageObjects.RegisterPage;
import PageObjects.SearchResultsPage;

public class AbstractComponents {
	
	WebDriver driver;
	Actions actions;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	//Elements
	@FindBy(xpath="//button[@class='btn-link dropdown-toggle']")
	private WebElement currencyDropDown;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li")
	private List<WebElement> currencies;
	
	@FindBy(xpath="//a[@title='track order']")
	private WebElement trackOrder;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	private WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath="//a[@href='https://www.khalsastore.com/index.php?route=account/login']")
	private WebElement loginLinkMyAccount;
	
	@FindBy(xpath="//a[@title='Wish List (0)']")
	private WebElement wishListMyAccount;
	
	@FindBy(xpath="//a[@id='wishlist-total']")
	private WebElement wishListMainMenu;
	
	@FindBy(xpath="//a[contains(@title,'Checkout')]")
	private WebElement checkOutLink;
	
	@FindBy(xpath="//a[@class='link-lg']")
	private WebElement loginLinkMainMenu;
	
	@FindBy(xpath="//img[@title='Khalsastore.com']")
	private WebElement homeLogo;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchBoxHomePage;
	
	@FindBy(name="submit_search")
	private WebElement searchBoxButton;
	
	@FindBy(xpath="//p[@class='text-shopping-cart']")
	private WebElement myCartButton;
	
	@FindBy(xpath="//a[@class='btn btn-view-cart inverse']")
	private WebElement viewCartButton;
	
	@FindBy(xpath="//a[@href='https://www.khalsastore.com/index.php?route=information/shipway_track']")
	private WebElement floatingTrackingButton;
	
	@FindBy(xpath="//img[@alt='whatsapp me']")
	private WebElement floatingWhatsAppButton;
	
	
	
	
	
	
	//Methods
	public String chooseCurrency(String currency) throws InterruptedException
	{
		actions.moveToElement(currencyDropDown).build().perform();
		
		String selectedCurrency = null;
		for(WebElement ele: currencies)
		{
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase(currency))
			{
				selectedCurrency = ele.getText();
				ele.click();
				
				break;
				
				
			}
		}
		
		return selectedCurrency;
		
		
		
		
		
	}
	
	public OrderTrackingPage getTrackOrder()
	{
		trackOrder.isDisplayed();
		trackOrder.click();
		return new OrderTrackingPage(driver);
	}

	public RegisterPage gotoRegister()
	{
		actions.moveToElement(myAccount).build().perform();
		registerLink.click();
		return new RegisterPage(driver);
		
	}
	
	public void gotoLoginFromMyAccount()
	{
		actions.moveToElement(myAccount).build().perform();
		loginLinkMyAccount.click();
	}
	
	public void getWishListFromMyAccount()
	{
		actions.moveToElement(myAccount).build().perform();
		wishListMyAccount.click();
	}
	
	public void getWishListFromMainMenu()
	{
		wishListMainMenu.isDisplayed();
		wishListMainMenu.click();
	}
	
	public void gotoCheckout()
	{
		checkOutLink.isDisplayed();
		checkOutLink.click();
	}
	
	public void getLoginMainMenu()
	{
		loginLinkMainMenu.isDisplayed();
		loginLinkMainMenu.click();
	}
	
	public void clickHomeLogo()
	{
		homeLogo.isDisplayed();
		homeLogo.click();
	}
	
	public SearchResultsPage searchItem(String itemToSearch)
	{
		searchBoxHomePage.isDisplayed();
		searchBoxHomePage.sendKeys(itemToSearch);
		waitForElementVisibilityAndClick(searchBoxButton);
		return new SearchResultsPage(driver);
		
	}
	
	public void clickFloatingTrackingButton()
	{
		floatingTrackingButton.click();
	}
	
	public void clickFloatingWhatsAppButton()
	{
		floatingWhatsAppButton.click();
	}
	
	public void viewCart()
	{
		actions.moveToElement(myCartButton).build().perform();
		waitForElementVisibilityAndClick(viewCartButton);
	}
	
	public void waitForElementVisibility(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	
	public void waitForElementVisibilityAndClick(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele)).click();;
	}
	
	
}








