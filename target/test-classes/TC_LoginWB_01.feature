Feature: Funtion login page of Web Booking


#  Scenario: 1. Verification of Login/Logout button on Web Booking
#    Given Open the Firefox and launch the application
#    And Login Web Booking page
#    When Enter the Username and Password on Web Booking
#    Then Logout page

  Scenario: 1. Verification of Login function on Web Booking
    Given Open the browser is "chrome" and launch the application is "Lab"
    And Login Web Booking page
    When Enter the list username and password
    |username      |password     |
    |+84901223344  |demo@12345   |
    Then Logout page
    And Closing Web Booking