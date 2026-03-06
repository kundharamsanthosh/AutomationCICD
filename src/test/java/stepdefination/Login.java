package stepdefination;



import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.Driverfactory;
import io.cucumber.java.en.*;

public class Login {
    WebDriver driver;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver = Driverfactory.getDriver();
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("User has enters valid email address {string} into the email field")
    public void user_enters_valid_email_address(String emailText) {
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);
    }

    @And("User has enters valid password {string} into the password field")
    public void user_enters_valid_password(String passwordText) {
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);
    }

    @And("User enters invalid email address {string} into the email field")
    public void user_enters_invalid_email_address(String invalidEmailText) {
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailWithTimeStamp());
    }

    @And("User enters invalid password {string} into the password field")
    public void user_enters_invalid_password(String invalidPasswordText) {
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidPasswordText);
    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//input[@value='Login']")).click(); // YOU MISSED .click()
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_warning_message_about_credentials_mismatch() {
        String warningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        Assert.assertTrue(warningMessage.contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("User dont enter email address into email field")
    public void user_dont_enter_email_address_into_email_field() {
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
    }

    @And("User dont  enter password into password field")
    public void user_dont_enter_password_into_password_field() {
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
    }
    
    public String getEmailWithTimeStamp() {
    	
    	Date date=new Date();
    	return "santhosh"+date.toString().replace(""," ").replace(":"," ")+"@gmail";
    }
}
