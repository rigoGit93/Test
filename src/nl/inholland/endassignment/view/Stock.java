package nl.inholland.endassignment.view;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.endassignment.model.Article;

public class Stock{

    private Parent root;
    private TextField quantityArticleInput;
    private Button addButton;
    private VBox vBox;
    private HBox hBox;

    private TableView<Article> stockArticleTableView;
    private TableColumn<Article, String> quantityColumn;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private CheckBox negateBox;

    public Stock(){
        initLayout();
    }

    private void initLayout(){

        stockArticleTableView = new TableView();
        stockArticleTableView.setEditable(true);

        quantityColumn = new TableColumn("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityColumn.setPrefWidth(50);

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

        stockArticleTableView.getColumns().addAll(quantityColumn,brandColumn, modelColumn, acousticColumn,
                typeColumn);

        quantityArticleInput = new TextField();
        negateBox = new CheckBox("Negate");
        addButton= new Button("Add");

        hBox = new HBox();
        hBox.getChildren().addAll(quantityArticleInput,negateBox,addButton);

        vBox = new VBox();
        vBox.getChildren().addAll(stockArticleTableView, hBox);

        root = vBox;

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

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
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
