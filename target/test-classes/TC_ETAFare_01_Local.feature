Feature: Verify ETA Fare on Local

  Scenario: 1. Verification of booking more trip on Web Booking
    Given Open the browser is "chrome" and launch the application is "Local"
    When I enter Pickup and Destination
      |2 Quang Trung, Đà Nẵng            |Hoi An, Quang Nam          |
    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
    And I compare with ETA Fare, Distance, Time by Car Type
      |Car Type|Estimated fare|Estimated Distance|Estimated Time|
      |BIKE    |₫201,600      |29.1 km           |45 minutes    |
    And Closing Web Booking

  Scenario: 2. Verification of booking more trip on Web Booking
    Given Open the browser is "chrome" and launch the application is "Local"
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
    And I compare with ETA Fare, Distance, Time by Car Type
      |Car Type|Estimated fare|Estimated Distance|Estimated Time|
      |BIKE    |₫203,460      |29.4 km           |46 minutes    |
    And Closing Web Booking

  Scenario: 3. Verification of booking more trip on Web Booking
    Given Open the browser is "firefox" and launch the application is "Local"
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
    And I compare with ETA Fare, Distance, Time by Car Type
      |Car Type|Estimated fare|Estimated Distance|Estimated Time|
      |BIKE    |₫203,460      |29.4 km           |46 minutes    |
    And Closing Web Booking