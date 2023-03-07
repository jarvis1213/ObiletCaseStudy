package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FlyingSearchPageModel {
	
	WebDriver driver;
	
	@FindBy(id = "search-container")
	WebElement flyingTicketForm;
	
	@FindBy(id = "origin-input")
	WebElement fromCity;
	
	@FindBy(xpath = "//*[@data-value='350_67']")
	WebElement itemSAW;
	
	@FindBy(xpath = "//*[@data-value='251_18']")
	WebElement itemADB;
	
	@FindBy(id = "destination-input")
	WebElement destination;
	
	@FindBy(id = "departure-input")
	WebElement departure;
	
	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/ob-datepicker[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[7]")
	WebElement departureDate;
	
	@FindBy(id = "return")
	WebElement returnD;
	
	@FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/ob-datepicker[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/button[1]")
	WebElement returnDate;
	
	@FindBy(id = "one-way")
	WebElement oneWay;
	
	@FindBy(id = "search-button")
	WebElement searchButton;
	
	
	
	public FlyingSearchPageModel(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10000),this);

	}
	
	
	public void stepsFillFlyingTicketReqField() {
		clickFromCity();
		setFromCity();
		clickItemSAW();
		clickDestination();
		setDestination();
		clickItemADB();
		clickDeparture();
		clickDepartureDate();
		clickOneWay();
		clickReturnDate();
		clickSearchButton();
		
	}
	
	
	public boolean isFlyingTicketSearchFormDisplayed() {
		return flyingTicketForm.isDisplayed();
	} 
	
	public void clickFromCity() {
		fromCity.click();
	}
	
	public void setFromCity() {
		fromCity.sendKeys("SAW");
	}
	
	public void clickItemSAW() {
		itemSAW.click();
	}
	
	public void clickDestination() {
		destination.click();
	}
	
	public void setDestination() {
		destination.sendKeys("ADB");
	}
	
	public void clickItemADB() {
		itemADB.click();
	}
	
	public void clickDeparture() {
		departure.click();
	}
	
	public void clickDepartureDate() {
		departureDate.click();
	}
	
	public void clickReturn() {
		returnD.click();
	}
	
	public void clickReturnDate() {
		returnDate.click();
	}
	
	public void clickOneWay() {
		oneWay.click();
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
	
	
	
	
	
	
	
}
