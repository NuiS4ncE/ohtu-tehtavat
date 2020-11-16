Feature: A new user account can be created if a proper unused username and password are given
  Scenario: user can not login with incorrect password
    Given command login is selected
    When  correct username "pekka" and false password "lol" are entered
    Then  system will respond with "wrong username or password"

  Scenario: nonexistent user can not login to
    Given command login is selected
    When  false username "akkep" and correct password "kek" are entered
    Then  system will respond with "wrong username or password"

  Scenario: creation is successful with valid username and password
    Given command new is selected
    When  username "jees" and password "juus1234" are entered
    Then  system will respond with "new user registered"

  Scenario: creation fails with already taken username and valid password
    Given command new is selected
    When  username "pekka" and password "what" are entered
    Then  system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid password
    Given command new is selected
    When too short username "wa" and correct password "ebun" are entered
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and too short password
    Given command new is selected
    When  correct username "ebin" and too short password "wat" are entered
    Then  system will respond with "new user not registered"

  Scenario: creation fails with valid username and password long enough but consisting of only letters
    Given command new is selected
    When  correct username "kak" and no-number password "kekekekekek" are entered
    Then  system will respond with "new user not registered"

  Scenario: can login with successfully generated account
    Given user "eero" with password "salainen1" is created
    And   command login is selected
    When  username "eero" and password "salainen1" are entered
    Then  system will respond with "logged in"
