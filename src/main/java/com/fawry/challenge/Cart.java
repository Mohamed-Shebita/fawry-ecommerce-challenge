package com.fawry.challenge;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity can't be less than zero");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("there is no stock available");
        }

        // check if product already in cart
        for (CartItem item : items) {
            if (item.product == product) {
                item.quantity += quantity;
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public List<CartItem> getItems() {
        return items;
    }
}
