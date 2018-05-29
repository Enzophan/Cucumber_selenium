Feature: Reset functionality on login page of Application


#  Scenario: 1. Verification of Login/Logout button on Web Booking
#    Given Open the Firefox and launch the application
#    And Login Web Booking page
#    When Enter the Username and Password on Web Booking
#    Then Logout page

#  Scenario: 1. Verification of Login function on Web Booking
#    Given Open the Firefox and launch the application
#    And Login Web Booking page
#    When Enter the list username and password
#    Examples:
#    |username      |password     |
#    |+84901223344  |demo@12345   |
#    Then Logout page


#  Scenario: 2. Verification of booking one trip on Web Booking
#
#    Given Open the Firefox and launch the application
#    When Enter Location to Booking one trip
#    And Select Car Type for Trip
#    Then Booked successful

  Scenario: 2. Verification of booking more trip on Web Booking

    Given Open the Firefox and launch the application
    When I enter Pickup as "2 Quang Trung, TP Da Nang" for trip
    And I enter Destinaton as "Furama Da nang" for trip
    And Select Car Type for Trip
    Then Booked successful
