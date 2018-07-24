Feature: Funtion login page of Web Booking


#  Scenario: 1. Verification of Login/Logout button on Web Booking
#    Given Open the Firefox and launch the application
#    And Login Web Booking page
#    When Enter the Username and Password on Web Booking
#    Then Logout page

  Scenario: 1. Verification of Login/Logout function on Web Booking
    Given Open the browser is "chrome" and launch the application is "Lab"
    And Login Web Booking page
    When Enter the list username and password
    |username      |password     |
    |+84901223344  |demo@12345   |
    Then Logout page
    And Closing Web Booking

  Scenario: 2. Verification of Add Credit on Web Booking/Payment Method
    Given Open the browser is "chrome" and launch the application is "Lab"
    And Login Web Booking page
    When Enter the list username and password
      |username      |password     |
      |+84901223344  |demo@12345   |
    Then Passenger add credit card after logined
    |bookingService|Cardholder       |cardNumber             | CVV |cardExpiration|
    |Home          |Auto Test WB     |4111111111111111       | 222 |12/19         |
    And Logout page
    And Closing Web Booking

  Scenario: 3. Verification of Add Credit on Web Booking/Payment Method
    Given Open the browser is "chrome" and launch the application is "Lab"
    And Login Web Booking page
    When Enter the list username and password
      |username      |password     |
      |+84901223344  |demo@12345   |
    Then Passenger remove credit card after logined
      |bookingService|
      |Home          |
    And Logout page
    And Closing Web Booking