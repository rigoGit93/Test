package nl.inholland.endassignment;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.inholland.endassignment.view.Login;

public class MainApplication extends Application {

    //private static Stage stage;
    //private static UserDao userDAO;

    @Override
    public void start(Stage stage) throws Exception {
//        MainApplication.stage = stage;
//
//        stage.setTitle("Fundamental Java");
//        stage.setWidth(30);
//        stage.setHeight(30);
//
//        userDAO = new FakeDAO();
//        //   Controllers controllers;
//        switchController(new UserController());
       Login loginView = new Login();
       loginView.getStage().show();

    }

//    public static void switchController(Controllers controller) {
//        stage.setScene(new Scene(controller.getView().getRoot()));
//        stage.show();
//    }

    //public static UserDao getUserDao(){ return userDAO; }
}
