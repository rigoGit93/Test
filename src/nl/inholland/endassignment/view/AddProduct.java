package nl.inholland.endassignment.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Article;
import nl.inholland.endassignment.model.Customer;
import nl.inholland.endassignment.model.Database;
import nl.inholland.endassignment.model.GuitarType;

public class AddProduct {

    private Stage stage;
    private GridPane gridPane;
    private VBox vBox;
    private Button addProduct;
    private Button cancelButton;
    private Database database;

    TableView<Article> articleTableView;

    public AddProduct(Stock stock) {
        this.articleTableView = stock.getStockArticleTableView();
        this.database = stock.getDatabase();
        initLayout();
    }

    private void initLayout() {

        gridPane = new GridPane();
        vBox = new VBox();

        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label addCustomerLabel = new Label("Add Product");
        GridPane.setConstraints(addCustomerLabel, 0, 0);

        Label brandLabel = new Label("Brand");
        GridPane.setConstraints(brandLabel, 0, 1);

        TextField brandInput = new TextField();
        brandInput.setPromptText("brand");
        GridPane.setConstraints(brandInput, 1, 1);

        Label modelLabel = new Label("Model");
        GridPane.setConstraints(modelLabel, 0,2);

        TextField modelInput = new TextField();
        modelInput.setPromptText("model");
        GridPane.setConstraints(modelInput, 1, 2);

        Label accousticLabel = new Label("Accoustic");
        GridPane.setConstraints(accousticLabel, 0, 3);

        CheckBox accosticCheckBox = new CheckBox();
        GridPane.setConstraints(accosticCheckBox, 1, 3);

        Label guitarLabel = new Label("Guitar Type");
        GridPane.setConstraints(guitarLabel, 0, 4);

        ComboBox<Article> guitarInput = new ComboBox(FXCollections.observableList(database.getArticlelist()));
        guitarInput.getSelectionModel().select(0);
        GridPane.setConstraints(guitarInput, 1, 4);

        Label quantityLabel = new Label("Quantity");
        GridPane.setConstraints(quantityLabel, 0, 5);

        TextField quantityInput = new TextField();
        GridPane.setConstraints(quantityInput, 1, 5);

        addProduct = new Button("Add Product");
        GridPane.setConstraints(addProduct, 0, 6);

        cancelButton = new Button("Cancel");
        GridPane.setConstraints(cancelButton, 1, 6);

        gridPane.getChildren().addAll(addCustomerLabel, brandLabel, brandInput, modelLabel,
        modelInput, accousticLabel, accosticCheckBox, guitarLabel,
                guitarInput, quantityLabel,quantityInput,addProduct,
                cancelButton);

        vBox.getChildren().addAll(gridPane);

        Scene scene = new Scene(vBox);

        stage = new Stage();
        stage.setTitle("Guitarshop FX - Add product");
        stage.setScene(scene);

        addProduct.setOnAction(actionEvent -> {
            Article article = new Article(Integer.parseInt(quantityInput.getText()),
                    brandInput.getText(), modelInput.getText(), accosticCheckBox.isSelected(),
                    guitarInput.getSelectionModel().getSelectedItem().getType(), 10);
            this.database.getArticlelist().add(article);
            this.articleTableView.getItems().add(article);
            stage.hide();
        });

        cancelButton.setOnAction(actionEvent -> {
            stage.hide();
        });



    }

    public Stage getStage() {
        return stage;
    }
}
