Feature: Profile Settings 

Scenario: Edit Profile

Given go to profile settings page
Then click on edit profile
Then edit the details of name
Then click on save profile
Then change the password


Scenario: Login with new password

Given logout of the portal
Given user enters the credentials
|Email Id| bharathsb43@gmail.com |
|Password| #abcd1234 |
Then click on log in button