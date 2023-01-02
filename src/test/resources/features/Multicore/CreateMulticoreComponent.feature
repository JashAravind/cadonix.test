Feature: Create Multicore components

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with InReview status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with status 'IN REVIEW' is created successfully
    When User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with Approved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with status 'APPROVED' is created successfully
    When User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with UnApproved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with status 'UNAPPROVED' is created successfully
    When User selected 'multicore' from componentDB
    And User searches 'multicore' component using 'partnumber'
    Then User verified the component 'multicore' is added successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with Included billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with billtype 'INCLUDED' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with Excluded billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with billtype 'EXCLUDED' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with Consumable billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with billtype 'CONSUMABLE' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with Investment billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with billtype 'INVESTMENT' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created when we enter mandatory details only
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with referencepartnumber 'RandomUniqueNumber' and referencecompany 'TestCompany' only is created

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component cannot be created when we donot enter mandatory details referencepartnumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with referencepartnumber '' and referencecompany 'TestCompany' only is created
    Then Verify error message is displayed for mandatory field 'referencepartnumber' for component 'seal'

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component cannot be created when we donot enter mandatory details referencecompany
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with referencepartnumber 'RandomUniqueNumber' and referencecompany '' only is created
    Then Verify error message is displayed for mandatory field 'referencecompany' for component 'seal'

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with refrencetype manufacturer
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with additionalreferencetype 'Manufacturer' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with refrencetype supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with additionalreferencetype 'Supplier' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with refrencetype crossref
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with additionalreferencetype 'CrossRef' is created successfully

  @MulticoreComponentDB
  @CreateMulticoreComponent
  Scenario: Test verifies a Multicore component can be created with all refrencetype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'multicore' from componentDB
    Then 'multicore' component with additionalreferencetype 'Manufacturer,Supplier,CrossRef' is created successfully