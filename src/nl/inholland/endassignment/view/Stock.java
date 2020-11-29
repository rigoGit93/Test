package nl.inholland.endassignment.view;

import javafx.collections.FXCollections;
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


public class Stock{

    private Stage stage;
    private TextField quantityArticleInput;
    private Button addButton;
    private VBox vBox;

    private User user;
    private Database database;

    private TableView<Article> stockArticleTableView;
    private TableColumn<Article, String> quantityColumn;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private CheckBox negateBox;

    public Stock(User user){
        this.user = user;
        initLayout();


    }

    private void initLayout(){
        database = Login.database;

        Label stockMaintenanceLabel = new Label("Stock maintenance");
        stockMaintenanceLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        TableView<Article> stockArticleTableView = new TableView<>();
        stockArticleTableView.setEditable(true);
        stockArticleTableView.getSelectionModel().setCellSelectionEnabled(false);
        stockArticleTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<Article, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Article, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setMinWidth(150);
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Article, String> modelColumn = new TableColumn<>("Model");
        modelColumn.setMinWidth(150);
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Article, String> acousticColumn = new TableColumn<>("Acoustic");
        acousticColumn.setMinWidth(150);
        acousticColumn.setCellValueFactory(new PropertyValueFactory<>("acoustic"));

        TableColumn<Article, String> typeColumn = new TableColumn<>("Guitar Type");
        typeColumn.setMinWidth(150);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));


        stockArticleTableView.getColumns().addAll(quantityColumn,brandColumn, modelColumn, acousticColumn,
                typeColumn);

        stockArticleTableView.setItems(FXCollections.observableArrayList(database.getArticlelist()));

        VBox xBoxTbl = new VBox();
        xBoxTbl.getChildren().addAll(stockMaintenanceLabel, stockArticleTableView);
        xBoxTbl.setSpacing(10);
        xBoxTbl.setPadding(new Insets(10, 10, 10, 10));

        quantityArticleInput = new TextField();
        negateBox = new CheckBox("Negate");
        addButton= new Button("Add");

        HBox hBoxButton = new HBox();
        hBoxButton.getChildren().addAll(quantityArticleInput, negateBox, addButton);
        hBoxButton.setSpacing(10);
        hBoxButton.setPadding(new Insets(10, 10, 10, 10));

        vBox = new VBox();
        vBox.getChildren().addAll(xBoxTbl, hBoxButton);

        addButton.setOnAction(actionEvent -> {
            if (!quantityArticleInput.getText().isEmpty() & !stockArticleTableView.getSelectionModel().isEmpty()){
                int quantity = stockArticleTableView.getSelectionModel().getSelectedItem().getQuantity();
                if (negateBox.isSelected()){
                    int newquantity = quantity - Integer.parseInt(quantityArticleInput.getText());
                    if (newquantity < 0){
                        negateBox.setDisable(true);
                    }else{
                        negateBox.setDisable(false);

                        stockArticleTableView.getSelectionModel().getSelectedItem().setQuantity(newquantity);
                    }
                }else{
                    int newquantity = quantity + Integer.parseInt(quantityArticleInput.getText());
                    stockArticleTableView.getSelectionModel().getSelectedItem().setQuantity(newquantity);
                }
            }
            stockArticleTableView.getItems().clear();
            stockArticleTableView.setItems(FXCollections.observableArrayList(database.getArticlelist()));

        });
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextField getQuantityArticleInput() {
        return quantityArticleInput;
    }

    public void setQuantityArticleInput(TextField quantityArticleInput) {
        this.quantityArticleInput = quantityArticleInput;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
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

    public TableView<Article> getStockArticleTableView() {
        return stockArticleTableView;
    }

    public void setStockArticleTableView(TableView<Article> stockArticleTableView) {
        this.stockArticleTableView = stockArticleTableView;
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

    public CheckBox getNegateBox() {
        return negateBox;
    }

    public void setNegateBox(CheckBox negateBox) {
        this.negateBox = negateBox;
    }
}
