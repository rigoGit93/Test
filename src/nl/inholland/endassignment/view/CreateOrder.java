package nl.inholland.endassignment.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.*;

import java.util.ArrayList;

public class CreateOrder {

    private Stage stage;
    private GridPane gridPane;
    private TextField customerSearchInput;
    private Button searchButton;
    private Button addButton;
    private Button deleteButton;
    private Button confirmButton;
    private Button resetButton;
    private MenuItem homeMenuItem;
    private MenuItem salesMenuItem;
    private MenuItem listOrderMenuItem;
    private MenuItem orderMenuItem;
    private MenuItem maintainMenuItem;
    private VBox vBox;
    private HBox hBoxButton;
    private HBox hBoxSearchCustomer;
    private HBox hBoxShowCustomer;
    private VBox hBoxFspCustomer;
    private VBox hBoxLceCustomer;
    private HBox hBoxCustomerInfo;
    private User user;
    private Database db;
    private ObservableList<Customer> customers;
    private CustomerView customerView;
    private ObservableList<Article> articles;
    private TableView<OrderExample> addArticleTableView;

    private Label customerFirstNameLabel;
    private Label customerLastNameLbl;
    private Label customerstrNameLbl;
    private Label customermailLbl;
    private Label customerphoneLbl;
    private Label customercityLbl;
    private ObservableList<Customer> customer;


    private static TableView<OrderExample> articleTableView;
    private TableColumn<Article, String> quantityColumn;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private TableColumn<Article, String> priceColumn;
    private AddArticle addArticle;

    public CreateOrder(User user, Database database) {
        this.user = user;

        initLayout();
    }
    public CreateOrder(){
    }



    public void initLayout() {
        addArticle = new AddArticle();
        db = new Database();
        customers = FXCollections.observableArrayList(db.getCustomer());
        customerView = new CustomerView(this);
        articles = FXCollections.observableArrayList();

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

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label titleLabel = new Label("Create Order ");
        gridPane.add(titleLabel, 0, 0);

        Label customerLabel = new Label("Customer");
        gridPane.add(customerLabel, 0, 1);

        customerSearchInput = new TextField();
        customerSearchInput.setPromptText("username");
        gridPane.add(customerSearchInput, 0, 2);

        searchButton = new Button("Search");
        gridPane.add(searchButton, 1, 2);


        /*
        Labels van de create order view
         */
        customerFirstNameLabel = new Label();
        customerstrNameLbl = new Label();
        customerphoneLbl = new Label();

        customerLastNameLbl = new Label();
        customercityLbl = new Label();
        customermailLbl = new Label();

        Label articleLabel = new Label("Articles ");
        gridPane.add(articleLabel, 0, 3);

        /*
        Setting up the grades table view
         */
        TableView<OrderExample> articleTableView = new TableView<>();
        articleTableView.setEditable(true);
        articleTableView.getSelectionModel().setCellSelectionEnabled(false);
        articleTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.articleTableView = new TableView();
        this.articleTableView.setEditable(true);

        /*
        Colums worden geinitialiseerd.
         */

        TableColumn quantityColumn = new TableColumn("Quantity");
        quantityColumn.setMinWidth(150);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("quantity"));

        TableColumn brandColumn = new TableColumn("Brand");
        brandColumn.setMinWidth(120);
        brandColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("brand"));

        TableColumn modelColumn = new TableColumn("Model");
        modelColumn.setMinWidth(150);
        modelColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("model"));

        TableColumn acousticColumn = new TableColumn("Acoustic");
        acousticColumn.setMinWidth(120);
        acousticColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("acoustic"));

        TableColumn typeColumn = new TableColumn("Type");
        typeColumn.setMinWidth(150);
        typeColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("type"));

        TableColumn priceColumn = new TableColumn("Price");
        priceColumn.setMinWidth(50);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("price"));

        articleTableView.getColumns().addAll(quantityColumn, brandColumn, modelColumn, acousticColumn, typeColumn,
                priceColumn);

//        addArticle.getDb().getOrderExamples().add(1, "Fender", "Telecaster", false, GuitarType.REGULAR,
//                1079.79);

        ArrayList<OrderExample> ar = new ArrayList<>();
        ar.add(new OrderExample(1, "Fender", "Telecaster", false, GuitarType.REGULAR, 1079.79));

        ObservableList<OrderExample> oAr = FXCollections.observableArrayList(ar);
        //articleTableView.setItems(oAr);

        //ar.addAll(addArticle.getDb().getOrderExamples());

        //ObservableList<OrderExample> oList = FXCollections.observableArrayList(addArticle.getDb().getOrderExamples());
        ObservableList<OrderExample> articleOList = null;
        try {
            System.out.println("IK BEN NOG NIEEEEET EMPTY");
            articleOList = FXCollections.observableArrayList(AddArticle.getoList());
            System.out.println(articleOList);
        } catch (NullPointerException ex){
            System.out.println("IK BE NOG EMPTY \n" +ex);
        }


        if(articleOList != null) {
            try {
                System.out.println("IK BEN NIET EMPTY");
                articleTableView.setItems(articleOList);
                articleTableView.refresh();
                //articleTableView.insert
            } catch (NullPointerException ex){
                System.out.println(ex);
            }
        }

//        articleTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Article>() {
//            @Override
//            public void changed(ObservableValue<? extends Article> observable, Article oldValue, Article newValue) {
//                articles.clear();
////                articles.add(newValue.getQuantity(), newValue.getBrand(), newValue.getBrand(), newValue.getModel(),
////                        newValue.getAcoustic(), newValue.getType(), newValue.getPrice());
//            }
//        });

        addButton = new Button("Add");
        deleteButton = new Button("Delete");
        confirmButton = new Button("Confirm");
        resetButton = new Button("Reset");

        hBoxSearchCustomer = new HBox();
        hBoxSearchCustomer.getChildren().addAll(customerSearchInput, searchButton);

        hBoxFspCustomer = new VBox();
        hBoxFspCustomer.getChildren().addAll(customerFirstNameLabel, customerstrNameLbl, customerphoneLbl);
        hBoxFspCustomer.setPadding(new Insets(10, 10, 10, 10));

        hBoxLceCustomer = new VBox();
        hBoxLceCustomer.getChildren().addAll(customerLastNameLbl, customercityLbl, customermailLbl);
        hBoxLceCustomer.setPadding(new Insets(10, 10, 10, 10));

        hBoxShowCustomer = new HBox();
        hBoxShowCustomer.getChildren().addAll(hBoxFspCustomer, hBoxLceCustomer);

        hBoxCustomerInfo = new HBox();
        hBoxCustomerInfo.getChildren().addAll(hBoxSearchCustomer, hBoxShowCustomer);

        hBoxButton = new HBox();
        hBoxButton.getChildren().addAll(addButton, deleteButton, confirmButton, resetButton);

        vBox = new VBox();
        vBox.getChildren().addAll(menuBar, gridPane, hBoxCustomerInfo, articleTableView, hBoxButton);

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Create an Order");
        stage.setScene(scene);


        /*
         * Laat menu zien op basis van role
         */

        if (user.enummer == Role.ADMIN) {
            orderMenuItem.setVisible(false);
        } else if (user.enummer == Role.SALES) {
            stockMenu.setVisible(false);
        }


        /*
         * verwijst naar CustomerView
         */
        searchButton.setOnAction(actionEvent -> {

            CustomerView customerView = new CustomerView(this);
            customerView.getStage().showAndWait();
        });

        addButton.setOnAction(actionEvent -> {
            AddArticle customerView = new AddArticle();
            customerView.getStage().showAndWait();
        });
        resetButton.setOnAction(actionEvent -> {
            System.out.println("REFRESHING");
            initLayout();
            articleTableView.refresh();
        });
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public TextField getCustomerSearchInput() {
        return customerSearchInput;
    }

    public void setCustomerSearchInput(TextField customerSearchInput) {
        this.customerSearchInput = customerSearchInput;
    }

    public void setCustomerFirstNameLabel(Label customerFirstNameLabel) {
        this.customerFirstNameLabel = customerFirstNameLabel;
    }

    public Label getCustomerFirstNameLabel() {
        return customerFirstNameLabel;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Button searchButton) {
        this.searchButton = searchButton;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public Label getCustomerLastNameLbl() {
        return customerLastNameLbl;
    }

    public void setCustomerLastNameLbl(Label customerLastNameLbl) {
        this.customerLastNameLbl = customerLastNameLbl;
    }

    public Label getCustomerstrNameLbl() {
        return customerstrNameLbl;
    }

    public void setCustomerstrNameLbl(Label customerstrNameLbl) {
        this.customerstrNameLbl = customerstrNameLbl;
    }

    public Label getCustomermailLbl() {
        return customermailLbl;
    }

    public void setCustomermailLbl(Label customermailLbl) {
        this.customermailLbl = customermailLbl;
    }

    public Label getCustomerphoneLbl() {
        return customerphoneLbl;
    }

    public void setCustomerphoneLbl(Label customerphoneLbl) {
        this.customerphoneLbl = customerphoneLbl;
    }

    public Label getCustomercityLbl() {
        return customercityLbl;
    }

    public void setCustomercityLbl(Label customercityLbl) {
        this.customercityLbl = customercityLbl;
    }

    public void setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public void setResetButton(Button resetButton) {
        this.resetButton = resetButton;
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

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }


    public static TableView<OrderExample> getArticleTableView() {
        return articleTableView;
    }

    public void setArticleTableView(TableView<OrderExample> articleTableView) {
        this.articleTableView = articleTableView;
    }

    public TableColumn<Article, String> getQuantityColumn() {
        return quantityColumn;
    }

    public void setQuantityColumn(TableColumn<Article, String> quantityColumn) {
        this.quantityColumn = quantityColumn;
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

}
