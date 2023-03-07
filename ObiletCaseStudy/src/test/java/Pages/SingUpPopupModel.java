package Pages;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Utilities.UniqueTextGenerator;

public class SingUpPopupModel {
	WebDriver driver;
	UniqueTextGenerator uniqueTextGenerator = new UniqueTextGenerator();
	
	
	@FindBy(css = "body > div.ob-modal-overlay.pop.top.open > div")
	WebElement singUpPopup;
	
	@FindBy(xpath = "//a[contains(text(),'Üye Ol')]")
	WebElement singUpButtonUnselected;
	
	@FindBy(xpath = "//button[contains(text(),'Üye Ol')]")
	WebElement singUpButton;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;

	public SingUpPopupModel(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10000),this);
	}
	
	
	public boolean isSingUpPopupDisplayed() {
		return singUpPopup.isDisplayed();
	}
	
	public void clickSingUpButtonUnselected() {
		singUpButtonUnselected.click();
	}
	
	public void clickSingUpButton() {
		singUpButton.click();
	}
	
	public void setEmail() {
		email.sendKeys(uniqueTextGenerator.generateRandomEmail());
	}
	
	public void setPassword() {
		password.sendKeys(uniqueTextGenerator.getUniqueId());
	}
	

	

}
