package nl.inholland.endassignment.view;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
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
import nl.inholland.endassignment.controller.Controllers;
import nl.inholland.endassignment.view.Dashboard;

public class Login extends Views {


    private GridPane gridPane;
    private TextField userInput;
    private TextField passwordInput;
    private Button loginButton;
    private Parent root;
    public Login(){initLayout();};

    private void initLayout() {

        VBox vBox = new VBox();

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label loginLabel = new Label("Login");
        GridPane.setConstraints(loginLabel, 0, 0);

        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 0, 1);

        userInput = new TextField();
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

    }

    @Override
    public Parent getRoot() {
        return root;
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
