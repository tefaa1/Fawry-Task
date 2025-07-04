package model;

public class Product {

    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        validate();
    }

    private void validate() {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("The name must be not empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("The price must be greater than zero");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("The quantity must be greater than or equal to zero");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
