package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Controller.DriverManager;

public class BasePageModel   {
	WebDriver driver;
	

	@FindBy(xpath = "/html/body")
	WebElement oBiletBaseBody;
	
		
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/div/ul/li[1]")
	WebElement uyeGirisiButton;
	
	@FindBy(xpath = "//a[contains(text(),'Hesabým')]")
	WebElement hesabimButton;
	
	@FindBy(partialLinkText = "Uçak")
	WebElement flyingTab;
	
	
	public BasePageModel(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10000),this);
	}
	
	public boolean isBaseBodyDisplayed() {
		return oBiletBaseBody.isDisplayed();
	}
	
	
	public void clickUyeGirisi() {
		uyeGirisiButton.click();
	}
	
	public boolean isHesabimButtonDisplayed() {
		return hesabimButton.isDisplayed();
	}
	
	public void clickFlyingButton() {
		flyingTab.click();
		
	}
	

	
	
	
	
	

}
