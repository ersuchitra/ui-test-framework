Feature: Login Feature
  Verify if user is able to Login in to the site

    
    @fablogin
    Scenario: Successful Login to FAB
    Given user in signin page
    When user in Loginpage
    And user enters the credential
    Then user able to login successfully
    
    @FailureLogin @login @regression
    Scenario: Failure Login to Dev Services
    Given user is in homepage
    When user navigates to Loginpage
    And user enters the credential
    Then user not able to login successfully
    
  
    
    
    