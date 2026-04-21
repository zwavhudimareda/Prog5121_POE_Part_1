package com.mycompany.chatbeans;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LoginTest {

    /*
     USERNAME TESTS
    */

    // Valid username test
    @Test
    public void testValidUsername() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "+27831234567");
        Login login = new Login(user);

        assertTrue(login.CheckUserName());
    }

    // Invalid username test
    @Test
    public void testInvalidUsername() {

        User user = new User("Kyle", "Smith", "kyle!!!", "Password1!", "+27831234567");
        Login login = new Login(user);

        assertFalse(login.CheckUserName());
    }


    /*
     PASSWORD TESTS
    */

    // Valid password
    @Test
    public void testValidPassword() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Ch&&sec@ke99!", "+27831234567");
        Login login = new Login(user);

        assertTrue(login.CheckPasswordComplexity());
    }

    // Invalid password
    @Test
    public void testInvalidPassword() {

        User user = new User("Kyle", "Smith", "Kyl_1", "password", "+27831234567");
        Login login = new Login(user);

        assertFalse(login.CheckPasswordComplexity());
    }


    /*
     PHONE NUMBER TESTS
    */

    // Valid phone number
    @Test
    public void testValidPhoneNumber() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "+27838968976");
        Login login = new Login(user);

        assertTrue(login.CheckCellPhoneNumber());
    }

    // Invalid phone number
    @Test
    public void testInvalidPhoneNumber() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "08966553");
        Login login = new Login(user);

        assertFalse(login.CheckCellPhoneNumber());
    }


    /*
     LOGIN TESTS
    */

    // Login success
    @Test
    public void testLoginSuccess() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "+27831234567");
        Login login = new Login(user);

        assertTrue(login.LoginUser("Kyl_1", "Password1!"));
    }

    // Login failure
    @Test
    public void testLoginFailure() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "+27831234567");
        Login login = new Login(user);

        assertFalse(login.LoginUser("wrongUser", "wrongPass"));
    }


    /*
     REGISTRATION MESSAGE TESTS (assertEquals)
    */

    // Successful registration
    @Test
    public void TestRegisterSuccessMessage() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "+27831234567");
        Login login = new Login(user);

        String expected = "User successfully registered.";
        String actual = login.registerUser();

        assertEquals(expected, actual);
    }

    // Username fails
    @Test
    public void TestRegisterUsernameFailMessage() {

        User user = new User("Kyle", "Smith", "kyle!!!", "Password1!", "+27831234567");
        Login login = new Login(user);

        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        String actual = login.registerUser();

        assertEquals(expected, actual);
    }

    // Password fails
    @Test
    public void TestRegisterPasswordFailMessage() {

        User user = new User("Kyle", "Smith", "Kyl_1", "password", "+27831234567");
        Login login = new Login(user);

        String expected = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        String actual = login.registerUser();

        assertEquals(expected, actual);
    }

    // Phone fails
    @Test
    public void TestRegisterPhoneFailMessage() {

        User user = new User("Kyle", "Smith", "Kyl_1", "Password1!", "08966553");
        Login login = new Login(user);

        String expected = "Cell phone number incorrectly formatted or does not contain international code.";
        String actual = login.registerUser();

        assertEquals(expected, actual);
    }
}