@all
Feature: Search functionality

Background:
Given User opens the application

@Search @validproduct @smoke @regression
Scenario: Search for a valid product
When User entered valid product "hp" into Search field
And User click on search button
Then Valid product should get displayed in search reasults

@Search @nonexistingproduct @regression
Scenario: Search for a non-existing product
When User enters non-existing product "honda" into search field
And User click on search button
Then Proper text informing the user that there is no product matching should be displayed

@Search @noproduct @regression
Scenario: Search without providing any product
When User dont enter any product into search field
And User click on search button
Then Proper text informing the user that there is no product matching should be displayed
