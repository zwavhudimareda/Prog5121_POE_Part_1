
package com.mycompany.chatbeans;

// stores user information

public class User {
  
// private variables to protect data
    
    private String FirstName;
    private String LastName;
    private String Username;
    private String Password;
    private String CellNumber;
    
    // Constructor sets user information when created. Holds whatever the user enters at that point
   
    public User (String FirstName,String LastName,String Username,String Password, String CellNumber )
    {
          this.FirstName = FirstName;
          this.LastName = LastName;
          this.Username = Username;
          this.Password = Password;
          this.CellNumber = CellNumber;
          
    }
    
     // Getter methods allow controlled access to data

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getCellNumber() {
        return CellNumber;
    }
}
