package com.fawry.challenge;

public abstract class Product {
    private final String name;
    private final double price;
    private int quantity;

    protected Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity(int amount) {
        if (amount <= 0 || amount > quantity) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        quantity -= amount;
    }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();
    public abstract double getWeight();
}
