@regression @hfb
Feature: Verify context menu
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"
    And 'connector' list is initialized

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies Inspect functionality on connector
    And User try operation 'inspect' for connector
    Then User verifies the connector details window is opened successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies Delete functionality on connector
    And User try operation 'delete' for connector
    Then User verifies the connector '0' is deleted successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

#  @VerifyConnector @VerifyConnectorContextMenu --TODO--This scenario is not complete yet
#  Scenario: Test verifies ResetLabels functionality on connector
#    And 'connectorplug' component with index '0' is opened
#    And user enters description in connector details
#    And Submit connector
#    Then User verifies the connectordescription is added successfully
#    And User verifies reset labels functionality


  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ToggleConnectorImage functionality on connector
    Then User verifies 'connector' image is visible
    When User try operation 'Toggle Connector Image' for connector
    Then User verifies the 'connector' image is toggled successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ToggleTerminalImage functionality on connector
    And 'connectorplug' component with index '0' is opened
    And GetCavityDetails window is opened
    And Cavity is updated with terminal image
    And Submit connector
    Then User verifies the 'terminal' image is toggled successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowToLocations functionality on connector
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And wire table data is updated
    And user sets visibility of connector table layout to "Yes"
    And Submit connector
    When User try operation 'Show To Locations' for connector
    Then User verify 'wire' destination is displayed successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowHideWireFan functionality on connector
    And 'connectorplug' component with index '0' is opened
    And user sets visibility of connector table layout to "Yes"
    And Submit connector
    Then User verifies the WireFan is ShownHidden successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowHideUnusedCavities functionality on connector
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    Then User verifies the UnusedCavities are ShownHidden successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ShowHideUnusedCavities with EntryPort functionality on connector
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And user sets visibility of connector table layout to "Yes"
    And Submit connector
    Then User verifies the UnusedCavities with EntryPort are ShownHidden successfully
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies ChangeNode functionality on connector
    And User try operation 'Change Node' for connector
    Then User verifies the connector node is moved successfully

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies AutoArrange functionality on connector
    Then User verifies the view is autoarranged successfully

  @VerifyConnector @VerifyCavityTableContextMenu
  Scenario: Test verifies addWire functionality in context menu for cavitytable
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    And User try operation 'Add Wire' for cavitytable
    Then User verifies the wire is added successfully

  @VerifyConnector @VerifyCavityTableContextMenu
  Scenario: Test verifies swapwire functionality in context menu for cavitytable
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    And User try operation 'Swap Wire' for cavitytable
    Then User verifies the wire is swapped successfully

  @VerifyConnector @VerifyCavityTableContextMenu
  Scenario: Test verifies deletewire functionality in context menu for cavitytable
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    And User try operation 'Delete Wire' for cavitytable
    Then User verifies the wire is deleted successfully

  @VerifyConnector @VerifyCavityTableContextMenu
  Scenario: Test verifies ShowWirePath functionality in context menu for cavitytable
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And wire table data is updated
    And Submit connector
    And User try operation 'Show Wire Path' for cavitytable
    Then User verifies the wirepath is shown successfully

  @VerifyConnector @VerifyCavityTableContextMenu
  Scenario: Test verifies CavityProperties functionality in context menu for cavitytable
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    And User try operation 'Cavity Properties' for cavitytable
    Then User verifies cavitytable is opened successfully

  @VerifyConnector @VerifyCavityTableContextMenu
  Scenario: Test verifies AddDuplicateCavity functionality in context menu for cavitytable
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    And Submit connector
    And User try operation 'Add Duplicate Cavity' for cavitytable
    And 'connectorplug' component with index '0' is opened
    Then User verifies duplicate wire is added to cavity successfully

  @VerifyConnector @VerifyNodeContextMenu
  Scenario: Test verifies connector can be added from context menu of node
    And 'node' list is initialized
    And user opens context menu for node '0'
    Then user verifies connector can be added from context menu of node successfully

  @VerifyConnector @VerifyNodeContextMenu
  Scenario: Test verifies connector can be added by selecting linkpart from context menu of node
    And 'node' list is initialized
    And User try operation 'Link Parts' for node
    And User selects component 'Connector' on linkparts window
    And User selects connector from searchparts window
    And Submit connector
    Then Verify 'Connector' is added successfully on harness
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully