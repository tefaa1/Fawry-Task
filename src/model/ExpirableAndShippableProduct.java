package model;

import java.time.LocalDate;

public class ExpirableAndShippableProduct extends ExpirableProduct implements Shippable {

    private double weight;

    public ExpirableAndShippableProduct(String name, int price, int quantity, LocalDate expiryDate, int weight) {
        super(name, price, quantity, expiryDate);
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
