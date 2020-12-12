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
