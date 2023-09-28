@regression @quickregression @hfb
Feature:Node Operations

  Scenario: Test verifies task can be created in metric by changing in profile
    And  Navigated to General task units
    And  Changing General units to 'metric'
    And Navigated to bundle default display
    Then Reset to defaults

  Scenario:Test verifies the functionality change node
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test107
    And Navigated to quickstart project
    And harness with name 'Change node test' is launched successfully
    And based on drawing orchestrator components are created
    And user changes connector from one node to another node
    And user sets label 'node child element' to "Show"
    Then verify change node has been performed as expected
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Change node test' successfully

  Scenario: Test verifies the functionality move end
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness with name 'Move end test' is launched successfully
    And user moves one end of bundle to another bundle
    And user sets label 'bundle length' to 'Show'
    Then verify length of the bundle is been updated as expected
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Move end test' successfully

  Scenario: Test verifies the functionality move end with NTS value and virtual node components
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And harness with name 'Move end test' is launched successfully
    And user moves one end of bundle to another bundle by adding some virtual components
    And user sets label 'bundle length' to 'Show'
    Then verify length of the bundle is been updated as expected when placing virtual components
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Move end test' successfully

  Scenario: Test verifies the functionality move relative
    Given I'm on Arcadia test environment
    And Navigated to quickstart project
    And User imports harness 'Move relative'
    And user navigated to newly created harness
    And User move the skeleton relatively in harness
    Then verify skeleton can be move relatively without moving frame
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Schematic Harness' successfully