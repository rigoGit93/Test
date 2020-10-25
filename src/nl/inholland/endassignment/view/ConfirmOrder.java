package nl.inholland.endassignment.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmOrder {

    private Stage stage;
    private Button confirmButton;
    private Label quantityLbl;
    private VBox vBox;
    private GridPane gridPane;

    public ConfirmOrder() {
        initLayout();
    }

    private void initLayout() {

        gridPane = new GridPane();
        vBox = new VBox();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label customerLabel = new Label("Customer: ");
        GridPane.setConstraints(customerLabel, 0, 0);

        Label fullNameLabel = new Label("");
        GridPane.setConstraints(fullNameLabel, 1, 0);

        Label streetAddressLabel = new Label("");
        GridPane.setConstraints(streetAddressLabel, 1,1);

        Label cityLocationLabel = new Label("");
        GridPane.setConstraints(cityLocationLabel, 1, 2);

        Label phoneNumberLabel = new Label("");
        GridPane.setConstraints(phoneNumberLabel, 1, 3);

        Label emailAddressLabel = new Label("");
        GridPane.setConstraints(emailAddressLabel, 1, 4);



        Label quantityLabel = new Label("Qty");
        GridPane.setConstraints(quantityLabel, 0, 5);
        Label quantityLabel1 = new Label("");
        GridPane.setConstraints(quantityLabel1, 0, 6);

        Label brandLabel = new Label("Brand");
        GridPane.setConstraints(brandLabel, 1, 5);
        Label brandLabel1 = new Label("");
        GridPane.setConstraints(brandLabel1, 1, 6);

        Label modelLabel = new Label("Model");
        GridPane.setConstraints(modelLabel, 2, 5);
        Label modelLabel1 = new Label("");
        GridPane.setConstraints(modelLabel1, 2, 6);

        Label typeLabel = new Label("Type");
        GridPane.setConstraints(typeLabel, 3, 5);
        Label typeLabel1 = new Label("");
        GridPane.setConstraints(typeLabel1, 3, 6);

        Label priceLabel = new Label("Price");
        GridPane.setConstraints(priceLabel, 4, 5);
        Label priceLabel1 = new Label("");
        GridPane.setConstraints(priceLabel1, 4, 6);



        Label totalPriceLabel = new Label("Total price");
        GridPane.setConstraints(totalPriceLabel, 0, 7);



        confirmButton = new Button("Confirm");
        GridPane.setConstraints(confirmButton, 0, 8);


        gridPane.getChildren().addAll(customerLabel, fullNameLabel, streetAddressLabel, cityLocationLabel,
                phoneNumberLabel, emailAddressLabel, quantityLabel,quantityLabel1, brandLabel,
                brandLabel1, modelLabel, modelLabel1, typeLabel, typeLabel1, priceLabel, priceLabel1,
                totalPriceLabel, confirmButton);

        vBox.getChildren().addAll(gridPane);

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Confirm order");
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    public Label getQuantityLbl() {
        return quantityLbl;
    }

    public void setQuantityLbl(Label quantityLbl) {
        this.quantityLbl = quantityLbl;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
}
