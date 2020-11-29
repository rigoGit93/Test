package nl.inholland.endassignment.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.*;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class OrderList {

    private Stage stage;
    private Parent root;
    private VBox vBox;
    private HBox hBox;
    private User user;
    private Database database;

    private TableView<Customer> orderListTableView;
    private TableColumn<Customer, String> orderNumberColumn;
    private TableColumn<Customer, String> dateColumn;
    private TableColumn<Customer, String> customerNameColumn;
    private TableColumn<Customer, String> cityLocationColumn;
    private TableColumn<Customer, String> phoneNumberColumn;
    private TableColumn<Customer, String> emailAddressColumn;
    private TableColumn<Customer, String> countColumn;
    private TableColumn<Customer, String> totalColumn;

    private TableView<Article> orderDetailsTableView;
    private TableColumn<Article, String> uuidColumn;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private TableColumn<Article, String> priceColumn;
    private TableColumn<Article, String> quantityColumn;

    public OrderList(User user) {

        this.user = user;
        initLayout();
    }

    private void initLayout() {
        Label orderListLabel = new Label("Order List");
        database = Login.database;

        TableView<Order> orderListTableView = new TableView<>();
        orderListTableView.setMaxHeight(250);
        orderListTableView.setEditable(true);
        orderListTableView.getSelectionModel().setCellSelectionEnabled(false);
        orderListTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<Order, String> orderNumberColumn = new TableColumn<>("Order#");
        orderNumberColumn.setMinWidth(150);
        orderNumberColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));

        TableColumn dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(150);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        TableColumn customerNameColumn = new TableColumn<>("Customer name");
        customerNameColumn.setMinWidth(150);
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn cityLocationColumn = new TableColumn<>("City");
        cityLocationColumn.setMinWidth(150);
        cityLocationColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn phoneNumberColumn = new TableColumn<>("Phone #");
        phoneNumberColumn.setMinWidth(150);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn emailAddressColumn = new TableColumn<>("Email address");
        emailAddressColumn.setMinWidth(150);
        emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

        TableColumn countColumn = new TableColumn<>("Count");
        countColumn.setMinWidth(150);
        countColumn.setCellValueFactory(new PropertyValueFactory<>("articleCount"));

        TableColumn totalColumn = new TableColumn<>("Total");
        totalColumn.setMinWidth(150);
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        orderListTableView.getColumns().addAll(orderNumberColumn, dateColumn, customerNameColumn, cityLocationColumn,
                phoneNumberColumn, emailAddressColumn, countColumn, totalColumn);

        orderListTableView.getItems().addAll(FXCollections.observableArrayList(database.getOrderList()));

        Label orderDetailsListLabel = new Label("Details");

        TableView<OrderExample> orderDetailsTableView = new TableView<>();
        orderDetailsTableView.setMaxHeight(250);
        orderDetailsTableView.setEditable(true);
        orderDetailsTableView.getSelectionModel().setCellSelectionEnabled(false);
        orderDetailsTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        /*TableColumn uuidColumn = new TableColumn<>("Uuid");
        uuidColumn.setMinWidth(150);
        uuidColumn.setCellValueFactory(new PropertyValueFactory<>("uuid"));*/

        TableColumn brandColumn = new TableColumn<>("Brand");
        brandColumn.setMinWidth(150);
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn modelColumn = new TableColumn<>("Model");
        modelColumn.setMinWidth(150);
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn acousticColumn = new TableColumn<>("Acoustic");
        acousticColumn.setMinWidth(150);
        acousticColumn.setCellValueFactory(new PropertyValueFactory<>("acoustic"));

        TableColumn typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(150);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        orderDetailsTableView.getColumns().addAll(brandColumn, modelColumn, acousticColumn,
                typeColumn, priceColumn, quantityColumn);

        orderListTableView.setOnMouseClicked(event -> {
            if(orderListTableView.getSelectionModel().getSelectedIndex() > -1) {
                orderDetailsTableView.getItems().clear();
                orderDetailsTableView.getItems().addAll(orderListTableView.getSelectionModel().getSelectedItem().getOrderExample());
            }
        });

        vBox = new VBox();
        vBox.getChildren().addAll(orderListLabel, orderListTableView, orderDetailsListLabel, orderDetailsTableView);
    }

    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public TableView<Customer> getOrderListTableView() {
        return orderListTableView;
    }

    public void setOrderListTableView(TableView<Customer> orderListTableView) {
        this.orderListTableView = orderListTableView;
    }

    public TableColumn<Customer, String> getOrderNumberColumn() {
        return orderNumberColumn;
    }

    public void setOrderNumberColumn(TableColumn<Customer, String> orderNumberColumn) {
        this.orderNumberColumn = orderNumberColumn;
    }

    public TableColumn<Customer, String> getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(TableColumn<Customer, String> dateColumn) {
        this.dateColumn = dateColumn;
    }

    public TableColumn<Customer, String> getCustomerNameColumn() {
        return customerNameColumn;
    }

    public void setCustomerNameColumn(TableColumn<Customer, String> customerNameColumn) {
        this.customerNameColumn = customerNameColumn;
    }

    public TableColumn<Customer, String> getCityLocationColumn() {
        return cityLocationColumn;
    }

    public void setCityLocationColumn(TableColumn<Customer, String> cityLocationColumn) {
        this.cityLocationColumn = cityLocationColumn;
    }

    public TableColumn<Customer, String> getPhoneNumberColumn() {
        return phoneNumberColumn;
    }

    public void setPhoneNumberColumn(TableColumn<Customer, String> phoneNumberColumn) {
        this.phoneNumberColumn = phoneNumberColumn;
    }

    public TableColumn<Customer, String> getEmailAddressColumn() {
        return emailAddressColumn;
    }

    public void setEmailAddressColumn(TableColumn<Customer, String> emailAddressColumn) {
        this.emailAddressColumn = emailAddressColumn;
    }

    public TableColumn<Customer, String> getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(TableColumn<Customer, String> countColumn) {
        this.countColumn = countColumn;
    }

    public TableColumn<Customer, String> getTotalColumn() {
        return totalColumn;
    }

    public void setTotalColumn(TableColumn<Customer, String> totalColumn) {
        this.totalColumn = totalColumn;
    }

    public TableView<Article> getOrderDetailsTableView() {
        return orderDetailsTableView;
    }

    public void setOrderDetailsTableView(TableView<Article> orderDetailsTableView) {
        this.orderDetailsTableView = orderDetailsTableView;
    }

    public TableColumn<Article, String> getUuidColumn() {
        return uuidColumn;
    }

    public void setUuidColumn(TableColumn<Article, String> uuidColumn) {
        this.uuidColumn = uuidColumn;
    }

    public TableColumn<Article, String> getBrandColumn() {
        return brandColumn;
    }

    public void setBrandColumn(TableColumn<Article, String> brandColumn) {
        this.brandColumn = brandColumn;
    }

    public TableColumn<Article, String> getModelColumn() {
        return modelColumn;
    }

    public void setModelColumn(TableColumn<Article, String> modelColumn) {
        this.modelColumn = modelColumn;
    }

    public TableColumn<Article, String> getAcousticColumn() {
        return acousticColumn;
    }

    public void setAcousticColumn(TableColumn<Article, String> acousticColumn) {
        this.acousticColumn = acousticColumn;
    }

    public TableColumn<Article, String> getTypeColumn() {
        return typeColumn;
    }

    public void setTypeColumn(TableColumn<Article, String> typeColumn) {
        this.typeColumn = typeColumn;
    }

    public TableColumn<Article, String> getPriceColumn() {
        return priceColumn;
    }

    public void setPriceColumn(TableColumn<Article, String> priceColumn) {
        this.priceColumn = priceColumn;
    }

    public TableColumn<Article, String> getQuantityColumn() {
        return quantityColumn;
    }

    public void setQuantityColumn(TableColumn<Article, String> quantityColumn) {
        this.quantityColumn = quantityColumn;
    }
}
