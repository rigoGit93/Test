package nl.inholland.endassignment.controller;

import nl.inholland.endassignment.view.Customer;
import nl.inholland.endassignment.view.Views;

public class CustomerController extends Controllers{

    private Customer view;

    public CustomerController() {
        view = new Customer();
    }

    @Override
    public Views getView() {
        return view;
    }
}
