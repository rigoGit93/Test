package nl.inholland.endassignment.view;

import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.endassignment.model.Article;
import nl.inholland.endassignment.model.Customer;

public class OrderList{

    private Parent root;
    private VBox vBox;
    private HBox hBox;

    private TableView<Customer> orderListTableView;
    private TableColumn<Customer, String> orderNumberColumn;
    private TableColumn<Customer, String> dateColumn;
    private TableColumn<Customer, String> customerNameColumn;
    private TableColumn<Customer, String> cityLocationColumn;
    private TableColumn<Customer, String> phoneNumberColumn;
    private TableColumn<Customer, String> emailAddressColumn;
    private TableColumn<Customer, String> countColumn;
    private TableColumn<Customer, String> totalColumn;

    private TableView<Article> orderDetailsTableView;
    private TableColumn<Article, String> uuidColumn;
    private TableColumn<Article, String> brandColumn;
    private TableColumn<Article, String> modelColumn;
    private TableColumn<Article, String> acousticColumn;
    private TableColumn<Article, String> typeColumn;
    private TableColumn<Article, String> priceColumn;
    private TableColumn<Article, String> quantityColumn;

    public OrderList(){
        initLayout();
    }

    private void initLayout(){

        orderListTableView = new TableView();
        orderListTableView.setEditable(true);

        orderNumberColumn = new TableColumn("Order Number");
        orderNumberColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
        orderNumberColumn.setPrefWidth(50);

        dateColumn = new TableColumn("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setPrefWidth(50);

        customerNameColumn = new TableColumn("Customer Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        customerNameColumn.setPrefWidth(50);

        cityLocationColumn = new TableColumn("City");
        cityLocationColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        cityLocationColumn.setPrefWidth(50);

        phoneNumberColumn = new TableColumn("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumberColumn.setPrefWidth(50);

        emailAddressColumn = new TableColumn("Email Address");
        emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        emailAddressColumn.setPrefWidth(50);

        countColumn = new TableColumn("Count");
        countColumn.setCellValueFactory(new PropertyValueFactory<>("count"));
        countColumn.setPrefWidth(50);

        totalColumn = new TableColumn("Total");
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        totalColumn.setPrefWidth(50);

        orderListTableView.getColumns().addAll(orderNumberColumn, dateColumn, customerNameColumn, cityLocationColumn,
                phoneNumberColumn, emailAddressColumn, countColumn, totalColumn );



        orderDetailsTableView = new TableView();
        orderDetailsTableView.setEditable(true);

        uuidColumn = new TableColumn("Uuid");
        uuidColumn.setCellValueFactory(new PropertyValueFactory<>("uuid"));
        uuidColumn.setPrefWidth(50);

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

        quantityColumn = new TableColumn("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        quantityColumn.setPrefWidth(50);

        orderDetailsTableView.getColumns().addAll(uuidColumn, brandColumn, modelColumn, acousticColumn,
                typeColumn, priceColumn, quantityColumn );

        vBox = new VBox();
        vBox.getChildren().addAll(orderListTableView, orderDetailsTableView);

        root = vBox;

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

    public TableView<Customer> getOrderListTableView() {
        return orderListTableView;
    }

    public void setOrderListTableView(TableView<Customer> orderListTableView) {
        this.orderListTableView = orderListTableView;
    }

    public TableColumn<Customer, String> getOrderNumberColumn() {
        return orderNumberColumn;
    }

    public void setOrderNumberColumn(TableColumn<Customer, String> orderNumberColumn) {
        this.orderNumberColumn = orderNumberColumn;
    }

    public TableColumn<Customer, String> getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(TableColumn<Customer, String> dateColumn) {
        this.dateColumn = dateColumn;
    }

    public TableColumn<Customer, String> getCustomerNameColumn() {
        return customerNameColumn;
    }

    public void setCustomerNameColumn(TableColumn<Customer, String> customerNameColumn) {
        this.customerNameColumn = customerNameColumn;
    }

    public TableColumn<Customer, String> getCityLocationColumn() {
        return cityLocationColumn;
    }

    public void setCityLocationColumn(TableColumn<Customer, String> cityLocationColumn) {
        this.cityLocationColumn = cityLocationColumn;
    }

    public TableColumn<Customer, String> getPhoneNumberColumn() {
        return phoneNumberColumn;
    }

    public void setPhoneNumberColumn(TableColumn<Customer, String> phoneNumberColumn) {
        this.phoneNumberColumn = phoneNumberColumn;
    }

    public TableColumn<Customer, String> getEmailAddressColumn() {
        return emailAddressColumn;
    }

    public void setEmailAddressColumn(TableColumn<Customer, String> emailAddressColumn) {
        this.emailAddressColumn = emailAddressColumn;
    }

    public TableColumn<Customer, String> getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(TableColumn<Customer, String> countColumn) {
        this.countColumn = countColumn;
    }

    public TableColumn<Customer, String> getTotalColumn() {
        return totalColumn;
    }

    public void setTotalColumn(TableColumn<Customer, String> totalColumn) {
        this.totalColumn = totalColumn;
    }

    public TableView<Article> getOrderDetailsTableView() {
        return orderDetailsTableView;
    }

    public void setOrderDetailsTableView(TableView<Article> orderDetailsTableView) {
        this.orderDetailsTableView = orderDetailsTableView;
    }

    public TableColumn<Article, String> getUuidColumn() {
        return uuidColumn;
    }

    public void setUuidColumn(TableColumn<Article, String> uuidColumn) {
        this.uuidColumn = uuidColumn;
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

    public TableColumn<Article, String> getQuantityColumn() {
        return quantityColumn;
    }

    public void setQuantityColumn(TableColumn<Article, String> quantityColumn) {
        this.quantityColumn = quantityColumn;
    }
}
