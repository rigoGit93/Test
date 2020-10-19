package nl.inholland.endassignment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private  ArrayList<User> list = new ArrayList<>();

    public void DatabaseList() {
      //  this.list = new ArrayList<>();
//        User obj1 = new User("Admin", "Pass", "Salman", "tester", LocalDate.now());
//        User obj2 = new User("Employee", "Pass", "Vince", "tester", LocalDate.now());
//
//        list.add(obj1);
//        list.add(obj2);
    }


    public List<User> getList() {
        return list;
    }

}
