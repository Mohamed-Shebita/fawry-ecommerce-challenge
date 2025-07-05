package com.fawry.challenge;
import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!!!");
            return;
        }

        double subtotal = 0;
        double totalWeight = 0;
        double shippingFee = 0;
        List<CartItem> items = cart.getItems();
        for (CartItem item : items) {
            Product p = item.product;
            int qty = item.quantity;
            if (p.isExpired()) {
                System.out.println("Error: " + p.getName() + " is expired.");
                return;
            }
            if (qty > p.getQuantity()) {
                System.out.println("there is no stock available!!!" + p.getName());
                return;
            }

            subtotal += p.getPrice() * qty;

            if (p.requiresShipping()) {
                totalWeight += p.getWeight() * qty;
            }
        }

        if (totalWeight > 0) {
            shippingFee = 30; // flat fee as per requirements
        }

        double total = subtotal + shippingFee;

        if (!customer.canAfford(total)) {
            System.out.println("Customer balance is insufficient!!!");
            return;
        }
        customer.pay(total);
        for (CartItem item : items) {
            item.product.reduceQuantity(item.quantity);
        }
        if (totalWeight > 0) {
            System.out.println("** Shipment notice **");
            for (CartItem item : items) {
                if (item.product.requiresShipping()) {
                    System.out.println(item.quantity + "x " + item.product.getName() + "\t" + (int) (item.product.getWeight() * 1000) + "g");
                }
            }
            System.out.println("Total package weight: " + totalWeight + "kg");
        }
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : items) {
            double lineTotal = item.product.getPrice() * item.quantity;
            System.out.println(item.quantity + "x " + item.product.getName() + "  " + lineTotal);
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFee);
        System.out.println("Amount: " + total);
        System.out.println("Remaining balance: " + customer.getBalance());
    }
}
