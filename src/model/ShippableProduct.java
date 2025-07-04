package model;

public class ShippableProduct extends Product implements Shippable {

    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;

        if (weight <= 0) {
            throw new IllegalArgumentException("Product weight cannot be negative or zero");
        }
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

