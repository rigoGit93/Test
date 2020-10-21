package nl.inholland.endassignment.controller;

import nl.inholland.endassignment.view.Dashboard;

public class DashboardController{

    private Dashboard view;
    //private UserDao userDao;

    public DashboardController(){
        view = new Dashboard();
        //userDao = MainApplication.getUserDao();
        //view.getOrderMenuItem().setOnAction(e -> createOrderButton());
    }

    public void createOrderButton(){
        //MainApplication.switchController(new CreateOrderController());
    }

//    @Override
//    public Views getView() {
//        return view;
//    }
}
