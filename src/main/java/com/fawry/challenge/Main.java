package com.fawry.challenge;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Mohamed", 1000);

        Product cheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.now().plusDays(2), 0.2, true);

        Product biscuits = new ExpirableProduct("Biscuits", 150, 3, LocalDate.now().plusDays(1), 0.7, true);

        Product scratchCard = new NonExpirableProduct("Scratch Card", 50, 10, 0.0, false);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);

        CheckoutService.checkout(customer, cart);
    }
}
