package nl.inholland.endassignment.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.Role;
import nl.inholland.endassignment.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Dashboard {

    private Stage stage;
    private VBox vBox;
    private HBox hBoxName;
    private HBox hBoxRole;
    private HBox hBoxDate;
    private LocalDate localDate;
    private MenuItem homeMenuItem;
    private MenuItem salesMenuItem;
    private MenuItem listOrderMenuItem;
    private MenuItem orderMenuItem;
    private MenuItem maintainMenuItem;
    private Database database;
    private User user;
    private Label firstNameLbl;


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
        hBoxName = new HBox();
        hBoxRole = new HBox();
        hBoxDate = new HBox();

        hBoxName.setPadding(new Insets(10, 10, 10, 10));
        hBoxRole.setPadding(new Insets(10, 10, 10, 10));
        hBoxDate.setPadding(new Insets(10, 10, 10, 10));


        Label welcomeLabel = new Label("Welcome ");
        Label firstNameLabel = new Label();
        firstNameLabel.setText(user.firstName + " ");
        Label lastNameLabel = new Label();
        lastNameLabel.setText(user.lastName);

        hBoxName.getChildren().addAll(welcomeLabel, firstNameLabel, lastNameLabel);

        Label roleLabel = new Label("You`re role is: ");
        Label roleDisplayLabel = new Label();
        roleDisplayLabel.setText(user.enummer.toString());

        hBoxRole.getChildren().addAll(roleLabel, roleDisplayLabel);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat();
        String stringDate = dateFormat.format(date);
        Label dateLabel = new Label("Today is: " + (stringDate));
        hBoxDate.getChildren().addAll(dateLabel);


        // add a layout node and controls
        vBox.getChildren().addAll(menuBar, hBoxName, hBoxRole, hBoxDate);
        //root = vBox;

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(scene);

        if (user.enummer == Role.ADMIN) {
            orderMenuItem.setVisible(false);
        } else if (user.enummer == Role.SALES) {
            stockMenu.setVisible(false);
        }

        orderMenuItem.setOnAction(actionEvent -> {

            CreateOrder order = new CreateOrder(user);
            order.getStage().showAndWait();
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
