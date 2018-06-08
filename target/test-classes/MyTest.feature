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

#
  Scenario: 1. Verification of booking more trip on Web Booking
    Given Open the Firefox and launch the application
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
    And Select Booking Type is "Book Now" for Trip
    And Enter ride info for "Book Now"
    And Enter payment info
    Then Booked successful
      |ETA Fare    |
      |PHP85,676.60|
    And Verify status booking after request
#
  Scenario: 2. Verification of booking more trip on Web Booking
    Given Open the Firefox and launch the application
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
    And Select Booking Type is "Book Later" for Trip
    And Enter ride info for "Book Later"
    And Enter payment info
    Then Booked successful
      |ETA Fare     |
      |PHP138,766.60|
    And Verify status booking after request
#
  Scenario: 3. Verification of booking one trip on Web Booking

    Given Open the Firefox and launch the application
    When I enter Pickup as "2 Quang Trung, Da Nang" for trip
    And I enter Destinaton as "San Bay Da Nang" for trip
    And Select Booking Type is "Book Now" for Trip
    And Enter passenger info and ride info
    |firstname|lastname|phonePassenger|email                 |flight    |meetDriver|tip|promoCode|
    |Nhân     |Phan    |+84904777447  |phannhan.dn@gmail.com |VJC502    |          |19 |AUTO001  |
    And Enter payment info
    Then Booked successful
    |ETA Fare    |
    |PHP91,803.80|
    And Verify status booking after request
#
  Scenario: 4. Verification of booking one trip on Web Booking

    Given Open the Firefox and launch the application
    When I enter Pickup as "San Bay Da Nang" for trip
    And I enter Destinaton as "123 Ngô Quyền, Đà Nẵng" for trip
    And Select Booking Type is "Book Now" for Trip
    And Enter passenger info and ride info
      |firstname|lastname|phonePassenger|email                 |flight    |meetDriver|tip|promoCode|
      |Nhân     |Phan    |+84904777447  |phannhan.dn@gmail.com |VJC502    |1         |19 |AUTO001  |
    And Enter payment info
    Then Booked successful
      |ETA Fare    |
      |PHP91,803.80|
    And Verify status booking after request

  Scenario: 5. Verification of booking one trip on Web Booking

    Given Open the Firefox and launch the application
    When I enter Pickup as "San Bay Da Nang" for trip
    And I enter Destinaton as "123 Ngô Quyền, Đà Nẵng" for trip
    And Select Booking Type is "Book Later" for Trip
    And Enter passenger info and ride info
      |firstname|lastname|phonePassenger|email                 |flight    |meetDriver|tip|promoCode|
      |Nhân     |Phan    |+84904777447  |phannhan.dn@gmail.com |VJC502    |1         |19 |AUTO001  |
    And Enter payment info
    Then Booked successful
    |ETA Fare    |
    |PHP91,803.80|
    And Verify status booking after request
