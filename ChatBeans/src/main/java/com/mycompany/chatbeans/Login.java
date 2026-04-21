
package com.mycompany.chatbeans;
import java.util.regex.Pattern;

public class Login {
     private User User;

    /*
     Constructor receives User object
    */
    public Login(User User) {

        this.User = User;
    }

    /*
     checkUserName()

     Rules:
     - must contain underscore
     - must be 5 characters or less
    */
    public boolean CheckUserName() {

        String Username = User.getUsername();

        return Username.contains("_") && Username.length() <= 5;
    }

    /*
     checkPasswordComplexity()

     Password must contain:
     - minimum 8 characters
     - 1 capital letter
     - 1 number
     - 1 special character

    */
    public boolean CheckPasswordComplexity() {

        String password = User.getPassword();

        String regex =
                "^(?=.*[A-Z])" +
                "(?=.*[0-9])" +
                "(?=.*[!@#$%^&*])" +
                ".{8,}$";

        return Pattern.matches(regex, password);
    }

    /*
     checkCellPhoneNumber()

     Must:
     - start with +27
     - followed by 9 digits
    */
    public boolean CheckCellPhoneNumber() {

        String phoneNumber = User.getCellNumber();

        String regex = "^\\+27[0-9]{9}$";

        return Pattern.matches(regex, phoneNumber);
    }

    /*
     registerUser()

     Returns appropriate feedback message
    */
    public String registerUser() {

        if (!CheckUserName()) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!CheckPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!CheckCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "User successfully registered.";
    }

    /*
     loginUser()

     Verifies entered login details match stored details
    */
    public boolean LoginUser(String enteredUsername, String enteredPassword) {

        return enteredUsername.equals(User.getUsername()) &&
               enteredPassword.equals(User.getPassword());
    }

    /*
     returnLoginStatus()

     Returns correct message depending on login result
    */
    public String ReturnLoginStatus(boolean LoginSuccess) {

        if (LoginSuccess) {

            return "Welcome " + User.getFirstName() +
                   " " + User.getLastName() +
                   " it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }
}

/*References
Stack Overflow. (2016). Regex for South African phone number. 
Available at: https://stackoverflow.com/questions/30058927/regex-for-south-african-phone-number 
(Accessed: 10 April 2026).

Stack Overflow. (2010). Regexp Java for password validation. 
Available at: https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation 
(Accessed: 12 April 2026).

Oracle. (n.d.). Pattern (Java Platform SE Documentation). 
Available at: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html 
(Accessed: 12 April 2026).

Oracle. (n.d.). Java String Class. 
Available at: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html 
(Accessed: 12 April 2026).
*/