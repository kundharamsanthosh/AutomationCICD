package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	@FindBy(linkText="HP LP3065")
	WebElement validHPProduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
	WebElement noProductMessage;
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean displayStatusOfHPValidProduct() {
		boolean diaplayStatus=validHPProduct.isDisplayed();
		return diaplayStatus;
	}
	
	public String retriveNoProductMessageText() {
		String noProductMessageText=noProductMessage.getText();
		return noProductMessageText;
	}

}
