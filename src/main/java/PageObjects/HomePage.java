package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
}
