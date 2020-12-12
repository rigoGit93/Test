package nl.inholland.endassignment.model;

import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Order {
    private int orderNumber;
    public LocalDate orderDate;
    private String customerName;
    private String city;
    private long phoneNumber;
    private String emailAddress;
    private ObservableList<OrderExample> orderExample;
    private int articleCount;
    private double totalPrice;

    public Order(int orderNumber, LocalDate orderDate, String customerName, String city, long phoneNumber, String emailAddress, ObservableList<OrderExample> orderExample, int articleCount, double totalPrice) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.orderExample = orderExample;
        this.articleCount = articleCount;
        this.totalPrice = totalPrice;
    }

    public ObservableList<OrderExample> getOrderExample() {
        return orderExample;
    }

}
