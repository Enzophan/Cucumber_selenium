Feature: Funtion Add Credit Card page of Web Booking

  Scenario: 1. Verification of Add card function
    Given Open the browser is "chrome" and launch the application is "Local"
    And Login Web Booking page
    When Enter the list username and password
      |username      |password       |
      |+84905524885  |Qup@12345      |
    Then Select "Payment Method" tab
    Then Passenger add credit card after logined
      |bookingService|Cardholder       |cardNumber             | CVV |cardExpiration|
      |Home          |Auto Test WB     |4111111111111111       | 222 |12/19         |
    And Closing Web Booking

  Scenario: 2. Verification of Add card function
    Given Open the browser is "chrome" and launch the application is "Local"
    And Login Web Booking page
    When Enter the list username and password
      |username      |password       |
      |+84905524885  |Qup@12345      |
    Then Select "Payment Method" tab
    Then Passenger add credit card after logined
      |bookingService |Cardholder       |cardNumber             | CVV |cardExpiration|
      |Affiliate      |Auto Test WB     |4111111111111111       | 222 |12/19         |
    And Closing Web Booking