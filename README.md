# Mobile Automation Practice

This project is designed for automating tests on a mobile application, the WebDriver IO APK. It includes test cases covering navigation on the bottom menu bar, successful sign-up, successful login, and card-swiping functionality.
It's made with Appium for Java Client v9, developed using Appium Server, Appium Inspector and Android Studio Emulator.
## Project Structure

The project is organized into the following directories:

- **Screens:** Contains screen classes representing different sections of the mobile application.
- **Tests:** Contains test classes that execute specified test scenarios.
- **utils/DataProvider:** Contains data providers or utilities for data generation.
- **utils/screens**
- **utils/tests**

## Test Cases

### 1. Navigation on the Bottom Menu Bar

**Description:**
As a precondition, the user should be on the Home screen.

**Steps:**
1. Navigate to each section by tapping their respective icons on the bottom menu bar.
2. After tapping on the respective menu section, assertions should be made to check all elements on the respective sections are correctly displayed (Check visibility and properties).

### 2. Successful Sign Up

**Description:**
As a precondition, the user should be at the Login section.

**Steps:**
1. Navigate to the Signup section.
2. Fill all the form data to sign up (Consider the test must be able to be executed multiple times, so a random email may be generated each time, or an action should be done after the test to delete the created account).
3. Check if the signup process was successfully completed.

### 3. Successful Login

**Description:**
As a precondition, the user should be at the Login section and have a previously created user.

**Steps:**
1. Navigate to the Login View.
2. Fill all the form data to log in.
3. Check if the login process was successfully completed.

### 4. Swipe cards on the Swipe section

**Description:**
As a precondition, the user should be at the Swipe section.

**Steps:**
1. Perform a right swipe on the cards and check the old card is hidden, the new card is visible, and the respective card dot is selected.
2. Perform a left swipe on the cards and check the old card is hidden, the new card is visible, and the respective card dot is selected.

### Author: Bryan Garay
### Email: bryangarayacademico@gmail.com