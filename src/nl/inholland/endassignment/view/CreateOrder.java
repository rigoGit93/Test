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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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

    private VBox vBox;
    private HBox hBoxButton;
    private HBox hBoxSearchCustomer;
    private HBox hBoxShowCustomer;
    private VBox hBoxFspCustomer;
    private VBox hBoxLceCustomer;
    private HBox hBoxCustomerInfo;
    private User user;
    private Database db;
    private Customer customer;
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

    private TableView<OrderExample> articleTableView;
    private TableColumn<Article, String> quantityColumn;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private TableColumn<Article, String> priceColumn;
    private AddArticle addArticle;

    public CreateOrder(User user, Database database) {
        this.user = user;
        this.db = database;

        initLayout();
    }
    public CreateOrder(){
    }

    public TableView<OrderExample> getAddArticleTableView() {
        return addArticleTableView;
    }

    public void initLayout() {
        db = Login.database;
        articles = FXCollections.observableArrayList(db.getArticlelist());
        customers = FXCollections.observableArrayList(db.getCustomer());
        customerView = new CustomerView(this);
        //articles = FXCollections.observableArrayList();


        gridPane = new GridPane();

        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label titleLabel = new Label("Create Order ");
        titleLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
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

        this.articleTableView = new TableView<>();
        articleTableView.setEditable(true);
        articleTableView.getSelectionModel().setCellSelectionEnabled(false);
        articleTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        /*
        Colums worden geinitialiseerd.
         */

        TableColumn quantityColumn = new TableColumn("Quantity");
        quantityColumn.setMinWidth(100);
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

        this.articleTableView.getColumns().addAll(quantityColumn, brandColumn, modelColumn, acousticColumn, typeColumn,
                priceColumn);

//        addArticle.getDb().getOrderExamples().add(1, "Fender", "Telecaster", false, GuitarType.REGULAR,
//                1079.79);

        ArrayList<OrderExample> ar = new ArrayList<>();
        ar.add(new OrderExample(1, "Fender", "Telecaster", false, GuitarType.REGULAR, 1079.79));

        ObservableList<OrderExample> oAr = FXCollections.observableArrayList(ar);

        ObservableList<OrderExample> articleOList = null;


        //Prepares the list
        try {
            System.out.println("IK BEN NOG NIEEEEET EMPTY");
            articleOList = FXCollections.observableArrayList(AddArticle.getoList());
            System.out.println(articleOList);
        } catch (NullPointerException ex){
            System.out.println("IK BE NOG EMPTY \n" +ex);
        }

        //Fills the table
        if(articleOList != null) {
            try {
                System.out.println("IK BEN NIET EMPTY");
                this.articleTableView.setItems(articleOList);
                this.articleTableView.refresh();
                //articleTableView.insert
            } catch (NullPointerException ex){
                System.out.println(ex);
            }
        }

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
        hBoxButton.setSpacing(10);
        hBoxButton.setPadding(new Insets(10, 10, 10, 10));

        vBox = new VBox();
        vBox.getChildren().addAll(gridPane, hBoxCustomerInfo, articleTableView, hBoxButton);

        /*
         * verwijst naar CustomerView
         */
        searchButton.setOnAction(actionEvent -> {
            CustomerView customerView = new CustomerView(this);
            customerView.getStage().showAndWait();
        });

        addButton.setOnAction(actionEvent -> {
            AddArticle customerView = new AddArticle(this.articleTableView, articles);
            customerView.getStage().showAndWait();
        });
        resetButton.setOnAction(actionEvent -> {
            ObservableList<OrderExample> observableList = this.articleTableView.getItems();
            for(int i=0; i < observableList.size(); i++){
                int quantity = observableList.get(i).getQuantity();
                if (observableList.get(i).getModel().equalsIgnoreCase("Telecaster")){
                    articles.get(0).setQuantity(articles.get(0).getQuantity() + quantity);
                }else if (observableList.get(i).getModel().equalsIgnoreCase("Precision")){
                    articles.get(1).setQuantity(articles.get(1).getQuantity() + quantity);
                }else{
                    articles.get(2).setQuantity(articles.get(2).getQuantity() + quantity);
                }
                this.articleTableView.getItems().remove(i);
            }
        });

        deleteButton.setOnAction(actionEvent -> {
            OrderExample order = this.articleTableView.getSelectionModel().getSelectedItem();
            int quantity = order.getQuantity();
            if (order.getModel().equalsIgnoreCase("Telecaster")){
                articles.get(0).setQuantity(articles.get(0).getQuantity() + quantity);
            }else if (order.getModel().equalsIgnoreCase("Precision")){
                articles.get(1).setQuantity(articles.get(1).getQuantity() + quantity);
            }else{
                articles.get(2).setQuantity(articles.get(2).getQuantity() + quantity);
            }
            this.articleTableView.getItems().remove(this.articleTableView.getSelectionModel().getFocusedIndex());
        });

        confirmButton.setOnAction(actionEvent -> {
            ConfirmOrder confirmOrder = new ConfirmOrder(this);
            confirmOrder.getStage().showAndWait();
        });



//        homeMenu.setOnAction(actionEvent -> {
//            System.out.println("AHHASDIUHDGKFVJLS");
//            Login.dashboard.getStage().showAndWait();
//        });
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

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public ObservableList<OrderExample> getOrders(){
        return this.articleTableView.getItems();
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

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }


    public TableView<OrderExample> getArticleTableView() {
        return this.articleTableView;
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
