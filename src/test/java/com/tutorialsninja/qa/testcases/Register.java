package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base {
	
	public Register() {
		super();
	}
	
	public WebDriver driver;// added public to access webdriver to MyListners
	

	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		homepage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click();
			
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		RegisterPage registerpage=new RegisterPage(driver);
		
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));

		registerpage.enterLastName(dataProp.getProperty("lastName"));
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		registerpage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("telephoneNumber"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		registerpage.selectPrivacyPolicy();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://tutorialsninja.com/demo/index.php?route=account/success";
		Assert.assertEquals(actualURL, expectedURL);
	
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		RegisterPage registerpage=new RegisterPage(driver);
		
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		registerpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		registerpage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("telephoneNumber"));
		
		registerpage.enterPassword(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		
		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		registerpage.selectYesNewsLetterOption();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		registerpage.selectPrivacyPolicy();
		
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		registerpage.clickOnContinueButton();
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://tutorialsninja.com/demo/index.php?route=account/success";
		Assert.assertEquals(actualURL, expectedURL);
	
		
	
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		RegisterPage registerpage=new RegisterPage(driver);
		
		
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("firstName"));
		
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("lastName"));
		
		registerpage.enterEmailAddress(prop.getProperty("validEmail"));
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		registerpage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("telephoneNumber"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));

		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerpage.selectYesNewsLetterOption();
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		registerpage.selectPrivacyPolicy();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualWarning=registerpage.retrieveDuplicateEmailAddressWarning();
		
		//String actualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarning=dataProp.getProperty("duplicateEmailWarning");
		Assert.assertTrue(actualWarning.contains(expectedWarning),"Warning message regarding duplicate email address is not displayed");
		
	
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.clickOnContinueButton();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String actualPrivacyPolicyWarning=registerpage.retrivePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy Policy Warning message is not displayed");
		
		//String actualFirstNameWarning=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		String actualFirstNameWarning=registerpage.retrieveFirstNameWarning();
		Assert.assertEquals(actualFirstNameWarning,dataProp.getProperty("firstNameWarning"),"First Name Warning is not displayed");
		
		//String actualLastNameWarning=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		String actualLastNameWarning=registerpage.retrieveLastNameWarning();
		
		Assert.assertEquals(actualLastNameWarning,dataProp.getProperty("lastNameWarning"),"Last Name Warning is not displayed");
		
		//String actualEmailWarning=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		String actualEmailWarning=registerpage.retrieveEmailWarning();
		
		Assert.assertEquals(actualEmailWarning,dataProp.getProperty("emailWarning"),"Email Warning is not displayed");
		
		//String telephoneWarning=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		String telephoneWarning=registerpage.retrieveTelephoneWarning();
		
		Assert.assertEquals(telephoneWarning,dataProp.getProperty("telephoneWarning"),"Telephone Warning is not displayed");
		
		//String actualPasswordWarning=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		String actualPasswordWarning=registerpage.retrievePasswordWarning();
		
		Assert.assertEquals(actualPasswordWarning,dataProp.getProperty("passwordWarning"),"Password Warning is not displayed");
		

		
		
		
		
		
		
	}
	

}
