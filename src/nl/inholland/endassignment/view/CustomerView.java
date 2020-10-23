package nl.inholland.endassignment.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.endassignment.model.Customer;
import nl.inholland.endassignment.model.Database;

public class CustomerView {


    private VBox vBox;
    private Stage stage;
    private Database db;
    private ObservableList<Customer> customers;
    private Customer customer;

    private TableView<Customer> customerTableView;
    private TableColumn<Customer, String> firstNameColumn;
    private TableColumn<Customer, String> lastNameColumn;
    private TableColumn<Customer, String> streetAddressColumn;
    private TableColumn<Customer, String> cityLocationColumn;
    private TableColumn<Customer, String> phoneNumberColumn;
    private TableColumn<Customer, String> emailAddressColumn;

    public CustomerView()
    {
        initLayout();
    }

    private void initLayout(){

        db = new Database();
        customers = FXCollections.observableArrayList(db.getCustomer());
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));

        Label customerListLabel = new Label("Customer List");

        TableView<Customer> customerTableView = new TableView<>();
        customerTableView.setEditable(true);
        customerTableView.getSelectionModel().setCellSelectionEnabled(false);
        customerTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        this.customerTableView = new TableView();
        this.customerTableView.setEditable(true);
        this.customerTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        TableColumn<Customer, String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setMinWidth(150);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Customer, String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setMinWidth(150);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> streetAddressColumn = new TableColumn<>("Street Address");
        streetAddressColumn.setMinWidth(150);
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));

        TableColumn<Customer, String> cityLocationColumn = new TableColumn<>("City");
        cityLocationColumn.setMinWidth(150);
        cityLocationColumn.setCellValueFactory(new PropertyValueFactory<>("cityLocation"));

        TableColumn<Customer, String> phoneNumberColumn = new TableColumn<>("Phone #");
        phoneNumberColumn.setMinWidth(150);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> emailAddressColumn = new TableColumn<>("Email");
        emailAddressColumn.setMinWidth(150);
        emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

        customerTableView.getColumns().addAll(firstNameColumn,lastNameColumn,streetAddressColumn,cityLocationColumn,
                phoneNumberColumn,emailAddressColumn);

        customerTableView.setItems(customers);

//        TableView.TableViewSelectionModel selectionModel = customerTableView.getSelectionModel();
//
//        ObservableList selectedItem = selectionModel.getSelectedItems();
//
//        System.out.println(selectedItem);

        customerTableView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue != null){
                System.out.println("Selected Person: "
                        + newValue.getFirstName() + " "
                        + newValue.getLastName() + " "
                        + newValue.getStreetAddress() + " "
                        + newValue.getCityLocation() + " "
                        + newValue.getPhoneNumber() + " "
                        + newValue.getEmailAddress() + " "
                );
            }
        }));

        layout.getChildren().addAll(customerListLabel, customerTableView);

        Scene scene = new Scene(layout);

        stage = new Stage();
        stage.setTitle("Search customer");
        stage.setScene(scene);

    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ObservableList<Customer> customers) {
        this.customers = customers;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public TableView<Customer> getCustomerListTableView() {
        return customerTableView;
    }

    public void setCustomerListTableView(TableView<Customer> customerListTableView) {
        this.customerTableView = customerListTableView;
    }

    public TableColumn<Customer, String> getFirstNameColumn() {
        return firstNameColumn;
    }

    public void setFirstNameColumn(TableColumn<Customer, String> firstNameColumn) {
        this.firstNameColumn = firstNameColumn;
    }

    public TableColumn<Customer, String> getLastNameColumn() {
        return lastNameColumn;
    }

    public void setLastNameColumn(TableColumn<Customer, String> lastNameColumn) {
        this.lastNameColumn = lastNameColumn;
    }

    public TableColumn<Customer, String> getStreetAddressColumn() {
        return streetAddressColumn;
    }

    public void setStreetAddressColumn(TableColumn<Customer, String> streetAddressColumn) {
        this.streetAddressColumn = streetAddressColumn;
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
}
