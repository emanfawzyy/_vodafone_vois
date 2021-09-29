Feature: test navigate functionality

  @Regression
    @aa
  Scenario Outline: After login user can navigate from admin to user management and users
    Given  the user in home page
    When  Enter <username> and <password> and click on login button
    And navigate to admin
    And navigate on user management to users
    Then  users page open successfully
    Examples:
      | username | password   |
      | "Admin" | "admin123" |

