/*package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	
	
	public WebDriver driver;
	 public Properties prop;
	 public Properties dataProp;
	 
	 public Base()  { 
		prop=	new Properties();
			
			File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			
			dataProp=new Properties();
			File datapropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
			
			try {
			FileInputStream dataFis=new FileInputStream(datapropFile);
			dataProp.load(dataFis);
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
			try {
				FileInputStream fis=new FileInputStream(propFile);
				prop.load(fis);
				
			}catch(Throwable e) {
				e.printStackTrace();
				
			}
		}
	 
	
	/*public void loadPropertiesFile()  { 3.18.08
		new Properties();
		
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		
		
		try {
			FileInputStream fis=new FileInputStream(propFile);
			prop.load(fis);
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}*/
	
	/*public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\QAFoxx\\TutorialsNinjaProj\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		}else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.get(prop.getProperty("url"));
			return driver;
	}*/
	/* import io.github.bonigarcia.wdm.WebDriverManager;

	 public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

	     if (browserName.equalsIgnoreCase("chrome")) {

	         WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();

	     } else if (browserName.equalsIgnoreCase("firefox")) {

	         WebDriverManager.firefoxdriver().setup();
	         driver = new FirefoxDriver();

	     } else if (browserName.equalsIgnoreCase("edge")) {

	         WebDriverManager.edgedriver().setup();
	         driver = new EdgeDriver();
	     }

	     driver.manage().window().maximize();
	     driver.manage().timeouts()
	           .implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));

	     driver.get(prop.getProperty("url"));

	     return driver;
	 }


}*/
package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;  

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	//This is comment added to check CICD

    public WebDriver driver;
    public Properties prop;
    public Properties dataProp;

    public Base() {

        prop = new Properties();

        File propFile = new File(System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");

        dataProp = new Properties();

        File datapropFile = new File(System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");

        try {
            FileInputStream dataFis = new FileInputStream(datapropFile);
            dataProp.load(dataFis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

    	if (browserName.equalsIgnoreCase("chrome")) {

    	    WebDriverManager.chromedriver().setup();
    	    driver = new ChromeDriver();

    	} else if (browserName.equalsIgnoreCase("firefox")) {

    	    WebDriverManager.firefoxdriver().setup();
    	    driver = new FirefoxDriver();

    	} else if (browserName.equalsIgnoreCase("edge")) {

    	    WebDriverManager.edgedriver().setup();
    	    driver = new EdgeDriver();
    	}

        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));

        driver.get(prop.getProperty("url"));

        return driver;
    }
}

