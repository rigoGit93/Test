package nl.inholland.endassignment.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Dashboard {

    private Stage stage;
    //private Parent root;
    private VBox vBox;
    private LocalDate localDate;
    private MenuItem homeMenuItem;
    private MenuItem salesMenuItem;
    private MenuItem listOrderMenuItem;
    private MenuItem orderMenuItem;
    private MenuItem maintainMenuItem;


    public Dashboard() {
        initLayout();
    }

    private void initLayout(){

        //Menu
        MenuBar salesBar = new MenuBar();
        MenuBar managerBar = new MenuBar();
        Menu homeMenu = new Menu("Home");
        Menu salesMenu = new Menu("Sales");
        Menu stockMenu = new Menu("Stock");
        Menu managerSalesMenu = new Menu("Sales");

        //sorteer menu toegevoegd
        salesBar.getMenus().addAll(homeMenu, salesMenu);
        managerBar.getMenus().addAll(homeMenu,managerSalesMenu, stockMenu);

        //salesmenu en homemenu
        orderMenuItem = new MenuItem("Order");
        listOrderMenuItem = new MenuItem("List orders");
        maintainMenuItem = new MenuItem("Maintain");
        salesMenu.getItems().addAll(orderMenuItem, listOrderMenuItem);
        stockMenu.getItems().addAll(maintainMenuItem);
        managerSalesMenu.getItems().addAll(listOrderMenuItem);

        VBox vBox = new VBox();

        Label welcomeLabel = new Label("Welcome ");

        Label roleLabel = new Label("You`re role is: ");

        Label dateLabel = new Label("Today is: ");

        // add a layout node and controls
        vBox.getChildren().addAll(salesBar, welcomeLabel, roleLabel, dateLabel);
        //root = vBox;

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(scene);

    }

//    @Override
//    public Parent getRoot() {
//        return root;
//    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

//    public void setRoot(Parent root) {
//        this.root = root;
//    }

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
