Feature: Reset functionality on login page of Application

  Scenario: 1. Verification of Login function on Web Booking
    Given Open the browser is "chrome" and launch the application is "Lab"
    And Login Web Booking page
    When Enter the list username and password
    Examples:
    |username      |password     |
    |+84901223344  |demo@12345   |
    Then Logout page

  Scenario: 2. Verification of Login function on Web Booking
    Given Open the browser is "chrome" and launch the application is "Lab"
    And Login Web Booking page
    When Enter the list username and password
  Examples:
  |username      |password     |
  |+84901223344  |demo@12345   |
    Then Logout page


