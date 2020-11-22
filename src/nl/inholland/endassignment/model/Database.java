package nl.inholland.endassignment.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

    private ArrayList<User> userList;
    private ArrayList<Customer> customer;
    private ArrayList<Article> articlelist;
    private static ArrayList<OrderExample> orderExamples;

    public Database() {
        orderExamples = new ArrayList<>();

        this.userList = new ArrayList<>();
        User obj1 = new User("Admin", "Pass", "Salman", "tester", LocalDate.now(), Role.ADMIN);
        User obj2 = new User("Employee", "Pass", "Vince", "tester", LocalDate.now(), Role.SALES);

        userList.add(obj1);
        userList.add(obj2);

        this.customer = new ArrayList<>();
        Customer cl1 = new Customer("Wim", "Wiltenburg", "Stentorsstraat 90",
                "Amsterdam", 061234567, "wim@email.com");
        Customer cl2 = new Customer("Jack", "Traven", "Dorpsstraat 10",
                "Arnhem", 0612674567, "jack@email.com");
        Customer cl3 = new Customer("Jenny", "Gump", "Rodekruis 67",
                "Den Haag", 061234567, "jenny@email.com");

     // cl1.get

        customer.add(cl1);
        customer.add(cl2);
        customer.add(cl3);

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

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
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

}
