Feature: Login functionality


Scenario: Login with valid credentials
Given User navigates to login page
When User has enters valid email address "kundharamsanthosh18@gmail.com" into the email field
And User has enters valid password "Test@2024" into the password field
And User clicks on Login button
Then User should get successfully logged in

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address "kundharamsanthsofdk@gmail.com" into the email field
And User enters invalid password "45426565" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User has enters valid email address "kundharamsanthosh18@gmail.com" into the email field
And User enters invalid password "45426565" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

@Test1
Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address "kundharamsanthsofdk@gmail.com" into the email field
And User has enters valid password "Test@2024" into the password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont  enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch



