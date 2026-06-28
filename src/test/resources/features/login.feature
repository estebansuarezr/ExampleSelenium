Feature: Login

  Scenario: Successful login

    Given the user is on the login page
    When the user logs in with user and password
    Then the Products page should be displayed