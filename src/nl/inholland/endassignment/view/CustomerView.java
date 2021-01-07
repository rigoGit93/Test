package nl.inholland.endassignment.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private CreateOrder createOrder;
    private Customer customer;
    private Button addCustomerButton;


    private TableView<Customer> customerTableView;
    private TableColumn<Customer, String> firstNameColumn;
    private TableColumn<Customer, String> lastNameColumn;
    private TableColumn<Customer, String> streetAddressColumn;
    private TableColumn<Customer, String> cityLocationColumn;
    private TableColumn<Customer, String> phoneNumberColumn;
    private TableColumn<Customer, String> emailAddressColumn;

    public CustomerView(CreateOrder createOrder) {
        this.createOrder = createOrder;
        initLayout();
    }

    private void initLayout() {

        db = Login.database;
        String searchItem = this.createOrder.getCustomerSearchInput().getText();
        customers = FXCollections.observableArrayList(db.getCustomer(searchItem));
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

        customerTableView.getColumns().addAll(firstNameColumn, lastNameColumn, streetAddressColumn, cityLocationColumn,
                phoneNumberColumn, emailAddressColumn);

        customerTableView.setItems(customers);

//        TableView.TableViewSelectionModel selectionModel = customerTableView.getSelectionModel();
//
//        ObservableList selectedItem = selectionModel.getSelectedItems();
//
//        System.out.println(selectedItem);

        customerTableView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null) {
                createOrder.getCustomerFirstNameLabel().setText("Firstname: " + newValue.getFirstName());
                createOrder.getCustomerLastNameLbl().setText("Lastname: " + newValue.getLastName());
                createOrder.getCustomerstrNameLbl().setText("Streetname: " + newValue.getStreetAddress());
                createOrder.getCustomerphoneLbl().setText("Phone: " + newValue.getPhoneNumber());
                createOrder.getCustomercityLbl().setText("City: " + newValue.getCityLocation());
                createOrder.getCustomermailLbl().setText("Email Address: " + newValue.getEmailAddress());

                System.out.println("Selected Person: "
                        + newValue.getFirstName() + " "
                        + newValue.getLastName() + " "
                        + newValue.getStreetAddress() + " "
                        + newValue.getCityLocation() + " "
                        + newValue.getPhoneNumber() + " "
                        + newValue.getEmailAddress() + " "
                );
                createOrder.setCustomer(newValue);
            }

        }));

        customerTableView.getSelectionModel().selectedIndexProperty().addListener(ov -> {

        });

        addCustomerButton = new Button("Add customer");

        layout.getChildren().addAll(customerListLabel, customerTableView, addCustomerButton);

        addCustomerButton .setOnAction(actionEvent -> {
            AddCustomer addCustomer = new AddCustomer();
            addCustomer.getStage().showAndWait();

        });

        Scene scene = new Scene(layout);

        stage = new Stage();
        stage.setTitle("Search customers");
        stage.setScene(scene);

    }

    public Stage getStage() {
        return stage;
    }

}
