package nl.inholland.endassignment.model;

public class OrderExample {

    private int quantity;
    private String brand;
    private String model;
    private boolean acoustic;
    private GuitarType type;
    private double price;

    public OrderExample(int quantity, String brand, String model, boolean acoustic, GuitarType type, double price) {
        this.quantity = quantity;
        this.brand = brand;
        this.model = model;
        this.acoustic = acoustic;
        this.type = type;
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAcoustic(boolean acoustic) {
        this.acoustic = acoustic;
    }

    public void setType(GuitarType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAcoustic() {
        return acoustic;
    }

    public GuitarType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

}
