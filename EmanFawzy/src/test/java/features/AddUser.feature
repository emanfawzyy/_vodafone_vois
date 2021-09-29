Feature:test register functionality

  @Regression
  Scenario Outline:Add user
    Given  the user in home page
    When Enter <username> and <password> and click on login button
    And navigate to admin
    And navigate on user management to users
    And click on add button
    And User Enter Data
    Examples:
      | username | password   |
      | "Admin" | "admin123" |
#    And User enter Data "<User Role>", enter "<Employee Name>",enter "<Username>", enter "<Status>" ,"<Password>" and enter "<Confirm Password>"
#    Then user Click on save button








