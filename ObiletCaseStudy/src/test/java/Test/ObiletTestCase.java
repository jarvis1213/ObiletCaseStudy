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
	
	//Test s�n�f�

	
	
	@Test
	public void SingUpTest() 
	{
		
		BasePageModel basePage = new BasePageModel(driver);
		SingUpPopupModel singUpPopup = new SingUpPopupModel(driver);
		
		//Ana sayfay� a��l�r ve sayfan�n do�ru �ekilde a��ld��� kontrol edilir.
		driver.navigate().to("https://www.obilet.com/");
		assertEquals(basePage.isBaseBodyDisplayed(), true);

		//�ye giri� butonuna t�klan�r. �yelik Pop-Up'�n�n a��ld��� g�r�l�r. �ye ol butonuna t�klan�r
		basePage.clickUyeGirisi();			
		assertEquals(singUpPopup.isSingUpPopupDisplayed(), true);		
		singUpPopup.clickSingUpButtonUnselected();
		
		//Mail ve Password alan� girilerek �ye ol butonuna t�klan�r. (Mail alan� dinamik olmas� art� olarak de�erlendirilecektir )
		singUpPopup.setEmail();
		singUpPopup.setPassword();		
		singUpPopup.clickSingUpButton();
		
		//Yeni kullan�c�n�n ba�ar�l� �ekilde olu�turuldu�u kontrol edilir.
		//ana sayfaya ger id�n�ld��� kontorl edildi
		assertEquals(basePage.isBaseBodyDisplayed(), true);
		//Hesab�m butonu g�r�nd�m�
		assertEquals(basePage.isHesabimButtonDisplayed(), true);		
		
	}

	
	@Test
	public void AirTicketTest()
	{
		
		BasePageModel basePage = new BasePageModel(driver);
		FlyingSearchPageModel flyingSearchPage = new FlyingSearchPageModel(driver);
		
		driver.navigate().to("https://www.obilet.com/");
		//Obilet ana sayfas�na girilerek U�ak tabine t�klan�r ve U�ak bileti arama sayfas�n�n a��ld��� g�r�l�r.
		basePage.clickFlyingButton();		
				
		//Bir gidi� ili ve gidi� tarihi , bir d�n�� ili ve d�n�� tarihi se�ilir.
		flyingSearchPage.stepsFillFlyingTicketReqField();
				
		fliyingInformations(driver, "//ul[@id='outbound-journeys']//li");
		fliyingInformations(driver, "//ul[@id='return-journeys']//li");				
		lastInfo(driver, "Gidi�");
		lastInfo(driver, "D�n��");	
				
		
	}
	
	
	
	public void lastInfo(WebDriver driver, String t�r) {
		
//		Thread.sleep(10000);
		List <WebElement> elementList = driver.findElements(By.xpath("//table[@class='journey']//tbody"));
		System.out.println(elementList.size());
		
		//Gidi�- D�n�� t�r�ne ba�l� olarak liste kontrol edilir
		for(WebElement element : elementList) {
			if(element.getText().contains(t�r)) {
				
				System.out.println(element.getText());
				System.out.println("-----------");
				System.out.println(airline);
				
				//u�u� bilgileri �deme ekran�nda yazan bilgiler ile kontrol edilir
				assertEquals(element.getText().contains(getAirline()), true);				
				assertEquals(element.getText().contains(getAirPort()), true);
				
				//False d�necek bir �rnek
				assertEquals(element.getText().contains(getFlyingTime()), true);
				
					break;
				}
		}
		
	}
	
	
	public void fliyingInformations(WebDriver driver, String xpath) {
//		Thread.sleep(5000);
		//u�u�lar listeye eklenir
		List <WebElement> elementList = driver.findElements(By.xpath(xpath));
		System.out.println(elementList.size());
		
		//"Promosyonlu" u�u� bulunur
		for(WebElement element : elementList) {
			if(element.getText().contains("Promosyonlu")) {
				System.out.println(element.getText());
				
				//s�eilen u�u�un id'si tutulur
				String id = element.getAttribute("id");
				System.out.println(id);
				
				//u�u� bilgileri 
				WebElement airlineElement = driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li/div/div/span"));
				WebElement flyingtimeElement = driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li/div/div/div"));
				WebElement airPortElement = driver.findElement(By.xpath("//*[@id='"+id+"']/div/ul/li/div/div/div/span"));
				
				
				//u�u� bilgileri glob. de�i�kene yaz�l�r
				setAirline(airlineElement.getText());				
				setFlyingTime(flyingtimeElement.getText());
				setAirPort(airPortElement.getText());
		
				
				
				System.out.println(airlineElement.getText());
				System.out.println("-----------");
				//promosyonlu u�u�a t�klan�r
				element.click();
				
				//Eco'ya t�klan�r
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
