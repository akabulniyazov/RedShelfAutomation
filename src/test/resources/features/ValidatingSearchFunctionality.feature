Feature: Validating Search Functionality

  Scenario: Validating Search functionality by searching title name
    Given user navigates to RedShelf application
    When user searches for "purple cow" book
    Then user validates search results contains "purple cow" keyword

  Scenario: Validating Search functionality by searching invalid title name
    Given user navigates to RedShelf application
    When user searches for "!@#$" book
    Then user validates error message "Oh No! Looks like we don't have the eBook you're searching for."

  Scenario: Validating Search functionality searching with ISBN number
    Given user navigates to RedShelf application
    When user searches for "purple cow" book
    And user click on book and stores ISBN number
    And user searches for stored ISBN number
    Then user validates "purple cow" book in search result

  Scenario: Validating Search functionality with space before and after of title name
    Given user navigates to RedShelf application
    When user searches for "    purple cow      " book
    Then user validates search results contains "purple cow" keyword

  Scenario: Validating Search functionality with searching author name
    Given user navigates to RedShelf application
    When user searches for "Seth Godin" book
    Then user validates search results contains "Seth Godin" keyword
