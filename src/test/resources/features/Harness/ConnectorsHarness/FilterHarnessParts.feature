@regression @hfb
Feature: Filter harness parts
  Background: User is Logged In
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test8
    And Navigated to selected componentDB
    And User selected 'connector' from componentDB

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered using partnumber while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'partNumber'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered using cavity while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'cavity'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered using family while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'family'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered using supplier while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'supplier'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with HousingGender value Male while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'housinggender' with value 'MALE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with HousingGender value Female while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'housinggender' with value 'FEMALE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with HousingGender value Unset while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'housinggender' with value 'UNSET'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with TerminalGender value MALE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'terminalgender' with value 'MALE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with TerminalGender value FEMALE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'terminalgender' with value 'FEMALE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Type value Sealed while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Type' with value 'SEALED'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Type value Unsealed while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Type' with value 'UNSEALED'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value BLACK while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'BLACK'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value BLUE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'BLUE'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value BROWN while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'BROWN'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value CYAN while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'CYAN'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value GRAY while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'GRAY'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value GREEN while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'GREEN'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value LIGHTBLUE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'LIGHT BLUE'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value NATURAL while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'NATURAL'
    And User closes the searchparts window
    And User exits the drawing page

  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value ORANGE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'ORANGE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value PINK while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'PINK'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value PURPLE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'PURPLE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value RED while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'RED'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value WHITE while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'WHITE'
    And User closes the searchparts window
    And User exits the drawing page


  @FilterConnectorHarness
  Scenario: Test verifies a connector can be filtered with Colour value YELLOW while creating bundles
    And Navigated to quickstart project
    And harness with name 'dynamic connectorFilter' is launched successfully
    And based on drawing orchestrator components are created
    Then Verify user can filter 'connector' using 'Colour' with value 'YELLOW'
    And User closes the searchparts window
    And User exits the drawing page
