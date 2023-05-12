
package com.POE.startup;

/**
 *
 * @author troyk
 */

public class Login {
    
  /**
 * Checks if the given username meets the requirements for a valid username.
 *
 * @param username The username to be checked.
 * @return A boolean indicating if the username meets the requirements for a valid username.
 */
   public static boolean checkUserName(String username){
        
        // Declare the maximum allowed length for a username
        final int MAX_USERNAME_LENGTH = 5;
        
        
        // Check if the username is less than or equal to the maximum allowed length
        boolean lessThanFiveCharLong = (username.length() <= MAX_USERNAME_LENGTH);
        
         // Check if the username contains an underscore
        boolean containsUnderScore = username.contains("_");
        
       //Determines wether username meets requirements
       boolean isValidUsername = containsUnderScore && lessThanFiveCharLong;
      
       return isValidUsername; 
    }
    
    
/**
* Checks the complexity of a password to ensures it meets certain requirements.
*
* @param password the password to check complexity for
* @return true if the password meets the complexity requirements
*/
    public static boolean checkPasswordComplexity(String password){
        
        // Minimum password length required
        final int MIN_PASSWORD_LENGTH = 8;
        
        // Boolean flags for each password complexity requirement
        boolean isLongEnough = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        
        // Checks if password meets length requirement
        if (password.length() >= MIN_PASSWORD_LENGTH)  isLongEnough = true;
  
        /**
        *  Adapted from Stack overflow
        *  https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase 
        *  CyprUS
        * https://stackoverflow.com/users/640739/cyprus
        */
        
        // Iterates over each character in password and checks if it meets each complexity requirement
        for (char i: password.toCharArray()){
            
            if(Character.isUpperCase(i)) hasUpperCase = true;
            
            else if (Character.isDigit(i)) hasDigit = true;
            
            else if (!Character.isLetter(i)  && !Character.isDigit(i)  && !Character.isWhitespace(i)) hasSpecialChar = true;
        }
      
        // Returns true if all password complexity requirements are met, false otherwise
        boolean isValidPassword = isLongEnough && hasUpperCase && hasDigit && hasSpecialChar;
        
        return isValidPassword;
    }
    
    
 /**
 * Generates a registration message based on whether the username and password
 * are valid.
 *
 * @param isValidUsername a boolean value indicating whether the username is valid
 * @param isValidPassword a boolean value indicating whether the password is valid
 * @param isUsername      a boolean value indicating whether the message is for the username or password
 * @return a message indicating the success or failure of registration
 */
    public static String registerUser(boolean isValidUsername, boolean isValidPassword, boolean isUsername){
        
        //Local declerations
        
        String message = "";
        
        // Declare constant strings for messages
        final String VALID_USERNAME_MESSAGE = "Username Successfully Captured";
        final String NOT_VALID_USERNAME_MESSAGE = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        final String VALID_PASSWORD_MESSAGE = "Password Successfully Captured";
        final String NOT_VALID_PASSWORD_MESSAGE = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
 
        
        // Determine which type of message to return based on the validity of the input and the input type
        if (isValidUsername && isUsername) message = VALID_USERNAME_MESSAGE;
        
        else if (isUsername  && ! isValidUsername) message = NOT_VALID_USERNAME_MESSAGE;
         
        else if (isValidPassword && ! isUsername ) message = VALID_PASSWORD_MESSAGE;
        
        else if(! isValidPassword  && ! isUsername ) message = NOT_VALID_PASSWORD_MESSAGE; 
        
        // Return the appropriate message
        return message;
    }
    
 /**
 * Checks if the entered username and password match the saved username and password
 * @param username The saved username
 * @param password The saved password
 * @param enteredUsername The username entered by the user
 * @param enteredPassword The password entered by the user
 * @param successfulLogin The flag indicating whether the login was successful
 * @return The flag indicating whether the login was successful
 */
    public static boolean loginUser(String username, String password, String enteredUsername, String enteredPassword, boolean successfulLogin){
        
        // Check if the entered username and password match the saved username and password
        boolean correctUsername = enteredUsername.equals(username);
        boolean correctPassword = enteredPassword.equals(password);
        
        // Set the successfulLogin flag to true if the entered username and password match the saved username and password
        successfulLogin = correctUsername && correctPassword;
        
        return successfulLogin;
    }
    
/**
* Generates a message to indicate the status of a login attempt.
* @param successfulLogin A flag indicating whether the login attempt was successful or not
* @param userFirstName The first name of the user attempting to log in
* @param userLastName The last name of the user attempting to log in
* @return A message indicating whether the login was successful or not, and if successful, welcoming the user by their full name.
*/
    public static String returnLoginStatus (boolean successfulLogin, String userFirstName, String userLastName){
        
        // Local Decleration
        String message;
        
        // Messages to be displayed to user
        final String SUCCESSFUL_LOGIN_MESSAGE = "Welcome " + userFirstName + " " + userLastName + " it is great to see you again";
        final String UNSUCCESSFUL_LOGIN_MESSAGE = "Username or password incorrect, please try again";
        
        // Check if login was successful
        if (successfulLogin) message = SUCCESSFUL_LOGIN_MESSAGE;
        
        else
            message = UNSUCCESSFUL_LOGIN_MESSAGE;

        return message;
    }
    
}
