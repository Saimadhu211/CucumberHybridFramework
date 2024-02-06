@all
Feature: User Registeration


Background:
Given User navigates to Register Account page

@register @mandatoryfields @smoke @regression
Scenario: Register with mandatory fields
When User entres below details into the fields
|firstname|Arun|
|lastname|Motoori|
|telephone|1234567890|
|password|12345|
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get Successfully created

@register @allfields @smoke @regression
Scenario: Register with All fields
When User entres below details into the fields
|firstname|Arun|
|lastname|Motoori|
|telephone|1234567890|
|password|12345|
And Selects Yes for Newsletters
And Selects Privacy Policy field
And Clicks on Continue button
Then Account should get Successfully created

@register @nodetails @regression
Scenario: Register without providing any fields
When User dont enter details into any fields
And Clicks on Continue button
Then Warning messages should be displayed under all the mandatory fields

@register @duplicateemail @regression
Scenario: Register with duplicate email address
When User entres below details into below fields with duplicate email
|firstname|Arun|
|lastname|Motoori|
|emailaddress|amotooricap9@gmail.com|
|telephone|1234567890|
|password|12345|
And Selects Yes for Newsletters
And Selects Privacy Policy field
And Clicks on Continue button
Then Warning message informating the user about duplicate email should be displayed
 

