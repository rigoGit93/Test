package nl.inholland.endassignment.model;

import nl.inholland.endassignment.util.Utils;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private ArrayList<User> userList;
    private ArrayList<Customer> customer;
    private ArrayList<Article> articlelist;
    private static ArrayList<OrderExample> orderExamples;
    private ArrayList<Order> orderList;

    public Database() {
        orderExamples = new ArrayList<>();

        this.orderList = new ArrayList<>();

        this.userList = new ArrayList<>();
        User obj1 = new User("Admin", "Pass", "Salman", "tester", LocalDate.now(), Role.ADMIN);
        User obj2 = new User("Employee", "Pass", "Vince", "tester", LocalDate.now(), Role.SALES);

        userList.add(obj1);
        userList.add(obj2);

        this.customer = Utils.getCustomersFromFile(new File(Utils.getCSVFile().getAbsolutePath()));

        this.articlelist = new ArrayList<>();
        Article art1 = new Article(1, "Fender", "Telecaster", false, GuitarType.REGULAR,
                1079.79);
        Article art2 = new Article(10, "Fender", "Precision", false, GuitarType.BASS,
                1300.49);
        Article art3 = new Article(7, "Simon Patrick", "Pro Flame Maple", true, GuitarType.REGULAR,
                1290.7);

        articlelist.add(art1);
        articlelist.add(art2);
        articlelist.add(art3);

    }

    public ArrayList<Customer> getCustomer(String searchItem) {
        if (searchItem.isEmpty()){
            return customer;
        }
        ArrayList<Customer> customers = new ArrayList<>();
        for(Customer cust : customer){
            if (cust.getFirstName().toLowerCase().contains(searchItem.toLowerCase()) | cust.getLastName().toLowerCase().contains(searchItem.toLowerCase())){
                customers.add(cust);
            }
        }
        return customers;
    }

    public List<User> getUserList() {
        return userList;
    }

    public ArrayList<Article> getArticlelist() {
        return articlelist;
    }

    public static ArrayList<OrderExample> getOrderExamples() {
        return orderExamples;
    }

    public ArrayList<Order> getOrderList(){
        return this.orderList;
    }
}
