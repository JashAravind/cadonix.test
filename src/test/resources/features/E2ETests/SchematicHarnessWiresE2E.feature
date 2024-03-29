@E2E  @quickregression @e2e
Feature: Verify schematics harness wires functionality
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to 'Aut_Integration' project
    And User imports base schematic
    And User imports schematic harness
    And user navigated to newly created harness
    And user add the wire table in the new frame adjacent to existing frame

  @VerifySchematicHarnessWires
  Scenario: Verify that wires can be deleted on schematic harness
    Then user verifies wires can be deleted succesfully on schematic harness

  @VerifySchematicHarnessWires
  Scenario: Verify that wires can be exported on schematic harness
    And User delete all old files from the default download folder
    Then User verifies wires can be exported successfully on schematic harness

  @VerifySchematicHarnessWires
  Scenario: Verify that wires can be loaded from schematic on harness wireeditor
    And user loades wires from schematic on harness wireeditor
    Then user verifies wires are loaded from schematic succesfully

  @VerifySchematicHarnessWires
  Scenario: Verify that columns can be hidden and shown on wire editor
    And User moved to wire editor
    Then user verifies columns can be hidden and shown on wire editor

  @VerifySchematicHarnessWires
  Scenario: Verify that wires can be loaded on drawing of schematic harness
    Then User verifies wires can be loaded from schematic on drawing page succesfully

  @VerifySchematicHarnessWires
  Scenario: Verify that wires can be imported from file on schematic harness wire-editor
    And User verifies wires can be imported successfully

  @VerifySchematicHarnessWires
  Scenario: Verify that wires can be synced from schematic on harness left pane
    Then user verifies wires can be deleted succesfully on schematic harness
    When User opens left pane on harness
    Then User schematic data can be synced on harness drawing

  @VerifySchematicHarnessWires
  Scenario: Verify that schematic data can be loaded on connector editor
    And connector editor is opened
    And user loads schematic data on connector editor
    Then user verifies schematic is loaded on connector editor successfully

  @VerifySchematicHarnessWires
  Scenario: Verify tree view functionality on schematic harness left pane
    And user links multicore to schematic harness
    And User opens left pane on harness
    And User expands schematic harness tree
    Then Verify components displayed in expanded schematic harness tree
    And user verifies search view functionality on schematic harness tree view


  @VerifySchematicHarnessWires
  Scenario: Verify sleeve tube and coverings can be successfully updated on schematic harness
    When user updates sleevetube details on schematic harness
    Then verify that coverings are updated successfully on schematic harness

