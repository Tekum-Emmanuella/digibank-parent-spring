Feature: Transaction Compliance Validation
  As a bank compliance officer
  I want to validate transaction amounts
  So that transactions exceeding the limit are flagged

  Scenario: Valid transaction amount within limit
    Given a transaction amount of 5000.0
    When the amount is validated
    Then the validation should return true

  Scenario: Valid transaction amount at limit boundary
    Given a transaction amount of 10000.0
    When the amount is validated
    Then the validation should return true

  Scenario: Invalid transaction amount exceeding limit
    Given a transaction amount of 15000.0
    When the amount is validated
    Then the validation should return false

  Scenario: Invalid transaction amount is null
    Given a null transaction amount
    When the amount is validated
    Then the validation should return false

  Scenario: Valid zero transaction amount
    Given a transaction amount of 0.0
    When the amount is validated
    Then the validation should return true
