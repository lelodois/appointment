Feature: Appointments and your officers

  Scenario: Save many
    Then delete all
    Given I want save 100 appointments
    When When found 100 appointments
    When must have 100 appointments available

  Scenario: Saving and attach one
    Then delete all
    Given I want save 1 appointments
    When When found 1 appointments
    Then Attach one available appointment to "Marcelina"
    When must have 0 appointments available

  Scenario: Saving and attach two
    Then delete all
    Given I want save 2 appointments
    When When found 2 appointments
    Then Attach one available appointment to "Joana-Strawin"
    Then Attach one available appointment to "Francis-Martin"
    When must have 0 appointments available

  Scenario: Saving two and attach one
    Then delete all
    Given I want save 2 appointments
    When When found 2 appointments
    Then Attach one available appointment to "Yuri-Alberto"
    When must have 1 appointments available
