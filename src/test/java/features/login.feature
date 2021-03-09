Feature: Login into application

Scenario Outline: Positive test validating login
Given Initialize the browser with firefox
And Navigate to "http://qaclickAcademy.com" site
And Click on Login link in home page to land on source sign in page
When user enters <username> and <password> and logs in
Then Verify that user is sucessfully logged in 

Examples:
|username           |password      |
|test99@gmail.com   |123456        |
|test12@gmail.com   |3636897       |

