
package com.POE.startup;

import javax.swing.JOptionPane;

/**
 *
 * @author troyk
 */

public class PartOne {
    
    // Global Declerations
    public static String username = "";
    public static String password = "";
    
    public static String userFirstName = "";
    public static String userLastName = "";

    
    public static void main(String[] args) {

        getUserFullName();
        
        createUsernameAndPassword();
        
        login();
        
    }
    
    /**
    *A method to prompt the user to input their first and last name, and assign the input to global variables
    */
    private static void getUserFullName(){
        
        // Prompt Messages for the User
        final String FIRST_NAME_PROMPT = "Register Account" + "\n" +  "-----------------------------------" + "\n" +"Please Enter your first name: ";
                                   
        
        final String LAST_NAME_PROMPT = "Register Account" + "\n" +  "-----------------------------------" + "\n" +"Please Enter your last name: ";
        
        // Assign inputs to global variables
      
        userFirstName = JOptionPane.showInputDialog(null, FIRST_NAME_PROMPT);
        
        userLastName = JOptionPane.showInputDialog(null, LAST_NAME_PROMPT);
    }

    /**
    *A method to prompt the user to create a username and password, and assign the input to global variables
    */
    private static void createUsernameAndPassword(){
        
        // Prompt Messages for the user
        final String CREATE_USERNAME_PROMPT = "Register Account" + "\n" + "-------------------------------------" + "Please create a username: " + "\n" + "(must contain an underscore and be no more than 5 charcters long) ";
        
        final String CREATE_PASSWORD_PROMPT = "Register Account" + "\n" + "--------------------------------------" + "Please create a password: " + "(Your password should be atleast 8 characters long and contain a capital letter, a number and a special character)";
        
        // Flags to indicate validity of username and password
        boolean isValidUsername = false;
        boolean isValidPassword = false;
        
   
        // Loop until a valid username is entered
        do {
        
            username = JOptionPane.showInputDialog(null, CREATE_USERNAME_PROMPT);
            isValidUsername = Login.checkUserName(username);
            
            // Display registration status message
            JOptionPane.showMessageDialog(null, Login.registerUser(isValidUsername, isValidPassword, true));
        }
        while (! isValidUsername );
        
        
        // Loop until a valid password is entered
        do {

        password = JOptionPane.showInputDialog(null, CREATE_PASSWORD_PROMPT);
        isValidPassword = Login.checkPasswordComplexity(password); 
        
        // Display registration status message
        JOptionPane.showMessageDialog(null, Login.registerUser(isValidUsername, isValidPassword, false));
        
        }
        while (! isValidPassword );
       
    }
    
    /**
    * A method to prompt the user to login with their username and password
    */
    private static void login(){
        
        // Prompt Messages for the User
        final String ENTER_USERNAME_PROMPT = "Login" + "\n" + "--------------------------" + "\n" + "Please enter your Username: ";
        final String ENTER_PASSWORD_PROMPT = "Login" + "\n" + "--------------------------" + "\n" + "Please enter your Password: ";
  
        // Flag to indicate whether login was successful
        boolean successfulLogin = false;
        
        // Variables to hold user input
        String enteredUsername;
        String enteredPassword;
        
         // Variable to hold login message
        String loginMessage;
       
        // Loop until login is successful
        do {
 
            enteredUsername = JOptionPane.showInputDialog(null, ENTER_USERNAME_PROMPT);
            enteredPassword = JOptionPane.showInputDialog(null, ENTER_PASSWORD_PROMPT);

            loginMessage = Login.returnLoginStatus(successfulLogin, userFirstName, userLastName);
            
            // Display registration status message
            JOptionPane.showMessageDialog(null, loginMessage);
            
        }
        while (! Login.loginUser(username, password, enteredUsername, enteredPassword, successfulLogin));

}
       
    }

