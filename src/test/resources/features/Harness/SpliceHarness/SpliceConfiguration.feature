@spliceConfiguration
  Feature: Splice Configuration

    Scenario:Test verifies able to configure new splice technology in in profile
      Given I'm on Arcadia test environment
      And  Navigated to profile splice configuration
      And add new splice configuration in profile
      And Navigated to material  gauge editor
      Then verify able to modify material and gauge
      And Navigated to selected componentDB
      And User selected 'splice' from componentDB
      Then 'Splice' component with billtype 'EXCLUDED' is created
      And add splice details to created splice

