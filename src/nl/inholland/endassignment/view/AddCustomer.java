package nl.inholland.endassignment.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddCustomer {

    private Stage stage;
    private GridPane gridPane;
    private VBox vBox;
    private Button addCustomer;
    private Button cancelButton;


    public AddCustomer() {
        initLayout();
    }

    private void initLayout() {

        gridPane = new GridPane();
        vBox = new VBox();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label addCustomerLabel = new Label("Add Customer");
        GridPane.setConstraints(addCustomerLabel, 0, 0);


        Label firstNameLabel = new Label("First Name");
        GridPane.setConstraints(firstNameLabel, 0, 1);

        TextField firstNameInput = new TextField();
        firstNameInput.setPromptText("firstName");
        GridPane.setConstraints(firstNameInput, 1, 1);

        Label lastNameLabel = new Label("Last Name");
        GridPane.setConstraints(lastNameLabel, 0,2);

        TextField lastNameInput = new TextField();
        firstNameInput.setPromptText("lastName");
        GridPane.setConstraints(lastNameInput, 1, 2);

        Label streetAddressLabel = new Label("Street address");
        GridPane.setConstraints(streetAddressLabel, 0, 3);

        TextField streetAddressInput = new TextField();
        streetAddressInput.setPromptText("streetAddress");
        GridPane.setConstraints(streetAddressInput, 1, 3);

        Label cityLabel = new Label("City");
        GridPane.setConstraints(cityLabel, 0, 4);

        TextField cityInput = new TextField();
        cityInput.setPromptText("city");
        GridPane.setConstraints(cityInput, 1, 4);

        Label phoneNumberLabel = new Label("Phone number");
        GridPane.setConstraints(phoneNumberLabel, 0, 5);

        TextField phoneNumberInput = new TextField();
        phoneNumberInput.setPromptText("phoneNumber");
        GridPane.setConstraints(phoneNumberInput, 1, 5);

        Label emailAddressLabel = new Label("Email address");
        GridPane.setConstraints(emailAddressLabel, 0, 6);

        TextField emailAddressInput = new TextField();
        emailAddressInput.setPromptText("emailAddress");
        GridPane.setConstraints(emailAddressInput, 1, 6);

        addCustomer = new Button("Add customer");
        GridPane.setConstraints(addCustomer, 0, 7);

        cancelButton = new Button("Cancel");
        GridPane.setConstraints(cancelButton, 1, 7);

        gridPane.getChildren().addAll(addCustomerLabel, firstNameLabel, firstNameInput, lastNameLabel,
        lastNameInput, streetAddressLabel, lastNameInput, streetAddressLabel, streetAddressInput, cityLabel,
                cityInput, phoneNumberLabel,phoneNumberInput,emailAddressLabel,emailAddressInput,addCustomer,
                cancelButton);

        vBox.getChildren().addAll(gridPane);

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Add Customer");
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }
}
