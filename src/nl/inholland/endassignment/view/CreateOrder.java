package nl.inholland.endassignment.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.endassignment.model.Article;

public class CreateOrder extends Views{

    private Parent root;
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
    private HBox hBox;


    private TableView<Article> articleTableView;
    private TableColumn<Article, String> quantityColumn;
    private TableColumn<Article, String> brandColulmn;
    private TableColumn<Article, String> modelColulmn;
    private TableColumn<Article, String> acousticColulmn;
    private TableColumn<Article, String> typeColulmn;
    private TableColumn<Article, String> priceColulmn;

    public CreateOrder(){initLayout();};

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

        gridPane = new GridPane();

        gridPane.setPadding(new Insets(100, 100, 100, 100));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label titleLabel = new Label("Create Order ");
        gridPane.add(titleLabel, 0, 0);

        Label customerLabel = new Label("Customer");
        gridPane.add(titleLabel, 0, 1);

        customerSearchInput = new TextField();
        customerSearchInput.setPromptText("username");
        gridPane.add(customerSearchInput, 0, 2);

        searchButton = new Button("Login");
        gridPane.add(searchButton, 1, 2);

        Label articlesLabel = new Label("Articles ");
        gridPane.add(titleLabel, 0, 3);

        articleTableView = new TableView();
        articleTableView.setEditable(true);

        //id Column settings
        quantityColumn = new TableColumn("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityColumn.setPrefWidth(50);

        brandColulmn = new TableColumn("Brand");
        brandColulmn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        brandColulmn.setPrefWidth(50);

        modelColulmn = new TableColumn("Model");
        modelColulmn.setCellValueFactory(new PropertyValueFactory<>("model"));
        modelColulmn.setPrefWidth(50);

        acousticColulmn = new TableColumn("Acoustic");
        acousticColulmn.setCellValueFactory(new PropertyValueFactory<>("acoustic"));
        acousticColulmn.setPrefWidth(50);

        typeColulmn = new TableColumn("Type");
        typeColulmn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColulmn.setPrefWidth(50);

        priceColulmn = new TableColumn("price");
        priceColulmn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColulmn.setPrefWidth(50);

        //columns into the tableview
        articleTableView.getColumns().addAll(quantityColumn, brandColulmn, modelColulmn, acousticColulmn,
                typeColulmn, priceColulmn);

        addButton= new Button("Add");
        deleteButton= new Button("Delete");
        confirmButton= new Button("Confirm");
        resetButton= new Button("Reset");

        hBox = new HBox();
        hBox.getChildren().addAll(addButton,deleteButton,confirmButton,resetButton);

        vBox = new VBox();
        vBox.getChildren().addAll(salesBar, gridPane, hBox);

        root = vBox;

    }

    public void setRoot(Parent root) {
        this.root = root;
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

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public TableView<Article> getArticleTableView() {
        return articleTableView;
    }

    public void setArticleTableView(TableView<Article> articleTableView) {
        this.articleTableView = articleTableView;
    }

    public TableColumn<Article, String> getQuantityColumn() {
        return quantityColumn;
    }

    public void setQuantityColumn(TableColumn<Article, String> quantityColumn) {
        this.quantityColumn = quantityColumn;
    }

    public TableColumn<Article, String> getBrandColulmn() {
        return brandColulmn;
    }

    public void setBrandColulmn(TableColumn<Article, String> brandColulmn) {
        this.brandColulmn = brandColulmn;
    }

    public TableColumn<Article, String> getModelColulmn() {
        return modelColulmn;
    }

    public void setModelColulmn(TableColumn<Article, String> modelColulmn) {
        this.modelColulmn = modelColulmn;
    }

    public TableColumn<Article, String> getAcousticColulmn() {
        return acousticColulmn;
    }

    public void setAcousticColulmn(TableColumn<Article, String> acousticColulmn) {
        this.acousticColulmn = acousticColulmn;
    }

    public TableColumn<Article, String> getTypeColulmn() {
        return typeColulmn;
    }

    public void setTypeColulmn(TableColumn<Article, String> typeColulmn) {
        this.typeColulmn = typeColulmn;
    }

    public TableColumn<Article, String> getPriceColulmn() {
        return priceColulmn;
    }

    public void setPriceColulmn(TableColumn<Article, String> priceColulmn) {
        this.priceColulmn = priceColulmn;
    }

    @Override
    public Parent getRoot() {
        return root;
    }
}
