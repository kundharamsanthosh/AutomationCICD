package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class Search extends Base {
	
	public Search() {
		super();
	}

	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
			
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		HomePage homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		homePage.clickOnSearchButton();
		SearchPage searchPage=new SearchPage(driver);
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product HP is not displayed");
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),"Valid product HP is not displayed");
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		HomePage homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
		//driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		homePage.clickOnSearchButton();
		SearchPage searchPage=new SearchPage(driver);
		//String actualValidation=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]")).getText();
		String actualValidation=searchPage.retriveNoProductMessageText();
		
		String expectedValidation=dataProp.getProperty("NoProductTextInSearchResults");
		Assert.assertEquals(actualValidation, expectedValidation,"No Product in search results");
			}
	@Test(priority=3)
	public void verifySearchWithoutAnyProduct(){
		HomePage homePage=new HomePage(driver);
		homePage.clickOnSearchButton();
		SearchPage searchPage=new SearchPage(driver);
		
		//String actualValidation=driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]")).getText();
		String actualValidation=searchPage.retriveNoProductMessageText();
		
		String expectedValidation=dataProp.getProperty("NoProductTextInSearchResults");
		Assert.assertEquals(actualValidation, expectedValidation,"No Product in search results");
		
			
		
	}
	

}
