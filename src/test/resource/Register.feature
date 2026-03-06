Feature: Registration functionality
Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Santhosh|
|lastName |Kundharam|
|email		|santhoshku@gmail.com|
|telephone|124567890|
|password	|Test@2025|
And User selects Privacy Policy
And User clicks on Continue Button
Then User account should get created successfully


Scenario: User creates an account with  all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Santhosh|
|lastName |Kundharam|
|email		|santhoshku@gmail.com|
|telephone|124567890|
|password	|Test@2025|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue Button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields
|firstName|Santhosh|
|lastName |Kundharam|
|email		|santhoshku@gmail.com|
|telephone|124567890|
|password	|Test@2025|

And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue Button
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field 
 
 
 