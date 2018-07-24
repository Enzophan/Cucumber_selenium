Feature: Verify ETA Fare

  Scenario: 1. Verification of booking more trip on Web Booking
    Given Open the browser is "chrome" and launch the application is "Beta"
    When I enter Pickup and Destination
      |2 Quang Trung, Da Nang           |Hoi An, Quang Nam          |
    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
    And I compare with ETA Fare, Distance, Time by Car Type
      |Car Type|Estimated fare|Estimated Distance|Estimated Time|
      |SEDAN   |PHP77,476.60  |29.1 km           |46 minutes    |
    And Closing Web Booking

  Scenario: 2. Verification of booking more trip on Web Booking
    Given Open the browser is "chrome" and launch the application is "Beta"
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
    And I compare with ETA Fare, Distance, Time by Car Type
      |Car Type|Estimated fare|Estimated Distance|Estimated Time|
      |SEDAN   |PHP78,094.60  |29.4 km           |46 minutes    |
    And Closing Web Booking

  Scenario: 3. Verification of booking more trip on Web Booking
    Given Open the browser is "chrome" and launch the application is "Beta"
    When I enter Pickup and Destination
      |Thanh Tịnh, Hòa Minh, Liên Chiểu, Đà Nẵng            |furama resort da nang          |
    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
    And I compare with ETA Fare, Distance, Time by Car Type
      |Car Type|Estimated fare|Estimated Distance|Estimated Time|
      |SEDAN   |PHP40,994.00  |11.4 km           |25 minutes    |
    And Closing Web Booking