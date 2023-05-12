
package com.POE.startup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author troyk
 */

public class LoginTest {

    // User Details 
    public String userFirstName = "Kyle";    
    public String userLastName = "Kanban";   
    
    // Method return values
    public boolean expectedResult = false;
    public boolean isValidPassword = false;
    public boolean isValidUsername = false;
    public boolean successfulLogin = false;
   
    public String loginMessage;
    public String expectedRegistrationMessage;
    
    // Test Data
    
    // Checking username
    final public String TEST_USERNAME_TRUE = "kyl_1";
    final public String TEST_USERNAME_FALSE = "kyle!!!!!!!";
    
    // Checking password
    final public String TEST_PASSWORD_TRUE = "Ch$$sec@ke99!";
    final public String TEST_PASSWORD_FALSE = "password";
    
    // Login User
    final public String USERNAME = "kyl_1";
    final public String PASSWORD = "Ch$$sec@ke99!";
   
 /**
 * Tests the checkUserName method in the Login class
 */
    @Test
    public void testCheckUserName() {
        
        // Display Test Name
        System.out.println("checkUserName");
        
        // Declerations
        boolean usernameResult;
        
        // Test correctly formatted username
        expectedResult = true;
        usernameResult = Login.checkUserName(TEST_USERNAME_TRUE);
        assertEquals(expectedResult, usernameResult);
        
        // Test incorrectly formatted username
        expectedResult = false;
        boolean resultNotValidUsername  = Login.checkUserName(TEST_USERNAME_FALSE);
        assertEquals(expectedResult, resultNotValidUsername);
    }
    
/**
* Tests the checkPasswordComplexity method in the Login class.
*/
    @Test
    public void testCheckPasswordComplexity() {

        // Display Test Name
        System.out.println("checkPasswordComplexity");
       
        //Declerations 
        boolean passwordResult;
        
        // Test with correctly formatted password
        expectedResult = true;
        passwordResult = Login.checkPasswordComplexity(TEST_PASSWORD_TRUE);
        assertEquals(expectedResult, passwordResult);
        
        // Test with incorrectly formatted password
        expectedResult = false;
        passwordResult = Login.checkPasswordComplexity(TEST_PASSWORD_FALSE);
        assertEquals(expectedResult, passwordResult);
    }
    
/**
* Tests the RegisterUser method in the Login class.
*/
    @Test
    public void testRegisterUser() {
        
        //Display Test Name
        System.out.println("registerUser");
        
        //Declerations
        boolean isUsername;
        String usernameResult;
        String passwordResult;
        
        //Test with Valid Username
        isValidUsername = true;
        isUsername = true;
        expectedRegistrationMessage = "Username Successfully Captured";
        
        usernameResult = Login.registerUser(isValidUsername, isValidPassword, isUsername);
        assertEquals(expectedRegistrationMessage, usernameResult);
        
        //Test with Invalid username
        isValidUsername = false;
        expectedRegistrationMessage = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        
        usernameResult= Login.registerUser(isValidUsername, isValidPassword, isUsername);
        assertEquals(expectedRegistrationMessage, usernameResult);
        
        // Test with Valid password
        isValidPassword = true;
        isUsername =  false;       
        expectedRegistrationMessage = "Password Successfully Captured";
        
        passwordResult = Login.registerUser(isValidUsername, isValidPassword, isUsername);
        assertEquals(expectedRegistrationMessage, passwordResult);
        
        // Test with Invalid password
        isValidPassword = false;
        expectedRegistrationMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        
        passwordResult = Login.registerUser(isValidUsername, isValidPassword, isUsername);       
        assertEquals(expectedRegistrationMessage, passwordResult);
    }

/**
* Tests the loginUser method in the Login class.
*/
 @Test
    public void testLoginUser() {
        
        //Display Test Name
        System.out.println("loginUser");
        
        // Test with Successful Login
        String enteredUsername = "kyl_1";
        String enteredPassword = "Ch$$sec@ke99!";
        boolean expResultSuccessfulLogin = true;
        
        // Successful Login will return true or false
        successfulLogin = Login.loginUser(USERNAME, PASSWORD, enteredUsername, enteredPassword, successfulLogin);
        assertEquals(expResultSuccessfulLogin, successfulLogin);
        
        //Test with Unsuccessful Login
        enteredUsername = "kyle!!!!!!!";
        enteredPassword = "password";
        final boolean EXPECTED_UNSUCCESSFUL_LOGIN = false;
        
        // Successful Login will return true or false
        successfulLogin = Login.loginUser(USERNAME, PASSWORD, enteredUsername, enteredPassword, successfulLogin);     
        assertEquals(EXPECTED_UNSUCCESSFUL_LOGIN, successfulLogin);
    }
    
 /**
* Tests the returnLoginStatus method in the Login class.
*/
    @Test 
    public void testReturnLoginStatus() {
        
        //Display Test Name
        System.out.println("returnLoginStatus");
        
        //Declerations
        String loginMessageResult;
        
        // Test with Successful Login      
        successfulLogin = true;
        loginMessage = "Welcome " + userFirstName + " " + userLastName + " it is great to see you again";
        
        loginMessageResult = Login.returnLoginStatus(successfulLogin, userFirstName, userLastName);
        assertEquals(loginMessage, loginMessageResult);
        
        // Test with Unsuccessful Login
        successfulLogin = false;
        loginMessage = "Username or password incorrect, please try again";
        
        loginMessageResult = Login.returnLoginStatus(successfulLogin, userFirstName, userLastName);
        assertEquals(loginMessage, loginMessageResult);

    }
    
}