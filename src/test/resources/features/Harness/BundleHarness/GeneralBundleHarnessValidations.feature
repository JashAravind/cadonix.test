@Bundle
Feature: Bundle harness general validations

  Background: User is Logged In
    Given I'm on Arcadia test environment
    And Navigated to Harness Bundle Default Display Settings page
    And harness bundle default display settings are updated
    And test data config loaded for test identifier test12
    And Navigated to quickstart project
    And harness with name 'BundleValidator' is launched successfully
    And based on drawing orchestrator components are created
    And user sets label 'bundle' to "Show"
    And 'bundle' list is initialized

  @VerifyBundleHarness
  Scenario: Test verifies colour of shown length matches the colour saved in profile for Bundle Harness
    Then user verifies setLength functionality from context menu
    And user verifies colour of bundle length matches profile

  @VerifyBundleHarness
  Scenario: Test verifies bundle length can be set from bundle details form on Bundle Harness
    Then user verifies setLength functionality from bundle details

  @VerifyBundleHarness
  Scenario: Test verifies bundle name can be hidden from Bundle Harness
    Then user verifies "BundleName" can be hidden from bundle harness successfully

  @VerifyBundleHarness
  Scenario: Test verifies bundle length can be hidden from Bundle Harness
    Then user verifies "BundleLength" can be hidden from bundle harness successfully

  @VerifyBundleHarness
  Scenario: Test verifies pieceid can be hidden from Bundle Harness
    Then user verifies "PieceId" can be hidden from bundle harness successfully

  @VerifyBundleHarness
  Scenario: Test verifies CoveringPN can be hidden from Bundle Harness
    Then user verifies "CoveringPN" can be hidden from bundle harness successfully

  @VerifyBundleHarness
  Scenario: Test verifies CoveringPartDescription can be hidden from Bundle Harness
    Then user verifies "CoveringPartDescription" can be hidden from bundle harness successfully