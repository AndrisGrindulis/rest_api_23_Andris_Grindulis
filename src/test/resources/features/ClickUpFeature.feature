Feature: ClickUp API test feature
  Scenario: Add a new task after creating folder and list
    Given The space exists and contains correct info
    When I create "Jaunu mapi" in space
    And I create "Jaunu listu" in the folder and verify it
    And I create "Jaunu uzdevumu" in the new list
    Then I verify that "Jauna uzdevuma" name is removed
