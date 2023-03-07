package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class JourneyPageModel {
	WebDriver driver;
	
	@FindBy(id = "journey-contact-info")
	WebElement journeyInfo;
	
	
	
	
	
	
	
	public JourneyPageModel(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10000),this);

	}
	
	public boolean isJourneyInfoDisplayed() {
		return journeyInfo.isDisplayed();
	}

}
