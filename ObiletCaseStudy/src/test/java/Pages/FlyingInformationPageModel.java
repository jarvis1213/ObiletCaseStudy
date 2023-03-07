package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FlyingInformationPageModel {
	WebDriver driver;
	
	@FindBy(id = "outbound-journeys")
	WebElement flyingInfoList;
	
	@FindBy(xpath = "//span[contains(text(),'Promosyonlu')]")
	WebElement hasPromotionItem;
	
	@FindBy(xpath = "//span[contains(text(),'Ecofly (EF)')]")
	WebElement hasEcoflyItem;
	
	@FindBy(xpath = "//ul[@id='return-journeys']//li[@class='item journey one-way available']//div//ul//li//div//span[contains(text(),'Promosyonlu')]")
	WebElement hasPromotionItem2;
	
	@FindBy(xpath = "//*[@class='item journey one-way available open']/div/ul/li/ul/li/div/div/div/div//span[contains(text(),'Ecofly (EF)')]")
	WebElement hasEcoflyItem2;
	
	
	
	
	
	public FlyingInformationPageModel(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10000),this);

	}
	
	public boolean isFlyInfoListDisplayed() {
		return flyingInfoList.isDisplayed();
	}
	
	public void clickHasPromotionItem() {
		hasPromotionItem.click();
	}
	
	public boolean isEcolfyDisplayed() {
		return hasEcoflyItem.isDisplayed();
	}
	
	public void clickHasEcoflyItem() {
		hasEcoflyItem.click();
	}
	
	public void clickHasPromotionItem2() {
		hasPromotionItem2.click();
	}
	
	public boolean isEcolfyDisplayed2() {
		return hasEcoflyItem2.isDisplayed();
	}
	
	public void clickHasEcoflyItem2() {
		hasEcoflyItem2.click();
	}

}
