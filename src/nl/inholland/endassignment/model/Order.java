package nl.inholland.endassignment.model;

import java.time.LocalDate;

public class Order {
    private int orderNumber;
    public LocalDate orderDate;
    private Customer customerName;
    private OrderExample orderExample;
    private int articleCount;
    private double totalPrice;

    public Order(int orderNumber, LocalDate orderDate, Customer customerName, OrderExample orderExample, int articleCount, double totalPrice) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.customerName = customerName;
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

    public Customer getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Customer customerName) {
        this.customerName = customerName;
    }

    public OrderExample getOrderExample() {
        return orderExample;
    }

    public void setOrderExample(OrderExample orderExample) {
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
}
