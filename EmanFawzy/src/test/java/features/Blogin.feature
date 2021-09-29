Feature: test login functionality

  @Regression
  Scenario Outline: login with valid email and valid password
    Given the user in home page
    When Enter <username> and <password> and click on login button
    Then user successfully login
    Examples:
      | username | password   |
      | "Admin" | "admin123" |

#  @Login
#  Scenario Outline: login with valid email and invalid password
#    Given the user in home page
#    When Enter <username> and <password> and click on login button
#    Then user failed login
#    Examples:
#      | username   | password   |
#      | "Admin" | "admin" |



      # example 1 valid Scenario valid user name and valid password
      # example 1 invalid Scenario valid user name  and invalid password
      # example 1 invalid Scenario invalid user name and valid password
      # example 1 invalid Scenario valid user name and invalid password
      # example 1 invalid Scenario valid user name and valid password
      # example 1 invalid Scenario invalid user name and invalid password







