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
