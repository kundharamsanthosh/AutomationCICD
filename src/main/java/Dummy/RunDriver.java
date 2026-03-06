package Dummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunDriver {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\QAFoxx\\CucumberHybridFramework\\TutoriaNinjaProj\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		
	}

}
