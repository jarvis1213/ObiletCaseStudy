package Controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver driver;
	

	public DriverManager() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.operadriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
	}
		
	
	//child driverlara eriþmek için kullanýlýr
	public void switcDriver(int driverHandle) {
		Set<String> handles = driver.getWindowHandles();

		List<String> ls = new ArrayList<String>(handles);

		String parent = ls.get(0);
		String child = ls.get(1);
		
		if(driverHandle == 1) {
			driver.switchTo().window(child);
		}
		
		if(driverHandle == 2) {
			driver.switchTo().window(parent);
		}
	

		
	}
	
	



}
