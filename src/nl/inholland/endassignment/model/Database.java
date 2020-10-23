package nl.inholland.endassignment.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Customer> customer = new ArrayList<>();

    public Database() {
        this.userList = new ArrayList<>();
        User obj1 = new User("Admin", "Pass", "Salman", "tester", LocalDate.now(), Role.ADMIN);
        User obj2 = new User("Employee", "Pass", "Vince", "tester", LocalDate.now(), Role.SALES);

        userList.add(obj1);
        userList.add(obj2);

        this.customer = new ArrayList<>();
        Customer cl1 = new Customer("Wim", "Wiltenburg", "Stentorsstraat 90",
                "Amsterdam",061234567, "wim@email.com");
        Customer cl2 = new Customer("Jack", "Traven", "Dorpsstraat 10",
                "Arnhem",0612674567, "jack@email.com");
        Customer cl3 = new Customer("Jenny", "Gump", "Rodekruis 67",
                "Den Haag",061234567, "jenny@email.com");

        customer.add(cl1);
        customer.add(cl2);
        customer.add(cl3);

    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public List<User> getUserList() {
        return userList;
    }

}
