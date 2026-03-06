package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {
	
	static WebDriver driver = null;
	
	public static void initializeBrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\QAFoxx\\CucumberHybridFramework\\TutoriaNinjaProj\\drivers\\chromedriver.exe");
			
			driver= new ChromeDriver();
			
		}
		
		else if (browserName.equals("firefox")) {
			

			 driver= new FirefoxDriver();
			
		}
		
		
		
	}
	
	public static WebDriver getDriver() {
		return driver;
		
	}
	
	
	

}
