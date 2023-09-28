@spliceConfiguration @regression @hfb
  Feature: Splice Configuration


    Scenario:Test verifies able to configure new splice technology in profile
      Given I'm on Arcadia test environment
      And  Navigated to profile splice configuration
      And add new splice configuration in profile
      And Navigated to material  gauge editor
      Then verify able to modify material and gauge
      And Navigated to selected componentDB
      And User selected 'splice' from componentDB
      Then 'Splice' component with billtype 'EXCLUDED' is created and part number as 'automationTestUltra'
      And add splice details to created splice
      Then verify splice configuration of Aside and Bside is calculated as per the gauge editor csa

    Scenario: Test verifies able to create harness and match splice configuration without passing wires into the splice
      Given I'm on Arcadia test environment
      And test data config loaded for test identifier test11
      And Navigated to quickstart project
      And harness with name 'Splice configuration' is launched successfully
      And based on drawing orchestrator components are created
      And splice,heatshrink from context menu options
      Then verify able to view update splice,heatshrink configuration popup
      Then verify able to throw error 'No wires passing through the Splice SP-001'
      And User exits the drawing page
      And User deletes Harness 'Splice configuration' successfully

    Scenario: Test verifies able to create harness and match splice configuration by passing wires into the splice in different material
      Given I'm on Arcadia test environment
      And Navigated to quickstart project
      And User imports harness 'splice different wire material'
      And user navigated to newly created harness
      And splice,heatshrink from context menu options
      Then verify able to view update splice,heatshrink configuration popup
      Then verify able to throw error 'Wire CSA value exceeds the maximum CSA range for the Splice SP-001 in AutomationTest technology.'
      And User exits the drawing page
      And User deletes Harness 'SchematicHarness' successfully

      Scenario: Test verifies able to import harness and match physical splice accurately by giving accurate inputs
        Given I'm on Arcadia test environment
        And Navigated to selected componentDB
        And User selected 'splice' from componentDB
        Then 'Splice' component with billtype 'EXCLUDED' is created and part number as 'automationTestPhysical'
        Then add splice details to created physical splice
        And Navigated to quickstart project
        And User imports harness 'physical splice'
        And user navigated to newly created harness
        And splice,heatshrink from context menu options
        Then verify able to view update physical splice configuration popup
        Then verify able to suggest created splice partnumber
        And user sets label 'node' to "hide"
        And user sets label 'bundle' to "hide"
        And user sets label 'connector cavity table' to "hide"
        And user sets label 'splice cavity table' to "hide"
        And user sets label 'splice cavity table part number' to "show"
        Then Verify suggested splice partnumber has been updated in harness drawing
        And User exits the drawing page
        And Accept alert
        And User deletes Harness 'SchematicHarness' successfully

        Scenario: Test verifies able to import harness and ability to suggest heat shrink as per the splice configuration
          Given I'm on Arcadia test environment
          And Navigated to selected componentDB
          And User selected 'splice' from componentDB
          Then 'Splice' component with billtype 'EXCLUDED' is created and part number as 'automationTestPhysicaltest3'
          Then add splice details to created physical splice
          And Navigated to quickstart project
          And User imports harness 'physical splice'
          And user navigated to newly created harness
          And 'bundle' list is initialized
          And Gather bundle diameter of the bundles
          And splice,heatshrink from context menu options
          Then verify able to view update physical splice configuration popup
          Then verify able to suggest created splice partnumber and heat shrink