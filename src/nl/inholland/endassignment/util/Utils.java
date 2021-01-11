package nl.inholland.endassignment.util;

import nl.inholland.endassignment.model.Customer;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Utils {
    public Utils(){}

    public static File getCSVFile(){
        URL url = Utils.class.getClassLoader().getResource("nl/inholland/endassignment/resources/CUSTOMERS.csv");
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        }finally {
            return file;
        }
    }

    public static ArrayList<Customer> getCustomersFromFile(File csvFile){
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null){
                String[] cols = line.split(",");
                Customer customer = new Customer(cols[0], cols[1], cols[2],
                        cols[3], Long.parseLong(cols[5]), cols[4]);
                customers.add(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
