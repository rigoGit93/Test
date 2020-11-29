package nl.inholland.endassignment.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import nl.inholland.endassignment.model.Article;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.OrderExample;
import nl.inholland.endassignment.model.User;
import nl.inholland.endassignment.util.Notifications;
import nl.inholland.endassignment.util.SystemProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddArticle {

    private Stage stage;
    private TextField amountArticleInput;
    private Button addButton;
    private Button cancelButton;
    private Label quantityLbl;
    private VBox vBox;
    private HBox hBox;

    private TableView<Article> addArticleTableView;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private TableColumn<Article, String> priceColumn;
    private ArrayList<OrderExample> ar = new ArrayList<>();
    private static ObservableList<OrderExample> oList;

    public static ObservableList<OrderExample> getoList() {
        return oList;
    }

    private Database db;
    private ObservableList<Article> articles;
    // private ArrayList ar;
    private int quantity;
    CreateOrder cr;
    private TableView<OrderExample>  articleTableView;
    User user;

    public AddArticle(TableView<OrderExample>  articleTableView, ObservableList<Article> articles) {
        this.articleTableView = articleTableView;
        this.articles = articles;
        initLayout();
    }
    public AddArticle(int id){

    }

    public Database getDb(){
        return db;
    }

    private void initLayout() {
        db = Login.database;
        // articles = FXCollections.observableArrayList(db.getArticlelist());
        ar = new ArrayList<>();
        addArticleTableView = new TableView();
        addArticleTableView.setEditable(true);


        TableView<Article> artTbList = new TableView<>();
        artTbList.setEditable(true);
        artTbList.getSelectionModel().setCellSelectionEnabled(false);
        artTbList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        /*
        Colums worden geinitialiseerd.
         */

        TableColumn brandClm = new TableColumn("Brand");
        brandClm.setMinWidth(75);
        brandClm.setCellValueFactory(new PropertyValueFactory<Article, String>("brand"));

        TableColumn modelClm = new TableColumn("Model");
        modelClm.setMinWidth(75);
        modelClm.setCellValueFactory(new PropertyValueFactory<Article, String>("model"));

        TableColumn acousticClm = new TableColumn("Acoustic");
        acousticClm.setMinWidth(75);
        acousticClm.setCellValueFactory(new PropertyValueFactory<Article, String>("acoustic"));

        TableColumn typeClm = new TableColumn("Type");
        typeClm.setMinWidth(75);
        typeClm.setCellValueFactory(new PropertyValueFactory<Article, String>("type"));

        TableColumn priceClm = new TableColumn("Price");
        priceClm.setMinWidth(75);
        priceClm.setCellValueFactory(new PropertyValueFactory<Article, String>("price"));


        artTbList.getColumns().addAll(brandClm, modelClm, acousticClm, typeClm, priceClm);


        artTbList.setItems(articles);
        /*

         */
        brandColumn = new TableColumn("Brand");
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        brandColumn.setPrefWidth(50);

        modelColumn = new TableColumn("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        modelColumn.setPrefWidth(50);

        acousticColumn = new TableColumn("Acoustic");
        acousticColumn.setCellValueFactory(new PropertyValueFactory<>("acoustic"));
        acousticColumn.setPrefWidth(50);

        typeColumn = new TableColumn("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setPrefWidth(50);

        priceColumn = new TableColumn("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceColumn.setPrefWidth(50);

        /*
        Columns into the tableview
         */
        addArticleTableView.getColumns().addAll(brandColumn, modelColumn, acousticColumn,
                typeColumn, priceColumn);


        quantityLbl = new Label("");
        quantityLbl.setTextFill(Color.web("#ff0000", 1));
        amountArticleInput = new TextField();
        addButton = new Button("Add");
        cancelButton = new Button("Cancel");

        hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        hBox.getChildren().addAll(amountArticleInput, addButton, cancelButton);

        vBox = new VBox();
        vBox.getChildren().addAll(artTbList, hBox, quantityLbl);


        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Create an Order");
        stage.setScene(scene);
        stage.setWidth(SystemProperties.getScreenSize()[0]/3.0);

        artTbList.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {


            if (newValue != null) {
                if (addButton.isPressed()) {


                    System.out.println("Button is pressed with quantity" + newValue.getQuantity());
                    quantity = newValue.getQuantity();
                }

                System.out.println("Amount: "
                        + newValue.getQuantity() + " "

                );
            }


        }));

        addButton.setOnAction(actionEvent -> {

            String text1 = amountArticleInput.getText();
            if (text1.isEmpty()){
                Notifications.errorNotification("Amount cannot empty! ", "Error Message!", "");
            }else {
                int amount = Integer.parseInt(text1);
                Article article = artTbList.getSelectionModel().getSelectedItem();

                if (amount > article.getQuantity()) {
                    quantityLbl.setText("Not enough in stock for " + article.getBrand() + " " + article.getModel() +
                            ". Only " + article.getQuantity() + " remaining!");
                } else if (amount < 1) {
                    quantityLbl.setText("Amount cannot be less than 1! ");
                } else {
                    OrderExample order = new OrderExample(amount, article.getBrand(), article.getModel(), article.getAcoustic(), article.getType(), article.getPrice());

                    Database.getOrderExamples().add(order);
                    oList = FXCollections.observableArrayList(Database.getOrderExamples());

                    int nieuw = article.getQuantity() - amount;
                    article.setQuantity(nieuw);
                    quantityLbl.setText("");
                    this.articleTableView.getItems().add(order);
                }
                //List<Integer> amounts = db.getArticlelist().stream().map(Article::getQuantity).collect(Collectors.toList());
                //System.out.println("Here we have the extracted List of amounts: " + amounts);
            }

        });

        cancelButton.setOnAction(actionEvent -> {
            stage.hide();
        });
    }

    public ArrayList<OrderExample> getAr(){
        return ar;
    }


    public TextField getAmountArticleInput() {
        return amountArticleInput;
    }

    public void setAmountArticleInput(TextField amountArticleInput) {
        this.amountArticleInput = amountArticleInput;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Label getQuantityLbl() {
        return quantityLbl;
    }

    public void setQuantityLbl(Label quantityLbl) {
        this.quantityLbl = quantityLbl;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
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

    public TableView<Article> getAddArticleTableView() {
        return addArticleTableView;
    }

    public void setAddArticleTableView(TableView<Article> addArticleTableView) {
        this.addArticleTableView = addArticleTableView;
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
