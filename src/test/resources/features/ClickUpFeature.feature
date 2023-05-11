Feature: ClickUp API test feature
  Scenario: Add a new task after creating folder and list
    Given The space exists and contains correct info
    When I create "New Folder" in space
    And I create "New List" in the folder
    And I verify that "New List" name is correct
    And I create "New Task" in the new list
    Then I verify that "New Task" name is correct and remove it
