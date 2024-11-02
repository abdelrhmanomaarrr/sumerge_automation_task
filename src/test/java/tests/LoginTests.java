package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    // Test 1: Check if the username, password fields, and login button are on the main screen
    @Test
    public void testElementsPresence() {
        Assert.assertTrue(loginPage.usernameField.isDisplayed(), "Username field should be visible");
        Assert.assertTrue(loginPage.passwordField.isDisplayed(), "Password field should be visible");
        Assert.assertTrue(loginPage.loginButton.isDisplayed(), "Login button should be visible");
    }

    // Test 2: Check if the given valid credentials work
    @Test
    public void testValidCredentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isSwagLabsLogoDisplayed(), "Swag Labs logo should be visible after login");
    }

    // Test 3: Check if the given wrong credentials result in an error message
    @Test
    public void testInvalidCredentials() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    // Test 4: Check for error message when username is empty
    @Test
    public void testEmptyUsername() {
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    // Test 5: Check for error message when password is empty
    @Test
    public void testEmptyPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }
}
