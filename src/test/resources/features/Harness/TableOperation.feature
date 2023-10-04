@regression @tableops @hfb
Feature: Table Operation

  Scenario:Test verifies BOM table functionality in Harness drawing
    Given I'm on Arcadia test environment
    And test data config loaded for test identifier test102
    And Navigated to quickstart project
    And harness with name 'Bom Table' is launched successfully
    And based on drawing orchestrator components are created
    And place bom table in drawing
    And Navigated to bom table settings in profile
