# Package & File Name Description
Feature: User Related

  in this feature, we have a User data object

  # Use Case
  Scenario: End user enter the user page
    # Arrange (parameter)
    Given End user pass the page request
    # Act (signature)
    When Query with page request
    # Assert
    Then User list size should greater than 0

  # Use Case
  Scenario: End user query by id
    # Arrange (parameter)
    Given End user pass id 462
    # Act (signature)
    When Query by id 462
    # Assert
    Then User id should be 462

  # Use Case
  Scenario: End user query by first name
    # Arrange (parameter)
    Given End user pass first name "Cassell"
    # Act (signature)
    When Query by first name "Cassell" and page request
    # Assert
    Then User list size should greater than 0

  # Use Case
  Scenario: End user query by phone
    # Arrange (parameter)
    Given End user pass phone "+886 987 123 456"
    # Act (signature)
    When Query by phone "+886 987 123 456"
    # Assert
    Then User id should not null

  # Use Case
  Scenario: End user add user with info
    # Arrange (parameter)
    Given End user pass id 222
    And End user pass first name "Cassell"
    And End user pass last name "Hsu"
    And End user pass age 18
    And End user pass gender "BOY"
    And End user pass phone "+886 987 123 456"
    And End user pass e-mail "aaa@aaa.xyz"
    # Act (signature)
    When Add
    # Assert
    Then User id should not null
    But End user first name should be "Cassell"
    But End user last name should be "Hsu"
    But End user age should be 18
    But End user gender should be "BOY"
    But End user e-mail should be "aaa@aaa.xyz"
    But End user phone should be "+886 987 123 456"

  # Use Case
  Scenario: End user modify user age by id
    # Arrange (parameter)
    Given End user pass id 222
    And End user pass age 20
    # Act (signature)
    When Modify age 20 by id 222
    # Assert
    Then User id should be 222
    But End user age should be 20

  # Use Case
  Scenario: End user remote user by id
    # Arrange (parameter)
    Given End user pass id 222
    # Act (signature)
    When Remove by id 222
    # Assert
    Then Verify id 222 should be null
