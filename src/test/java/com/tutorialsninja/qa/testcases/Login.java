package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;


public class Login extends Base {
	LoginPage loginpage;
	
	public Login() {
		super();
	}
	public WebDriver driver;//addedpublic to access driver to My Listners
	
	@BeforeMethod
	public void setup() {
		//loadPropertiesFile();3.18.15
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage=new HomePage (driver);
		homepage.clickOnMyAccount();
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		homepage.selectLoginOption();
		//driver.findElement(By.linkText("Login")).click();
		}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	
	
	
	/*@Test(priority=1,dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String email,String Password) {
		//kundharamsanthosh18@gmail.com
		//Test@2025e
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		loginpage.enterPassword(Password);
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
		loginpage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		AccountPage accountPage=new AccountPage(driver);
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
		
		//driver.quit();
		
	}
	
	@DataProvider(name="supplyTestData")
	public Object[][] supplyTestData() throws IOException {
		//Object[][] data= {{"santhoshk19@gmail.com","123456"},{"santhoshk20@gmail.com","123456"},{"santhoshk21@gmail.com","123456"}};
		Object[][] data=Utilities.getTestDataFromExcel("Login");
		
		return data;
	}*/
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {

		LoginPage loginpage=new LoginPage(driver);
		//kundharamsanthosh18@gmail.com
		//Test@2025
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();

		String actualWarningMessage=loginpage.retrieveEmailPasswordNotMatchingWarningMessageText();
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		//driver.quit();
	
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		//kundharamsanthosh18@gmail.com
		//Test@2025
		LoginPage loginpage=new LoginPage(driver);
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		loginpage.clickOnLoginButton();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String actualWarningMessage=loginpage.retrieveEmailPasswordNotMatchingWarningMessageText();
		
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		
		//driver.quit();
	
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		//kundharamsanthosh18@gmail.com
		//Test@2025

		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		loginpage.clickOnLoginButton();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String actualWarningMessage=loginpage.retrieveEmailPasswordNotMatchingWarningMessageText();
		
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		//driver.quit();
	
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {

		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickOnLoginButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String actualWarningMessage=loginpage.retrieveEmailPasswordNotMatchingWarningMessageText();
		
		String expectedWarningMessage=dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		//driver.quit();
	
		
		
	}
	
	

}
