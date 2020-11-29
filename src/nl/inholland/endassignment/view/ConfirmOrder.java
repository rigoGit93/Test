package nl.inholland.endassignment.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.*;
import nl.inholland.endassignment.util.SystemProperties;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class ConfirmOrder {

    private Stage stage;
    private Button confirmButton;
    private Label quantityLbl;
    private VBox vBox;
    private GridPane gridPane;
    private CreateOrder createOrder;
    private Customer customer;
    private Database database;
    private ObservableList<OrderExample> orders;
    private long orderNum;
    private double total;

    public ConfirmOrder(CreateOrder createOrder) {
        this.createOrder = createOrder;
        this.customer = this.createOrder.getCustomer();
        this.orders = this.createOrder.getOrders();
        this.orderNum = this.createOrder.getOrderNumber();

        for(OrderExample order: this.orders){
            this.customer.getArticlelist().add(new Article(order.getQuantity(), order.getBrand(), order.getModel(), order.isAcoustic(), order.getType(), order.getPrice()));
        }

        initLayout();
    }

    private void initLayout() {

        gridPane = new GridPane();
        vBox = new VBox();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label customerLabel = new Label("Customer: ");
        customerLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        GridPane.setConstraints(customerLabel, 0, 0);

        Label fullNameLabel = new Label(this.customer.getFirstName() + " " + this.customer.getLastName());
        GridPane.setConstraints(fullNameLabel, 1, 0);

        Label streetAddressLabel = new Label(this.customer.getStreetAddress());
        GridPane.setConstraints(streetAddressLabel, 1,1);

        Label cityLocationLabel = new Label(this.customer.getCityLocation());
        GridPane.setConstraints(cityLocationLabel, 1, 2);

        Label phoneNumberLabel = new Label(Long.toString(this.customer.getPhoneNumber()));
        GridPane.setConstraints(phoneNumberLabel, 1, 3);

        Label emailAddressLabel = new Label(this.customer.getEmailAddress());
        GridPane.setConstraints(emailAddressLabel, 1, 4);

        Label quantityLabel = new Label("Qty");
        quantityLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setConstraints(quantityLabel, 0, 5);

        Label brandLabel = new Label("Brand");
        brandLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setConstraints(brandLabel, 1, 5);

        Label modelLabel = new Label("Model");
        modelLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setConstraints(modelLabel, 2, 5);

        Label typeLabel = new Label("Type");
        typeLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setConstraints(typeLabel, 3, 5);

        Label priceLabel = new Label("Price");
        priceLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setConstraints(priceLabel, 4, 5);

        gridPane.getChildren().addAll(customerLabel, fullNameLabel, streetAddressLabel, cityLocationLabel,
                phoneNumberLabel, emailAddressLabel, quantityLabel, brandLabel,
                modelLabel, typeLabel, priceLabel);

        total = 0;

        for(int i = 0; i < orders.size(); i++){
            Label quantityLabel1 = new Label(Integer.toString(orders.get(i).getQuantity()));
            GridPane.setConstraints(quantityLabel1, 0, i + 6);

            Label brandLabel1 = new Label(orders.get(i).getBrand());
            GridPane.setConstraints(brandLabel1, 1, i + 6);

            Label modelLabel1 = new Label(orders.get(i).getModel());
            GridPane.setConstraints(modelLabel1, 2, i + 6);

            Label typeLabel1 = new Label(orders.get(i).getType().name());
            GridPane.setConstraints(typeLabel1, 3, i + 6);

            Label priceLabel1 = new Label(Double.toString(orders.get(i).getPrice()));
            GridPane.setConstraints(priceLabel1, 4, i + 6);

            gridPane.getChildren().addAll(quantityLabel1, brandLabel1, modelLabel1, typeLabel1, priceLabel1);

            total += orders.get(i).getPrice() * orders.get(i).getQuantity();
        }

        Label totalPriceLabel = new Label("Total price: " + Double.toString(total));
        GridPane.setConstraints(totalPriceLabel, 0, orders.size() + 7);

        confirmButton = new Button("Confirm");
        GridPane.setConstraints(confirmButton, 0, orders.size() + 8);

        gridPane.getChildren().addAll(totalPriceLabel, confirmButton);

        vBox.getChildren().addAll(gridPane);

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Confirm order");
        stage.setScene(scene);
        stage.setWidth(SystemProperties.getScreenSize()[0]/3.0);

        confirmButton.setOnAction(actionEvent -> {
            database = Login.database;
            LocalDate date = LocalDate.now();
            database.getOrderList().add(new Order((int) orderNum, date,
                    customer.getFirstName() + " " + customer.getLastName(),
                    customer.getCityLocation(), customer.getPhoneNumber(), customer.getEmailAddress(),
                    orders, orders.size(), total));
            stage.close();
        });

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
