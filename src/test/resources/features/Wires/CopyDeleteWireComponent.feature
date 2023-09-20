@regression @quickregression
Feature: Copy and Delete Wire components

  @WireComponentDB
  @CloneWireComponent
  Scenario: Test verifies a wire component can be added as similar
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    And 'Wire' component with status 'IN REVIEW' is created successfully
    And User selected 'wire' from componentDB
    And User searches 'wire' component using 'partnumber'
    And User selects the first component
    And User Adds Similar Component
    And User searches 'wire' component using 'partnumber'
    Then User verified the component 'wire' is added successfully

  @WireComponentDB
  @DeleteWireComponent
  Scenario: Test verifies a wire component can be deleted
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    And 'Wire' component with status 'IN REVIEW' is created successfully
    And User selected 'wire' from componentDB
    And User searches 'wire' component using 'partnumber'
    Then User verified the component 'wire' is added successfully
    When User selects the first component
    And User Deletes the Component
    Then User verified the component is deleted successfully

  @WireComponentDB
  @CloneWireComponent
  Scenario: Test verifies a wire component can be copied
    Given I'm on Arcadia test environment
    And User navigated to componentDB
    And Created DB 'quickstartms'
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    And 'Wire' component with status 'IN REVIEW' is created successfully
    And User selected 'wire' from componentDB
    And User searches 'wire' component using 'partnumber'
    Then User verified the component 'wire' is added successfully
    When User selects the first component
    And User Copies the Component for DB 'quickstartms'
    And Use Verifies the component 'wire' is copied successfully
