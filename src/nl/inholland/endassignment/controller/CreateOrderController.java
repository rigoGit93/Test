package nl.inholland.endassignment.controller;

import nl.inholland.endassignment.view.CreateOrder;
import nl.inholland.endassignment.view.Views;

public class CreateOrderController extends Controllers{

    private CreateOrder view;

    public CreateOrderController(){
        view = new CreateOrder();
    }


    @Override
    public Views getView() {
        return view;
    }
}
