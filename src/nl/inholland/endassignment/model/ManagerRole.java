package nl.inholland.endassignment.model;

import java.time.LocalDate;

public class ManagerRole extends User{
    public ManagerRole(String userName, String password, String firstName, String lastName, LocalDate birtDate, Role enummer) {
        super(userName, password, firstName, lastName, birtDate, enummer);
    }

//    public Role managerRole = Role.ADMIN;
//
//    public ManagerRole(String userName, String password, String firstName, String lastName, LocalDate birtDate) {
//        super(userName, password, firstName, lastName, birtDate);
//    }
}
