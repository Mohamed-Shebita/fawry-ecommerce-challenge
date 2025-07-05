package com.fawry.challenge;
import java.time.LocalDate;

public class ExpirableProduct extends Product implements Shippable {
    private final LocalDate expiryDate;
    private final double weight;
    private final boolean needsShipping;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight, boolean needsShipping) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
        this.needsShipping = needsShipping;
    }
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    @Override
    public boolean requiresShipping() {
        return needsShipping;
    }
    @Override
    public double getWeight() {
        return weight;
    }
}