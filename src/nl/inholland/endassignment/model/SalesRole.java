package nl.inholland.endassignment.model;

import java.time.LocalDate;

public class SalesRole extends User{
    public SalesRole(String userName, String password, String firstName, String lastName, LocalDate birtDate, Role enummer) {
        super(userName, password, firstName, lastName, birtDate, enummer);
    }
//
//    public Role salesRole = Role.SALES;
//
//    public SalesRole(String userName, String password, String firstName, String lastName, LocalDate birtDate) {
//        super(userName, password, firstName, lastName, birtDate);
//    }
}
