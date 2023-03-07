package Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Controller.DriverManager;
import Pages.BasePageModel;
import Pages.FlyingInformationPageModel;
import Pages.FlyingSearchPageModel;
import Pages.JourneyPageModel;
import Pages.SingUpPopupModel;

public class ObiletTestCase extends DriverManager{
	
	String airline = null;
	String flyingTime = null;
	String airPort = null;
	
	//Test sýnýfý

	
	
	@Test
	public void SingUpTest() 
	{
		
		BasePageModel basePage = new BasePageModel(driver);
		SingUpPopupModel singUpPopup = new SingUpPopupModel(driver);
		
		//Ana sayfayý açýlýr ve sayfanýn doðru þekilde açýldýðý kontrol edilir.
		driver.navigate().to("https://www.obilet.com/");
		assertEquals(basePage.isBaseBodyDisplayed(), true);

		//Üye giriþ butonuna týklanýr. Üyelik Pop-Up'ýnýn açýldýðý görülür. Üye ol butonuna týklanýr
		basePage.clickUyeGirisi();			
		assertEquals(singUpPopup.isSingUpPopupDisplayed(), true);		
		singUpPopup.clickSingUpButtonUnselected();
		
		//Mail ve Password alaný girilerek üye ol butonuna týklanýr. (Mail alaný dinamik olmasý artý olarak deðerlendirilecektir )
		singUpPopup.setEmail();
		singUpPopup.setPassword();		
		singUpPopup.clickSingUpButton();
		
		//Yeni kullanýcýnýn baþarýlý þekilde oluþturulduðu kontrol edilir.
		//ana sayfaya ger idönüldüðü kontorl edildi
		assertEquals(basePage.isBaseBodyDisplayed(), true);
		//Hesabým butonu göründümü
		assertEquals(basePage.isHesabimButtonDisplayed(), true);		
		
	}

	
	@Test
	public void AirTicketTest()
	{
		
		BasePageModel basePage = new BasePageModel(driver);
		FlyingSearchPageModel flyingSearchPage = new FlyingSearchPageModel(driver);
		
		driver.navigate().to("https://www.obilet.com/");
		//Obilet ana sayfasýna girilerek Uçak tabine týklanýr ve Uçak bileti arama sayfasýnýn açýldýðý görülür.
		basePage.clickFlyingButton();		
				
		//Bir gidiþ ili ve gidiþ tarihi , bir dönüþ ili ve dönüþ tarihi seçilir.
		flyingSearchPage.stepsFillFlyingTicketReqField();
				
		fliyingInformations(driver, "//ul[@id='outbound-journeys']//li");
		fliyingInformations(driver, "//ul[@id='return-journeys']//li");				
		lastInfo(driver, "Gidiþ");
		lastInfo(driver, "Dönüþ");	
				
		
	}
	
	
	
	public void lastInfo(WebDriver driver, String tür) {
		
//		Thread.sleep(10000);
		List <WebElement> elementList = driver.findElements(By.xpath("//table[@class='journey']//tbody"));
		System.out.println(elementList.size());
		
		//Gidiþ- Dönüþ türüne baðlý olarak liste kontrol edilir
		for(WebElement element : elementList) {
			if(element.getText().contains(tür)) {
				
				System.out.println(element.getText());
				System.out.println("-----------");
				System.out.println(airline);
				
				//uçuþ bilgileri ödeme ekranýnda yazan bilgiler ile kontrol edilir
				assertEquals(element.getText().contains(getAirline()), true);				
				assertEquals(element.getText().contains(getAirPort()), true);
				
				//False dönecek bir örnek
				assertEquals(element.getText().contains(getFlyingTime()), true);
				
					break;
				}
		}
		
	}
	
	
	public void fliyingInformations(WebDriver driver, String xpath) {
//		Thread.sleep(5000);
		//uçuþlar listeye eklenir
		List <WebElement> elementList = driver.findElements(By.xpath(xpath));
		System.out.println(elementList.size());
		
		//"Promosyonlu" uçuþ bulunur
		for(WebElement element : elementList) {
			if(element.getText().contains("Promosyonlu")) {
				System.out.println(element.getText());
				
				//sçeilen uçuþun id'si tutulur
				String id = element.getAttribute("id");
				System.out.println(id);
				
				//uçuþ bilgileri 
				WebElement airlineElement = driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li/div/div/span"));
				WebElement flyingtimeElement = driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li/div/div/div"));
				WebElement airPortElement = driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li/div/div/div/span"));
				
				
				//uçuþ bilgileri glob. deðiþkene yazýlýr
				setAirline(airlineElement.getText());				
				setFlyingTime(flyingtimeElement.getText());
				setAirPort(airPortElement.getText());
		
				
				
				System.out.println(airlineElement.getText());
				System.out.println("-----------");
				//promosyonlu uçuþa týklanýr
				element.click();
				
				//Eco'ya týklanýr
				WebElement ecoelement = driver.findElement(By.xpath(xpath +"//span[contains(text(),'Ecofly (EF)')]"));
				ecoelement.click();
					break;
			}				
			

		}
		
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlyingTime() {
		return flyingTime;
	}

	public void setFlyingTime(String flyingTime) {
		this.flyingTime = flyingTime;
	}

	public String getAirPort() {
		return airPort;
	}

	public void setAirPort(String airPort) {
		this.airPort = airPort;
	}
	
	

	
	
	
	
	
	
	
	
	

	
	
	
	

}
