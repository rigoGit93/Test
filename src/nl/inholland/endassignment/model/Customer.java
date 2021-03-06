package nl.inholland.endassignment.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String cityLocation;
    private long phoneNumber;
    private String emailAddress;

    private List<Article> articleTest =new ArrayList<>();


    public Customer(String firstName, String lastName, String streetAddress, String cityLocation, long phoneNumber,
                    String emailAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.cityLocation = cityLocation;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Article> getArticleTest() {
        return articleTest;
    }

    public void setArticleTest(List<Article> articleTest) {
        this.articleTest = articleTest;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<Article> getArticlelist() {
        return articleTest;
    }
}
