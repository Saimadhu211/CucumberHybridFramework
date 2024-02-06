@all
Feature: User Login
Register User should be  able to login to access account details

Background:
Given User navigates to Login page 

@login @validcredentials @smoke @regression
Scenario Outline: Login with valid credentials
When User enters valid email address <username>
And Enters valid password <password>
And Clicks on Login button
Then User should login successfully
Examples:
|username              |password|
|amotooricap1@gmail.com|12345|
|amotooricap2@gmail.com|12345|
|amotooricap3@gmail.com|12345|
|amotooricap7@gmail.com|12345|

@login @invalidcredentials @smoke @regression
Scenario: Login with invalid credentials
When User enters invalid email address 
And Enters invalid password "1234567890"
And Clicks on Login button
Then User should get a proper warning message

@login @validemailandinvalidpassword @regression
Scenario: Login with valid email address and invalid password
When User enters valid email address "amotooricap9@gmail.com"
And Enters invalid password "1234567890"
And Clicks on Login button
Then User should get a proper warning message

@login @invalidemailandvalidpassword  @regression
Scenario: Login with invalid email address and valid password
When User enters invalid email address 
And Enters valid password "12345"
And Clicks on Login button
Then User should get a proper warning message

@login @nocredentials  @regression
Scenario: Login without providing any credentials
When User dont enter any credentials
And Clicks on Login button
Then User should get a proper warning message




