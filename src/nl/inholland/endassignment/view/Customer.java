package nl.inholland.endassignment.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nl.inholland.endassignment.model.CustomerList;

public class Customer extends Views{

    private Parent root;
    private VBox vBox;

    private TableView<CustomerList> customerListTableView;
    private TableColumn<CustomerList, String> firstNameColumn;
    private TableColumn<CustomerList, String> lastNameColumn;
    private TableColumn<CustomerList, String> streetAddressColumn;
    private TableColumn<CustomerList, String> cityLocationColumn;
    private TableColumn<CustomerList, String> phoneNumberColumn;
    private TableColumn<CustomerList, String> emailAddressColumn;

    public Customer()
    {
        initLayout();
    }

    private void initLayout(){
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));

        //TableView<CustomerList> tableView = new TableView<>();

        TableColumn<CustomerList, String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<CustomerList, String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<CustomerList, String> streetAddressColumn = new TableColumn<>("Street Address");
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("streetAddress"));

        TableColumn<CustomerList, String> cityLocationColumn = new TableColumn<>("City");
        cityLocationColumn.setCellValueFactory(new PropertyValueFactory<>("cityLocation"));

        TableColumn<CustomerList, String> phoneNumberColumn = new TableColumn<>("Phone #");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<CustomerList, String> emailAddressColumn = new TableColumn<>("Email");
        emailAddressColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));

        customerListTableView.getColumns().addAll(firstNameColumn,lastNameColumn,streetAddressColumn,cityLocationColumn,
                phoneNumberColumn,emailAddressColumn);

        HBox form = new HBox();
        form.setPadding(new Insets(10));
        form.setSpacing(10);

//        form.getChildren().addAll(firstNameColumn, lastNameColumn, streetAddressColumn, cityLocationColumn,
//                phoneNumberColumn, emailAddressColumn);

        layout.getChildren().addAll(customerListTableView, form);

    }

    @Override
    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public TableView<CustomerList> getCustomerListTableView() {
        return customerListTableView;
    }

    public void setCustomerListTableView(TableView<CustomerList> customerListTableView) {
        this.customerListTableView = customerListTableView;
    }

    public TableColumn<CustomerList, String> getFirstNameColumn() {
        return firstNameColumn;
    }

    public void setFirstNameColumn(TableColumn<CustomerList, String> firstNameColumn) {
        this.firstNameColumn = firstNameColumn;
    }

    public TableColumn<CustomerList, String> getLastNameColumn() {
        return lastNameColumn;
    }

    public void setLastNameColumn(TableColumn<CustomerList, String> lastNameColumn) {
        this.lastNameColumn = lastNameColumn;
    }

    public TableColumn<CustomerList, String> getStreetAddressColumn() {
        return streetAddressColumn;
    }

    public void setStreetAddressColumn(TableColumn<CustomerList, String> streetAddressColumn) {
        this.streetAddressColumn = streetAddressColumn;
    }

    public TableColumn<CustomerList, String> getCityLocationColumn() {
        return cityLocationColumn;
    }

    public void setCityLocationColumn(TableColumn<CustomerList, String> cityLocationColumn) {
        this.cityLocationColumn = cityLocationColumn;
    }

    public TableColumn<CustomerList, String> getPhoneNumberColumn() {
        return phoneNumberColumn;
    }

    public void setPhoneNumberColumn(TableColumn<CustomerList, String> phoneNumberColumn) {
        this.phoneNumberColumn = phoneNumberColumn;
    }

    public TableColumn<CustomerList, String> getEmailAddressColumn() {
        return emailAddressColumn;
    }

    public void setEmailAddressColumn(TableColumn<CustomerList, String> emailAddressColumn) {
        this.emailAddressColumn = emailAddressColumn;
    }
}
