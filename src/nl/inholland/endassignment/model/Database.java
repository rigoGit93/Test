package nl.inholland.endassignment.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private  ArrayList<User> userList = new ArrayList<>();

    public Database() {
        this.userList = new ArrayList<>();
        User obj1 = new User("Admin", "Pass", "Salman", "tester", LocalDate.now(), Role.ADMIN);
        User obj2 = new User("Employee", "Pass", "Vince", "tester", LocalDate.now(), Role.SALES);

        userList.add(obj1);
        userList.add(obj2);
    }


    public List<User> getUserList() {
        return userList;
    }

}
