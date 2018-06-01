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


  Scenario: 1. Verification of booking more trip on Web Booking

    Given Open the Firefox and launch the application
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
      |3 Quang Trung, Da Nang     |Tam Ky, Quang Nam          |

    And Select Booking Type is "Book Now" for Trip
    And Enter passenger info

    And Enter payment info
    Then Booked successful

  Scenario: 1. Verification of booking more trip on Web Booking

    Given Open the Firefox and launch the application
    When I enter Pickup and Destination
      |San Bay Da Nang            |Hoi An, Quang Nam          |
      |3 Quang Trung, Da Nang     |Tam Ky, Quang Nam          |

    And Select Booking Type is "Book Later" for Trip
    And Enter passenger info
    And Enter payment info
    Then Booked successful



#  Scenario: 2. Verification of booking one trip on Web Booking
#
#    Given Open the Firefox and launch the application
#    When I enter Pickup as "Sân Bay Quốc Tế Đà Nẵng" for trip
#    And I enter Destinaton as "Furama Da nang" for trip
#    And Select Car Type for Trip
#    And Enter passenger info
#    And Enter payment info
#    Then Booked successful
#    Then Verify ETA Fare and ETA Distance and ETA Time by Car Type valid on the page
#    |cartype| etaFare| etaDistance| etaTime|

