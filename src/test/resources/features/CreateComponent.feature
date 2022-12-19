Feature: Create components

  @CreateComponent
  Scenario: Test verifies a wire component can be created with InReview status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with status 'IN REVIEW' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created with Approved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with status 'APPROVED' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created with UnApproved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with status 'UNAPPROVED' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created with Included billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with billtype 'INCLUDED' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created with Excluded billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with billtype 'EXCLUDED' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created with Consumable billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with billtype 'CONSUMABLE' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created with Investment billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with billtype 'INVESTMENT' is created successfully

  @CreateComponent
  Scenario: Test verifies a wire component can be created when we enter mandatory details only
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with referencepartnumber 'RandomUniqueNumber' and referencecompany 'TestCompany' only is created

  @CreateComponent
  Scenario: Test verifies a wire component cannot be created when we donot enter mandatory details referencepartnumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with referencepartnumber '' and referencecompany 'TestCompany' only is created
    Then Verify error message is displayed for mandatory field 'referencepartnumber' for component 'wire'

  @CreateComponent
  Scenario: Test verifies a wire component cannot be created when we donot enter mandatory details referencecompany
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'wire' from componentDB
    Then 'Wire' component with referencepartnumber 'RandomUniqueNumber' and referencecompany '' only is created
    Then Verify error message is displayed for mandatory field 'referencecompany' for component 'wire'