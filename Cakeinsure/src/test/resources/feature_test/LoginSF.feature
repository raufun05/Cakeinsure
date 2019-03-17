@LoginSF
Feature: LoginSF
  As an user of the application
  I want to login salesforce webside using valid credentials
  In order to test blog.
 

 Scenario: Successful Login
  
  	Given I am on the application home page on URL "https://login.salesforce.com"
    Given I login in with user name "interviewtest@cakeinsure.com" and password "InterviewCak3!"
 
 
  Scenario: Successful Create Post
  
  	
    Given I Navigate to "Marketing" Blog
    When I Create Multiple Post
    
    |name   |categorie|content       |
    |Game 1	|Soccer 1 | Play Soccer 1|
    |Game 2	|Soccer 2 | Play Soccer 2|
    |Game 3	|Soccer 3 | Play Soccer 3|
    
    
    
    Then I verify Multiple Post is created
    
    |name   |categorie|content       |
    |Game 1	|Soccer 1 | Play Soccer 1|
    |Game 2	|Soccer 2 | Play Soccer 2|
    |Game 3	|Soccer 3 | Play Soccer 3|
    
    
   Scenario: Successful View Post
   
    When I click Multiple Post I view all post
    |name   |categorie|content       |
    |Game 1	|Soccer 1 | Play Soccer 1|
    |Game 2	|Soccer 2 | Play Soccer 2|
    |Game 3	|Soccer 3 | Play Soccer 3|
    
     
   Scenario: Successful Delete Post
   
    When I click Delete Post I Delete all post
    |name   |categorie|content       |
    |Game 1	|Soccer 1 | Play Soccer 1|
    |Game 2	|Soccer 2 | Play Soccer 2|
    |Game 3	|Soccer 3 | Play Soccer 3|