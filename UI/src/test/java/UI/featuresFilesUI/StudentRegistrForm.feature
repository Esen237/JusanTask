Feature: Student Registration Form
@SmokeTest
  Scenario: Fill all fields
    Given User on "https://demoqa.com/automation-practice-form"
    And User should see the text"Student Registration Form"
    And User fill all fields using mock data
    Then User click on submit button