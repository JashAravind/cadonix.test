@regression @BundleOps  @quickregression
Feature: Bundle Operation
  Background: User is Logged In
    Given I'm on Arcadia test environment

  Scenario: Test verifies task can be created in metric by changing in profile
    And  Navigated to General task units
    And  Changing General units to 'metric'
    And Navigated to bundle default display
    Then Reset to defaults

  Scenario: Test verifies add bend and remove bend in bundle
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 19.04mm,46.05mm 19.04mm,46.05mm 149.87mm,46.05mm' through command line in harness
    And 'bundle' list is initialized
    And user add bend using command 'addbundlebend' through command line in harness
    And 'node' list is initialized
    Then check able to move one end of bundle to bend or not
    Then check able to remove bend or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario:Test verifies to rejoin the bundles
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 19.04mm,46.05mm 19.04mm,46.05mm 149.87mm,46.05mm' through command line in harness
    And 'bundle' list is initialized
    And user sets label 'Bundle name' to "show"
    And user tries to place node on bundle
    And 'node' list is initialized
    Then check able to rejoin the bundle or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario:Test verifies to remove all bends in bundle
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 12.01mm,26.45mm 216.56mm,26.45mm 216.56mm,200.1mm 12.46mm,200.1mm 12.46mm,50.36mm 198.74mm,50.36mm 198.74mm,164.02mm 37.27mm,164.02mm 37.27mm,63.44mm 174.38mm,63.44mm 174.38mm,139.66mm 62.3mm,139.66mm 62.3mm,89.37mm 135.6mm,89.37mm' through command line in harness
    And 'bundle' list is initialized
    And 'node' list is initialized
    And user set all radius
    Then Check bend radius in bundle
    And user try to remove all bends in the drawing
    Then check able to remove all bends or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario:Test verifies bundle break and bundle break rejoin in bundle
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 12.53mm,74.93mm 87.6mm,74.93mm' through command line in harness
    And bundle break is placed on bundle
    And 'bundle' list is initialized
    And 'node' list is initialized
    Then check bundle is broken or not
    And user try to rejoin the bundle break
    Then check bundle break is deleted or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario:Test Verifies bundle break join for two bundles
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 -62.5mm,87.5mm 73.75mm,87.5mm' through command line in harness
    And user tries to draw bundle using command 'freebundle 0 100mm,87.5mm 200mm,87.5mm' through command line in harness
    And 'bundle' list is initialized
    And 'node' list is initialized
    And user tries to join two bundles with bundlebreak
    Then check bundle can be joined two bundles with bundlebreak
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario: Test verifies chain dimension in bundle
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 -62.5mm,87.5mm 73.75mm,87.5mm' through command line in harness
    And 'node' list is initialized
    And user tries to calculate the dimension through chain dimension
    Then verify chain dimension is calculated as expected to the bundle or not
    And user tries to draw bundle using command 'freebundle 0 100mm,87.5mm 200mm,87.5mm' through command line in harness
    And 'node' list is initialized
    And user tries to calculate dimension between two bundles
    Then verify chain dimension is calculated between two bundle or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

    Scenario: Test verifies to scale scenarios in bundle
      And Navigated to General task units
      And Changing General units to 'metric'
      And Navigated to quickstart project
      And harness with name 'Bundle Ops Validator' is launched successfully
      And user tries to draw bundle using command 'freebundle 0 -25.18mm,75.18mm 49.68mm,75.18mm 49.68mm,125.3mm' through command line in harness
      And 'node' list is initialized
      And 'bundle' list is initialized
      And user tries to set length not to scale
      And user sets label 'bundle length' to "show"
      Then check whether set length value is updated or not as NTS
      Then check able to scale or not
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario: Test verifies to scale scenarios in bundle in imperial units
    And Navigated to General task units
    And Changing General units to 'imperial'
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And user tries to draw bundle using command 'freebundle 0 124.93mm,25.25mm 150.39mm,25.25mm 150.39mm,49.69mm' through command line in harness
    And 'node' list is initialized
    And 'bundle' list is initialized
    And user tries to set length not to scale
    And user sets label 'bundle length' to "show"
    Then check whether set length value is updated or not as NTS
    Then check able to scale or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario: Test verifies to bundle content of bundle properties
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And test data config loaded for test identifier test102
    And based on drawing orchestrator components are created
    And 'bundle' list is initialized
    And user sets label 'bundle length' to "show"
    Then verify bundle is in as expected or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario: Test verifies to bundle content on bundle assigned coverings
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And test data config loaded for test identifier test109
    And based on drawing orchestrator components are created
    And 'bundle' list is initialized
    And user sets label 'bundle covering pn' to 'show'
    And user gets the covering list from bundle properties;
    Then verify bundle covering partnumber is in as expected or not in bundle content or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario: Test verifies to bundle content on bundle associated wires
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And test data config loaded for test identifier test102
    And based on drawing orchestrator components are created
    And 'bundle' list is initialized
    Then verify by clicking wire that wires is highlighted in cavity table or not
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully

    Scenario: Test Verifies match bundle properties
      And Navigated to quickstart project
      And harness with name 'Bundle Ops Validator' is launched successfully
      And test data config loaded for test identifier test102
      And based on drawing orchestrator components are created
      And user tries to draw bundle using command 'freebundle 90 18.75mm,15mm 100mm,15mm' through command line in harness
      And 'bundle' list is initialized
      And user sets label 'bundle length' to "show"
      Then check match properties working or not as expected with basic bundle properties
      And User exits the drawing page
      And Accept alert
      And User deletes Harness 'Bundle Ops Validator' successfully

  Scenario: Test Verifies match bundle properties with covering
    And Navigated to quickstart project
    And harness with name 'Bundle Ops Validator' is launched successfully
    And test data config loaded for test identifier test109
    And based on drawing orchestrator components are created
    And user tries to draw bundle using command 'freebundle 90 18.75mm,15mm 100mm,15mm' through command line in harness
    And 'bundle' list is initialized
    And user sets label 'bundle length' to "show"
    Then check match properties working or not as expected with basic bundle properties in covering
    And User exits the drawing page
    And Accept alert
    And User deletes Harness 'Bundle Ops Validator' successfully