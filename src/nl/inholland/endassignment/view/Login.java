package nl.inholland.endassignment.view;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.User;

public class Login {

    private static Stage stage;
    private Database database;
    private GridPane gridPane;
    private TextField userInput;
    private TextField passwordInput;
    private Button loginButton;
    private ObservableList<User> users;
    private Parent root;

    public Login()
    {
        initLayout();
    }

    private void initLayout() {

        database = new Database();
        users = FXCollections.observableArrayList(database.getList());
        VBox vBox = new VBox();

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label loginLabel = new Label("Login");
        GridPane.setConstraints(loginLabel, 0, 0);

        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 0, 1);

        TextField userInput = new TextField();
        userInput.setPromptText("username");
        GridPane.setConstraints(userInput, 1, 1);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 2);

        passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 2);

        loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 0, 3);

        StringProperty passwordFieldProperty = passwordInput.textProperty();

        Label visiblePassword = new Label();
        GridPane.setConstraints(visiblePassword, 0, 4);
        visiblePassword.textProperty().bind(passwordFieldProperty);


        gridPane.getChildren().addAll(loginLabel, userLabel, userInput, passwordLabel, passwordInput, loginButton, visiblePassword);

        vBox.getChildren().addAll(gridPane);
        root = vBox;

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

               for (int i = 0; i < database.getList().size(); i++) {

                    System.out.println("Het werkt");

                    Dashboard dashboard = new Dashboard();
                    dashboard.getStage().showAndWait();



//                    if (userDao.getAll().get(i).userName.equals(userInput) &&
//                            userDao.getAll().get(i).password.equals(passwordInput)){
//                        System.out.println("Hi " + userInput);
//
//                        DashboardController saw = new DashboardController();
//
//
//                        //MainApplication.switchController(new ArticleController());
//                        // hier moeten de firstName en lastName meegegeven worden als parameter
//                    }

//                    else {
//                        System.out.println("Login komt niet overeen!");
//                        break;
//                    }

                }

            }
        });

    }

//    @Override
//    public Parent getRoot() {
//        return root;
//    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public void setUsers(ObservableList<User> users) {
        this.users = users;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Login.stage = stage;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public TextField getUserInput() {
        return userInput;
    }

    public void setUserInput(TextField userInput) {
        this.userInput = userInput;
    }

    public TextField getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(TextField passwordInput) {
        this.passwordInput = passwordInput;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }
}
