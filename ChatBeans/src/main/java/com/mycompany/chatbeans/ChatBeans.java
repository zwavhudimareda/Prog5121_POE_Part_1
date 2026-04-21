
package com.mycompany.chatbeans;
import java.util.Scanner;
public class ChatBeans {

    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

        // variables declared first
        String FirstName;
        String LastName;
        String Username;
        String Password;
        String CellNumber;

        System.out.println("=== USER REGISTRATION ===");
        
        /*
         FIRST NAME
        */
        System.out.print("Enter first name: ");
        FirstName = scanner.nextLine();

        /*
         LAST NAME
        */
        System.out.print("Enter last name: ");
        LastName = scanner.nextLine();


        /*
         USERNAME VALIDATION LOOP
         keeps asking until username is correct
        */
        while (true) {

            System.out.print("Enter username"
                    + "\nMust contain an underscore and no more than five characters in length"
                    + "\n: ");
            Username = scanner.nextLine();

            // temporary user object to test username
            User TempUser = new User(FirstName, LastName, Username, "", "");

            Login TempLogin = new Login(TempUser);

            if (TempLogin.CheckUserName()) {

                System.out.println("Username successfully captured.");
                break;

            } else {

                System.out.println("Username is incorrectly formatted.");
                
            }
        }


        /*
         PASSWORD VALIDATION LOOP
        */
        while (true) {

            System.out.print("Enter password "
                    + "\nPassword must be at least 8 characters long and include: "
                    + "\n- a capital letter"
                    + "\n-a number "
                    + "\n-a special character"
                    + "\n: ");
            Password = scanner.nextLine();

            User TempUser = new User(FirstName, LastName, Username, Password, "");

            Login TempLogin = new Login(TempUser);

            if (TempLogin.CheckPasswordComplexity()) {

                System.out.println("Password successfully captured.");
                break;

            } else {

                System.out.println("Password is incorrectly formatted.");
             
            }
        }


        /*
         PHONE NUMBER VALIDATION LOOP
        */
        while (true) {

            System.out.print("Enter cell phone number "
                    + "\nNumber must include international code +27 and contain 9 digits after"
                    + "\n: ");
            CellNumber = scanner.nextLine();

            User TempUser = new User(FirstName, LastName, Username, Password, CellNumber);

            Login TempLogin = new Login(TempUser);

            if (TempLogin.CheckCellPhoneNumber()) {

                System.out.println("Cell phone number successfully added.");
                break;

            } else {

                System.out.println("Cell phone number incorrectly formatted.");
            
            }
        }


        /*
         CREATE FINAL USER OBJECT
        */
        User User = new User(
                FirstName,
                LastName,
                Username,
                Password,
                CellNumber
        );

        Login LoginSystem = new Login(User);


        /*
         LOGIN SECTION
        */
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();


        boolean LoginSuccess =
                LoginSystem.LoginUser(enteredUsername, enteredPassword);

        System.out.println(
                LoginSystem.ReturnLoginStatus(LoginSuccess)
        );

        scanner.close();
    }
    }

/* References
Oracle. (n.d.). Scanner Class (Java Platform SE Documentation). 
Available at: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html 
(Accessed: 21 April 2026).

Oracle. (n.d.). Java Control Flow Statements (if, while). 
Available at: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html 
(Accessed: 21 April 2026).
*/