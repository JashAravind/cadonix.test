Feature: Post Migration

  Scenario: Test verifies to open all task in given instance.
    Given I'm on Arcadia test environment
    And User delete all old files from the default download folder
    And Navigated to project home page
    Then Open all available projects and tasks in given instance