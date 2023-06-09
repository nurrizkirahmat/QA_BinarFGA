@Login @Smoke

Feature: Login
	As a user, i want to login to web secondhand

  @Login001
  Scenario: TC.Log.001.001 - User want to login with valid credential
    #Given User open the browser
    When User click masuk in homepage
    And User fill column email "m@mail.com"
    And User fill column password "123"
    And User click button masuk
    Then User verify in homepage
    Then User close browser

  @Login002
  Scenario: TC.Log.001.002 - User want to login with invalid credential
    Given User open the browser
    When User click masuk in homepage
    And User fill column email "mailmu12@mail.com"
    And User fill column password "1"
    And User click button masuk
    Then User verify login error