package model;

import java.time.LocalDate;

public class ExpirableProduct extends Product {

    private final LocalDate expiryDate;

    public ExpirableProduct(String name, int price, int quantity, LocalDate expiryDate) {

        super(name, price, quantity);
        this.expiryDate = expiryDate;

        if (isExpired()) {
            throw new IllegalArgumentException("Cannot set an expiry date in the past");
        }
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
