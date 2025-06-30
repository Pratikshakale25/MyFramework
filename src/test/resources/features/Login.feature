Feature: Login Functionality

  Background:
    Given User is on Login Page

  Scenario: Successful Login
    When User enters correct username "pratikshakale2507@gmail.com" and correct password "Sugar@123"
    And click on Login button
    Then user should be able to login

  Scenario Outline: Unsuccessful Login
    When User enters incorrect "<username>" or incorrect "<password>"
    And click on Login button
    Then error msg should be visible "Your email or password is incorrect!"

Examples:
    |username                   |password|
    |pratikshakale2507@gmail.com|wrongpassword|
    |wrong@username              |Sugar@123    |
    |wrong@username              |wrongpassword|