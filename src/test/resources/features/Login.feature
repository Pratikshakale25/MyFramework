Feature: Login Functionality

  Scenario: Successful Login
    Given User is on Login Page
    When User enters correct username "pratikshakale2507@gmail.com" and correct password "Sugar@123"
    And click on Login button
    Then user should be able to login


