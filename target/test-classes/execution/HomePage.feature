Feature: Home page functionality

@sanity
Scenario: verify title of page
Given user is at the landing page
Then page title should contains "Shopping"

@functional
Scenario: verify cart icon
Given user is at the landing page
Then cart icon should get display

@regression
Scenario: checkout deals section
Given user is at the landing page
When user clicks on fashion link
Then user should redirect to fashion page

@adhoc
Scenario: login to application
Given user is at the landing page
When user enters the username as "8983258301"
And user enters password as "Sagar@1996"



