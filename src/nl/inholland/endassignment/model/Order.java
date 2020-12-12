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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setOrderExample(ObservableList<OrderExample> orderExample) {
        this.orderExample = orderExample;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ObservableList<OrderExample> getOrderExample() {
        return orderExample;
    }

}
