Feature: ClickUp API test feature
  Scenario: Create new folder in ClickUp space
    Given The space exists and contains correct info
    When I create "New List" in the folder
    And I verify that "New List" name is correct
    And I create "New Task" in the new list
    Then I verify that "New Task" name is correct
    