package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderTrackingPage extends AbstractComponents{

	WebDriver driver;
	
	public OrderTrackingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//elements
	@FindBy(xpath="//input[@name='order_id']")
	private WebElement orderIdSearchBox;
	
	@FindBy(xpath="//input[@name='btnSubmit']")
	private WebElement trackButton;
	
	@FindBy(xpath="//td[normalize-space()='No tracking number associated with this order']")
	private WebElement notExistingOrderIdTracking;
	
	//methods
	public String getTracking(String trackingNumber)
	{
		orderIdSearchBox.sendKeys(trackingNumber);
		trackButton.click();
		return notExistingOrderIdTracking.getText();
	}
	
	

}
