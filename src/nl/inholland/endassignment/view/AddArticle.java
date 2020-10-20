package nl.inholland.endassignment.view;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.endassignment.model.Article;

public class AddArticle extends Views{

    private Parent root;
    private TextField amountArticleInput;
    private Button addButton;
    private Button cancelButton;
    private VBox vBox;
    private HBox hBox;

    private TableView<Article> addArticleTableView;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private TableColumn<Article, String> priceColumn;

    public AddArticle(){
        initLayout();
    }

    private void initLayout(){

        addArticleTableView = new TableView();
        addArticleTableView.setEditable(true);

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

        //columns into the tableview
        addArticleTableView.getColumns().addAll(brandColumn, modelColumn, acousticColumn,
                typeColumn, priceColumn);

        addButton= new Button("Add");
        cancelButton= new Button("Cancel");

        hBox = new HBox();
        hBox.getChildren().addAll(addButton,cancelButton);

        vBox = new VBox();
        vBox.getChildren().addAll(addArticleTableView, hBox);

        root = vBox;

    }

    @Override
    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
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
