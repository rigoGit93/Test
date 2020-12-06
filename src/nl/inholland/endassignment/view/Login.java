package nl.inholland.endassignment.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.User;
import nl.inholland.endassignment.util.Notifications;
import nl.inholland.endassignment.util.SystemProperties;

import javafx.scene.input.KeyEvent;
import java.io.Serializable;

public class Login implements Serializable {

    private static Stage stage;
    public static Database database;
    private GridPane gridPane;
    private TextField userInput;
    private TextField passwordInput;
    private Button loginButton;
    public static Dashboard dashboard;

    public Login() {
        initLayout();
    }

    private void initLayout() {

        database = new Database();
        VBox vBox = new VBox();

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label loginLabel = new Label("Login");
        loginLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        GridPane.setConstraints(loginLabel, 0, 0);

        Label userLabel = new Label("Username");
        userLabel.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        GridPane.setConstraints(userLabel, 0, 1);

        TextField userInput = new TextField();
        userInput.setPrefSize(SystemProperties.getTextBoxSize()[0], SystemProperties.getTextBoxSize()[1]);
        userInput.setPromptText("username");
        GridPane.setConstraints(userInput, 0, 2);

        Label passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 14));
        GridPane.setConstraints(passwordLabel, 0, 3);

        passwordInput = new PasswordField();
        passwordInput.setPromptText("password");
        passwordInput.setPrefSize(SystemProperties.getTextBoxSize()[0], SystemProperties.getTextBoxSize()[1]);
        GridPane.setConstraints(passwordInput, 0, 4);

        loginButton = new Button("Login");
        loginButton.setPrefSize(SystemProperties.getButtonSize()[0], SystemProperties.getButtonSize()[1]);
        GridPane.setConstraints(loginButton, 0, 5);

        /*StringProperty passwordFieldProperty = passwordInput.textProperty();

        Label visiblePassword = new Label();
        GridPane.setConstraints(visiblePassword, 0, 4);
        visiblePassword.textProperty().bind(passwordFieldProperty);*/


        gridPane.getChildren().addAll(loginLabel, userLabel, userInput, passwordLabel, passwordInput, loginButton);
        gridPane.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(gridPane);

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Guitarshop FX - Login");
        stage.setScene(scene);

        stage.setWidth(500);
        stage.setHeight(300);


        /*

         */
        loginButton.setOnAction(actionEvent -> {

            if (userInput.getText().isEmpty() | passwordInput.getText().isEmpty()){
                Notifications.errorNotification("Username and Password is required!", "Login Error", null);
            }else {
                User login = database.getUserList().stream()
                        .filter(user -> userInput.getText().equals(user.userName)
                                && passwordInput.getText().equals(user.password))
                        .findAny()
                        .orElse(null);
                if (login == null) {
                    Notifications.errorNotification("Login is failed!", "Login Error", null);

                } else {
                    stage.close();
                    Dashboard dashboard = new Dashboard(login);
                    dashboard.getStage().showAndWait();
                }
            }
        });

        userInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    passwordInput.requestFocus();
                }
            }
        });

        passwordInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    loginButton.requestFocus();
                }
            }
        });

        /*loginButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    System.out.println("Enter Pressed");
                }
            }
        });*/

    }

    public static Stage getStage() {
        return stage;
    }

}
