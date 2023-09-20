@regression @quickregression
Feature: Create seals components

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seals component can be created with InReview status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with status 'IN REVIEW' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seals component can be created with Approved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with status 'APPROVED' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with UnApproved status
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with status 'UNAPPROVED' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with Included billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with billtype 'INCLUDED' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with Excluded billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with billtype 'EXCLUDED' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with Consumable billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with billtype 'CONSUMABLE' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with Investment billtype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with billtype 'INVESTMENT' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created when we enter mandatory details only
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with referencepartnumber 'RandomUniqueNumber' and referencecompany 'TestCompany' only is created
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component cannot be created when we donot enter mandatory details referencepartnumber
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with referencepartnumber '' and referencecompany 'TestCompany' only is created
    Then Verify error message is displayed for mandatory field 'referencepartnumber' for component 'seal'

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component cannot be created when we donot enter mandatory details referencecompany
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with referencepartnumber 'RandomUniqueNumber' and referencecompany '' only is created
    Then Verify error message is displayed for mandatory field 'referencecompany' for component 'seal'

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with refrencetype manufacturer
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with additionalreferencetype 'Manufacturer' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with refrencetype supplier
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with additionalreferencetype 'Supplier' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with refrencetype crossref
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with additionalreferencetype 'CrossRef' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully

  @SealComponentDB
  @CreateSealComponent
  Scenario: Test verifies a Seal component can be created with all refrencetype
    Given I'm on Arcadia test environment
    And Navigated to selected componentDB
    And User selected 'seal' from componentDB
    Then 'seal' component with additionalreferencetype 'Manufacturer,Supplier,CrossRef' is created successfully
    When User selected 'seal' from componentDB
    And User searches 'seal' component using 'partnumber'
    Then User verified the component 'seal' is added successfully