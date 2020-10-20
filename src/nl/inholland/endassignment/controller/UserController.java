package nl.inholland.endassignment.controller;

import nl.inholland.endassignment.MainApplication;
import nl.inholland.endassignment.data.UserDao;
import nl.inholland.endassignment.view.Login;
import nl.inholland.endassignment.view.Views;

public class UserController extends Controllers {

    //Kijken of het vanuit hier werkt. Nog geen resultaat.
   // private ArrayList<Database> db;
   // private ObservableList<Database> db1;

    private Login view;
    private UserDao userDao;

    public UserController() {

        view = new Login();

        view.getLoginButton().setOnAction(e -> login());

        //Kijken of het vanuit hier werkt. Nog geen resultaat.
       // db = new ArrayList<>();
       // db1 = FXCollections.observableArrayList(db);

        refreshData();
        userDao = MainApplication.getUserDao();
    }

    private void refreshData() {
//        Database db = new Database();
//        ObservableList<User> people = FXCollections.observableArrayList(db.getList());


    }


    public void login() {

        System.out.println("Login button works!");
        String usernameInput = view.getUserInput().getText().toString();
        String passwrdInput = view.getPasswordInput().getText().trim().toString();
        //  User user =


        //  Database db = new Database();
        //  ObservableList<User> lijst = FXCollections.observableArrayList(db.getList());

        /**
         * TODO: Moet in de lijst loopen en zo eruit hale wat in de inputs staat.
         */
        for (int i = 0; i < userDao.getAll().size() ; i++) {

            if (userDao.getAll().get(i).userName.equals(usernameInput) &&
                    userDao.getAll().get(i).password.equals(passwrdInput)){
                System.out.println("Hi " + usernameInput);

                MainApplication.switchController(new DashboardController());
                // hier moeten de firstName en lastName meegegeven worden als parameter
            }

            else {
                System.out.println("Login komt niet overeen!");
                break;
            }

        }

    }

    @Override
    public Views getView() {
        return view;
    }

}
