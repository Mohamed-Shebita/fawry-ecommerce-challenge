package com.fawry.challenge;

public class NonExpirableProduct extends Product implements Shippable {

    private final double weight;
    private final boolean needsShipping;

    public NonExpirableProduct(String name, double price, int quantity, double weight, boolean needsShipping) {
        super(name, price, quantity);
        this.weight = weight;
        this.needsShipping = needsShipping;
    }
    @Override
    public boolean isExpired() {
        return false;
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
