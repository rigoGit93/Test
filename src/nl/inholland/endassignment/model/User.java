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

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }

    public HashMap<String, User> getUserHashMap() {
        return userHashMap;
    }

    public void setUserHashMap(HashMap<String, User> userHashMap) {
        this.userHashMap = userHashMap;
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
