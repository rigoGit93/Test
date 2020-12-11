package nl.inholland.endassignment.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class User {

    public String userName;
    public String password;
    public String firstName;
    public String lastName;
    public LocalDate birtDate;
    public Role enummer;

    public HashMap<String, User> userHashMap = new HashMap<String, User>();

    ArrayList<User> list = new ArrayList<User>();

    public User(String userName, String password, String firstName, String lastName, LocalDate birtDate, Role enummer) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birtDate = birtDate;
        this.enummer = enummer;


        // HashMap<String, String > userHashMap = new HashMap<String, String>();
        //   userHashMap.put("Admin", new User("Admin", "Pass",
        //            "Salman", "tester", LocalDate.now()));
        // userHashMap.put("SalesAcc","Passwrd");


    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birtDate=" + birtDate +
                //  ", userHashMap=" + userHashMap +
                '}';
    }
}
