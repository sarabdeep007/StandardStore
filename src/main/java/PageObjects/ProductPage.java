package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponents;

public class ProductPage extends AbstractComponents {

	WebDriver driver;
	Select select;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//select[@id='input-option5118']")
	private WebElement sizeDropDown;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement productQuantity;
	
	
	
	
	@FindBy(xpath="//input[@id='button-cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//a[@class='btn btn-checkout']")
	private WebElement checkOutButton;
	
	@FindBy(xpath="//h1")
	private WebElement productName;
	
	
	
	//methods - Patka Product Page
	public void addPatkaToCart()
	{
		select = new Select(sizeDropDown);
		select.selectByIndex(1);
		//select.getFirstSelectedOption().click();
		productQuantity.sendKeys("2");
		addToCartButton.click();
		waitForElementVisibilityAndClick(checkOutButton);
		
	}
	
	public String getProductName()
	{
		return productName.getText();
	}

	
}
