package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class SearchResultsPage extends AbstractComponents {

	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//div[@class='product-image-container']")
	private List<WebElement> searchResults;
	
	@FindBy(xpath="//button[@id='grid-view-5']")
	private WebElement gridViewLevel5;
	
	

	
	//methods
	public ProductPage selectAnItemFromSearchResults()
	{
		if(!gridViewLevel5.isEnabled())
		{
			gridViewLevel5.click();
		}
		
		for(int i=0; i<searchResults.size();i++)
		{
			searchResults.get(2).click();
		}
		
		return new ProductPage(driver);
	}
	
	
	
	

}
