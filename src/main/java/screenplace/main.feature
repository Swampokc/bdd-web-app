Feature: Wep-app Hotel Test

  Scenario: Try to connect to driver

    Given value path to driver "/Users/klass/Desktop/VIII семестр/4. Верификация/bdd web-app/chromedriver.exe"
    And create driver
    When get driver "http://127.0.0.1:8080/booking"
    Then check driver is not null
    And check title is "Бронирование номеров"

  Scenario Outline: Menu check
    Given menu item <"id"> and <"text"> and <"url">
    When find element by id
    And click menu item
    Then check text
    And check url

    Examples:
            | id           | text         | url                                  |
            | item_booking | Бронирование | http://127.0.0.1:8080/booking        |
            | item_contact | Контакты     | http://127.0.0.1:8080/booking#footer |