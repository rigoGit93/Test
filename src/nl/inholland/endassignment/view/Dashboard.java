package nl.inholland.endassignment.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.Role;
import nl.inholland.endassignment.model.User;
import nl.inholland.endassignment.util.ExitModal;
import nl.inholland.endassignment.util.SystemProperties;
import nl.inholland.endassignment.util.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Dashboard{

    private Stage stage;
    private VBox vBox;
    private GridPane gridPane;
    final Pane cardsPane = new StackPane();

    private LocalDate localDate;
    private MenuItem homeMenuItem;
    private MenuItem salesMenuItem;
    private MenuItem userDetailsMenuItem;
    private MenuItem logoutMenuItem;
    private MenuItem listOrderMenuItem;
    private MenuItem orderMenuItem;
    private MenuItem maintainMenuItem;
    private Database database;
    private User user;
    private Label firstNameLbl;
    private CreateOrder order;

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


        //sorteer menu toegevoegd
        menuBar.getMenus().addAll(homeMenu, salesMenu, stockMenu);

        //salesmenu en homemenu
        orderMenuItem = new MenuItem("Order");
        userDetailsMenuItem = new MenuItem("User Details");
        logoutMenuItem = new MenuItem("Log Out");
        listOrderMenuItem = new MenuItem("List orders");
        maintainMenuItem = new MenuItem("Maintain");
        homeMenu.getItems().addAll(userDetailsMenuItem, logoutMenuItem);
        salesMenu.getItems().addAll(orderMenuItem, listOrderMenuItem);
        stockMenu.getItems().addAll(maintainMenuItem);

        VBox vBox = new VBox();

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label welcomeLabel = new Label("Welcome " + user.firstName + " " + user.lastName);
        welcomeLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        GridPane.setConstraints(welcomeLabel, 0, 0);

        Label roleLabel = new Label("Your role is: " + user.enummer.toString());
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

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.setWidth(SystemProperties.getScreenSize()[0] - 100);
        stage.setHeight(SystemProperties.getScreenSize()[1] - 100);

        stage.setOnCloseRequest(event -> {
            event.consume();
            ExitModal modal = new ExitModal("Info", "Close the window?", stage);
        });

        if (user.enummer == Role.ADMIN) {
            orderMenuItem.setVisible(false);

        } else if (user.enummer == Role.SALES) {
            stockMenu.setVisible(false);
        }

        userDetailsMenuItem.setOnAction(actionEvent -> {
            gridPane.getChildren().clear();
            gridPane.getChildren().addAll(welcomeLabel, roleLabel, dateLabel);
            stage.setTitle("Dashboard");
        });

        logoutMenuItem.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,  "Are you sure you want to logout?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES){
                System.exit(1);
            }
        });


        orderMenuItem.setOnAction(actionEvent -> {
            CreateOrder order = new CreateOrder(this);
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

    public User getUser(){
        return this.user;
    }

    public GridPane getGridPane(){
        return this.gridPane;
    }

    public Stage getStage() {
        return stage;
    }

}
