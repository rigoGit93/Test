package nl.inholland.endassignment.controller;

import nl.inholland.endassignment.MainApplication;
import nl.inholland.endassignment.data.UserDao;
import nl.inholland.endassignment.view.Dashboard;
import nl.inholland.endassignment.view.Views;

public class DashboardController extends Controllers{

    private Dashboard view;
    private UserDao userDao;

    public DashboardController(){
        view = new Dashboard();
        userDao = MainApplication.getUserDao();
    }

    @Override
    public Views getView() {
        return view;
    }
}
