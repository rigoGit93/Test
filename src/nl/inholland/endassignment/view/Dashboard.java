package nl.inholland.endassignment.view;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class Dashboard extends Views {

    private Parent root;
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
        MenuBar menuBar = new MenuBar();
        Menu homeMenu = new Menu("Home");
        Menu salesMenu = new Menu("Sales");
        Menu stockMenu = new Menu("Stock");

        //sorteer menu toegevoegd
        menuBar.getMenus().addAll(homeMenu, salesMenu, stockMenu);

        //salesmenu en homemenu
        homeMenuItem = new MenuItem("Laden");
        salesMenuItem = new MenuItem("Opslaan");
        salesMenu.getItems().addAll(homeMenuItem);

        VBox vBox = new VBox();

        Label welcomeLabel = new Label("Welcome ");

        Label roleLabel = new Label("You`re role is: ");

        Label dateLabel = new Label("Today is: ");

        // add a layout node and controls
        vBox.getChildren().addAll(welcomeLabel, roleLabel, dateLabel);
        root = vBox;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
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
