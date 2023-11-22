package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class RegisterPage extends AbstractComponents {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyWarningMessage;
	
	
	
	
	
	//Methods
	public void clickContinueButton()
	{
		continueButton.click();
	}
	
	public String privacyWarningMessage()
	{
		return privacyWarningMessage.getText();
	}
}


