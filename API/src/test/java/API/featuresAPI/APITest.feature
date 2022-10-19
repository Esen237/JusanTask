@APITest
Feature: Api requests


  Scenario: Get List users
    Given Perform method GET to get list users that contains "https://reqres.in/img"

  Scenario: Get List users choosing page
    Given Perform method GET to get list users and choose page "2"

  Scenario: Get List users choose page -1
    Given Perform method GET to get list users choosing "-1" page and should get 1 started id

  Scenario: Get List users with uncorrected params
    Given Perform method GET to get list users and choose page "90" and should get page 90


  Scenario: Get List users with error
    Given Perform method GET to get list users with error and get 404


  Scenario: Get List users with no exist page
    Given Perform method GET to get list users and choose page "90" and should get "[]"


  Scenario: Get Single user
    Given Perform method GET to get single user id "2" and get id 2 user


  Scenario: Get Single user with no exist id, but valid
    Given Perform method GET to get single user id "90" and get nothing


  Scenario: Get Single user with no valid id
    Given  Perform method GET to get single user not valid id "d" and get nothing


  Scenario: Get Single Resource
    Given Perform method GET to get single resource with not exist id "23"


  Scenario: Get single Resource
    Given Perform method GET to get single resource by id "2" and get "year"


  Scenario: Get List Resource
    Given Perform method GET to get List resource that contain "name"


  Scenario: Update user using PUT
    Given Perform method PUT to update user by id "2"

  Scenario: Update user using PUT
    Given Perform method PUT to update users name and job than get 200 code


  Scenario: Update user using PUT
    Given Perform method PUT to update users name and job than get 200 code using id "90"

  Scenario: Update user using PUT
    Given Perform method PUT to update users name and job than get 200 code using not valid id "d"


  Scenario: Register user by Post
    Given Perform method POST to register user and get code 200

  Scenario:  Register user by Post
    Given Perform method POST to register user with not correct data and get code 400, get massage "Note: Only defined users succeed registration"

  Scenario: Register user by Post
    Given Perform method POST to register user using not valid data and get 400 code, get "Note: Only defined users succeed registration"

  Scenario: Register user by Post
    Given Perform method POST to register user with no password field and get 400 code, get "Missing password"

  Scenario: Register user by Post
    Given Perform method POST to register user with empty JSon and get 400 code, get "Missing email or username"

  Scenario: Create user by Post
    Given Perform method POST to create user and get 201 code


  Scenario: Create user by Post
    Given Perform method POST to create user with not all field and get 201 code


  Scenario: Create user by Post
    Given Perform method POST to create user with no fields and get 201 code


  Scenario: Create user by Post
    Given Perform method POST to create user with empty body and get 201 code


  Scenario: Create user by Post
    Given Perform method POST to create user to get time

Scenario: Delete user
  Given Perform method DELETE to delete user id "2" and get 204 code

  Scenario: Delete user
    Given Perform method DELETE to delete exist user id "2" and get 204 code

  Scenario: Delete user
    Given Perform method DELETE to delete no exist user id "90" and get 204 code

  Scenario: Delete user
    Given Perform method DELETE to delete not valid  user id "d" and get 204 code

  Scenario: Delete user
    Given Perform method DELETE to create and delete user and get 204 code
