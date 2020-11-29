package nl.inholland.endassignment.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.Role;
import nl.inholland.endassignment.model.User;
import nl.inholland.endassignment.util.SystemProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Dashboard extends Exception{

    private Stage stage;
    private VBox vBox;
    private GridPane gridPane;
    final Pane cardsPane = new StackPane();

    private LocalDate localDate;
    private MenuItem homeMenuItem;
    private MenuItem salesMenuItem;
    private MenuItem listOrderMenuItem;
    private MenuItem orderMenuItem;
    private MenuItem maintainMenuItem;
    private Database database;
    private User user;
    private Label firstNameLbl;
    private CreateOrder order;

    public CreateOrder getOrder(){
        return order;
    }

    public Dashboard(User user) {
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

        VBox vBox = new VBox();

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label welcomeLabel = new Label("Welcome " + user.firstName + " " + user.lastName);
        welcomeLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        GridPane.setConstraints(welcomeLabel, 0, 0);

        Label roleLabel = new Label("You`re role is: " + user.enummer.toString());
        GridPane.setConstraints(roleLabel, 0, 1);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat();
        String stringDate = dateFormat.format(date);
        Label dateLabel = new Label("Today is: " + (stringDate));
        GridPane.setConstraints(dateLabel, 0, 2);

        gridPane.getChildren().addAll(welcomeLabel, roleLabel, dateLabel);
        gridPane.setAlignment(Pos.TOP_LEFT);

        // add a layout node and controls
        vBox.getChildren().addAll(menuBar, gridPane);
        //root = vBox;

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.setWidth(SystemProperties.getScreenSize()[0] - 100);
        stage.setHeight(SystemProperties.getScreenSize()[1] - 100);

        if (user.enummer == Role.ADMIN) {
            orderMenuItem.setVisible(false);

        } else if (user.enummer == Role.SALES) {
            stockMenu.setVisible(false);
        }

        orderMenuItem.setOnAction(actionEvent -> {
            CreateOrder order = new CreateOrder(user, database);
            gridPane.getChildren().clear();
            gridPane.getChildren().add(order.getvBox());
            stage.setTitle("Create an Order");

        });


        listOrderMenuItem.setOnAction(actionEvent -> {
            OrderList order = new OrderList(user);
            gridPane.getChildren().clear();
            gridPane.getChildren().add(order.getvBox());
            stage.setTitle("View Order List");
        });


        maintainMenuItem.setOnAction(actionEvent -> {

            Stock stock = new Stock(user);
            gridPane.getChildren().clear();
            gridPane.getChildren().add(stock.getvBox());
            stage.setTitle("View Stock List");
        });

    }

    public Stage getStage() {
        return stage;
    }

    public Label getFirstNameLbl() {
        return firstNameLbl;
    }

    public void setFirstNameLbl(Label firstNameLbl) {
        this.firstNameLbl = firstNameLbl;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public MenuItem getHomeMenuItem() {
        return homeMenuItem;
    }

    public void setHomeMenuItem(MenuItem homeMenuItem) {
        this.homeMenuItem = homeMenuItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MenuItem getSalesMenuItem() {
        return salesMenuItem;
    }

    public void setSalesMenuItem(MenuItem salesMenuItem) {
        this.salesMenuItem = salesMenuItem;
    }

    public MenuItem getListOrderMenuItem() {
        return listOrderMenuItem;
    }

    public void setListOrderMenuItem(MenuItem listOrderMenuItem) {
        this.listOrderMenuItem = listOrderMenuItem;
    }

    public MenuItem getOrderMenuItem() {
        return orderMenuItem;
    }

    public void setOrderMenuItem(MenuItem orderMenuItem) {
        this.orderMenuItem = orderMenuItem;
    }

    public MenuItem getMaintainMenuItem() {
        return maintainMenuItem;
    }

    public void setMaintainMenuItem(MenuItem maintainMenuItem) {
        this.maintainMenuItem = maintainMenuItem;
    }
}
