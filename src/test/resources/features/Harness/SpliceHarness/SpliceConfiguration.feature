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