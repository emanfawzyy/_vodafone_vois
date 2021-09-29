Feature:test register functionality

  @Regression
 Scenario Outline:Delete user
    Given  the user in home page
    When Enter <username> and <password> and click on login button
    And navigate to admin
    And navigate on user management to users
    And Check on check box
    And Click on delete button
    Then Click on ok button to delete
    Examples:
      | username | password   |
      | "Admin" | "admin123" |










