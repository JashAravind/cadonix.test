@regression @hfb
Feature: General Harness Connector Validations
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test10

  @VerifyWireMacrosTag
  Scenario: Test verifies macros tag while adding wire on connector in harness
    And Navigated to GeneralMacros page
    And 'wire' macros tags are extracted successfully
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And wire is added to cavity
    Then User verifies the tags for 'wire'

  @VerifyConnector
  Scenario: Test verifies allterminalpn shown in cavity table searchdetails on connector matches componentdb
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'connector cavity table' to "Show"
    And 'connectorplug' component with index '0' is opened
    And GetCavityDetails window is opened
    Then Verify 'All' terminals are shown in cavity table searchdetails

  @VerifyConnector @VerifyConnectorContextMenu
  Scenario: Test verifies Connector Label context menu functionality on connector
    And Navigated to GeneralMacros page
    And 'custom label' macros tags are extracted successfully
    And custom label macros tags are updated with 'customvalues'
    And Navigated to quickstart project
    And harness with name 'connectorValidator' is launched successfully
    And based on drawing orchestrator components are created
    And 'connectorplug' component with index '0' is opened
    And value of 'connectorid' is extracted successfully
    And user enters description in connector details
    And Submit connector
    And User try operation 'connector label' for connector
    Then User verify 'connector' labels are displayed as expected
    And User exits the drawing page
    And User deletes Harness 'connectorValidator' successfully
    When Navigated to GeneralMacros page
    And custom label macros tags are updated with 'initialvalues'

#  @VerifyConnector @ConnectorEditor
#  Scenario: Test verifies Connector can be added from connector editor ----TODO--This scenario is not complete yet
#    And Navigated to quickstart project
#    And harness with name 'connectorValidator' is launched successfully
#    And based on drawing orchestrator components are created
#    And user sets label 'connector cavity table' to "Show"
#    And 'connector' list is initialized
#    And connector editor is opened
#    And user enters details to add connector
#    And User exits the drawing page
#    And User deletes Harness 'connectorValidator' successfully