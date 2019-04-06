Feature: Wep-app Hotel Test

  Scenario: Try to connect to driver

    Given value path to driver "/Users/klass/Desktop/VIII семестр/4. Верификация/bdd web-app/chromedriver.exe"
    And create driver
    When get driver "http://127.0.0.1:8080/booking"
    Then check driver is not null
    And check title is "Бронирование номеров"

  Scenario Outline: Menu check
    Given menu item "<id>" and "<text>" and "<url>"
    When find menu element by id
    And click menu item
    Then check text
    And check url

    Examples:
            |    id        |        text  |                url                   |
            | item_booking | Бронирование | http://127.0.0.1:8080/booking        |
            | item_contact | Контакты     | http://127.0.0.1:8080/booking#footer |

    Scenario: Check dateId element and set value
      Given driver to date In
      When insert text to dateIn input
      Then check the text of the DateIn input

    Scenario: Check dateOut element and set value
      Given driver to dateOut
      When insert text to dateOut input
      Then check the text of the DateOut input

    Scenario: Check aPlaces element and set value
      Given driver ta aPlaces
      When insert text to aPlaces input
      Then check the text of the aPlaces input

    Scenario: Check cPlaces element and set value
      Given driver to cPlaces
      When insert text to cPlaces input
      Then check the text of the cPlaces input