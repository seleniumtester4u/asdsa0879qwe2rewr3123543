Feature: Assignment Feature
  
  Background: Navigate to Home Page
  	Given user navigate to home page
    Then user verify and enter "seleniumtester4u" in username field
    Then user verify and enter "QA@195519" in password field
    And user sign in with google account
  @All
  Scenario: To automate Happy Path
    When user is on home page 
    And user verify and selects the item like to order checkbox
    And user verify and enters "Blue" as liked color in editbox
    And user verify and selects "Yes" in able to find everything looking for radiobutton
    And user verify and enters "Tester" in name editbox
    And user performs file upload
    And user verify and selects date in the calendar
    And user verify and selects preferred notification from radio button
    And user verify and enters "tester@gmail.com" in email editbox
    And user verify and clicks on next button
    And user verify and enters "2104567890" in Phone editbox
    And user verify and selects no for sms notification radio button
    And user verify and clicks on submit button
