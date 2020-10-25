package nl.inholland.endassignment.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.*;

public class OrderList {

    private Stage stage;
    private Parent root;
    private VBox vBox;
    private HBox hBox;
    private MenuItem homeMenuItem;
    private MenuItem salesMenuItem;
    private MenuItem listOrderMenuItem;
    private MenuItem orderMenuItem;
    private MenuItem maintainMenuItem;
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

        //Menu
        MenuBar menuBar = new MenuBar();
        Menu homeMenu = new Menu("Home");
        Menu salesMenu = new Menu("Sales");
        Menu stockMenu = new Menu("Stock");
        Menu managerSalesMenu = new Menu("Sales");

        //sorteer menu toegevoegd
        menuBar.getMenus().addAll(homeMenu, salesMenu, stockMenu);

        //salesmenu en homemenu
        orderMenuItem = new MenuItem("Order");
        listOrderMenuItem = new MenuItem("List orders");
        maintainMenuItem = new MenuItem("Maintain");
        salesMenu.getItems().addAll(orderMenuItem, listOrderMenuItem);
        stockMenu.getItems().addAll(maintainMenuItem);
        //managerSalesMenu.getItems().addAll(listOrderMenuItem);

        Label orderListLabel = new Label("Order List");

        TableView<Customer> orderListTableView = new TableView<>();
        orderListTableView.setEditable(true);
        orderListTableView.getSelectionModel().setCellSelectionEnabled(false);
        orderListTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<Customer, String> orderNumberColumn = new TableColumn<>("Order Number");
        orderNumberColumn.setMinWidth(150);
        orderNumberColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));

        TableColumn<Customer, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(150);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Customer, String> customerNameColumn = new TableColumn<>("Customer name");
        customerNameColumn.setMinWidth(150);
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Customer, String> cityLocationColumn = new TableColumn<>("City");
        cityLocationColumn.setMinWidth(150);
        cityLocationColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<Customer, String> phoneNumberColumn = new TableColumn<>("Phone #");
        phoneNumberColumn.setMinWidth(150);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Customer, String> emailAddressColumn = new TableColumn<>("Email address");
        emailAddressColumn.setMinWidth(150);
        emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

        TableColumn<Customer, String> countColumn = new TableColumn<>("Count");
        countColumn.setMinWidth(150);
        countColumn.setCellValueFactory(new PropertyValueFactory<>("count"));

        TableColumn<Customer, String> totalColumn = new TableColumn<>("Total");
        totalColumn.setMinWidth(150);
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));


        orderListTableView.getColumns().addAll(orderNumberColumn, dateColumn, customerNameColumn, cityLocationColumn,
                phoneNumberColumn, emailAddressColumn, countColumn, totalColumn);


        Label orderDetailsListLabel = new Label("Details");

        TableView<Customer> orderDetailsTableView = new TableView<>();
        orderDetailsTableView.setEditable(true);
        orderDetailsTableView.getSelectionModel().setCellSelectionEnabled(false);
        orderDetailsTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<Customer, String> uuidColumn = new TableColumn<>("Uuid");
        uuidColumn.setMinWidth(150);
        uuidColumn.setCellValueFactory(new PropertyValueFactory<>("uuid"));

        TableColumn<Customer, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setMinWidth(150);
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Customer, String> modelColumn = new TableColumn<>("Model");
        modelColumn.setMinWidth(150);
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Customer, String> acousticColumn = new TableColumn<>("Acoustic");
        acousticColumn.setMinWidth(150);
        acousticColumn.setCellValueFactory(new PropertyValueFactory<>("acoustic"));

        TableColumn<Customer, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(150);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Customer, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Customer, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        orderDetailsTableView.getColumns().addAll(uuidColumn, brandColumn, modelColumn, acousticColumn,
                typeColumn, priceColumn, quantityColumn);

        vBox = new VBox();
        vBox.getChildren().addAll(orderListLabel, orderListTableView, orderDetailsListLabel, orderDetailsTableView);


        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("View Order List");
        stage.setScene(scene);


        if (user.enummer == Role.ADMIN) {
            orderMenuItem.setVisible(false);
        } else if (user.enummer == Role.SALES) {
            stockMenu.setVisible(false);
        }

//        listOrderMenuItem.setOnAction(actionEvent -> {
//
//            OrderList orderList = new OrderList();
//            orderList.getStage().showAndWait();
//        });

        orderMenuItem.setOnAction(actionEvent -> {

            CreateOrder order = new CreateOrder(user, database);
            order.getStage().showAndWait();
        });

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
