package service;

import model.*;

import java.util.List;

public class CheckoutService {
    private final static int shippingFees = 30;

    public static void checkoutReceipt(List<CartItem> cartItems, Customer customer, Boolean hasShipping) {

        System.out.println("\n** Checkout receipt **");

        double subtotal = 0;
        for (CartItem cartItem : cartItems) {

            Product product = cartItem.getProduct();
            if (product instanceof ExpirableProduct) {
                if (((ExpirableProduct) product).isExpired()) {
                    throw new RuntimeException(product.getName() + " is expired");
                }
            }
            System.out.println(cartItem.getQuantity() + "x " + product.getName() +
                    " -> " + cartItem.getTotalPrice());

            subtotal += cartItem.getTotalPrice();
        }

        double shippingAmount = hasShipping ? shippingFees : 0;
        double finalTotal = subtotal + shippingAmount;

        customer.reduceFromBalance(finalTotal);
        for (CartItem cartItem : cartItems) {

            Product product = cartItem.getProduct();
            product.reduceQuantity(cartItem.getQuantity());
        }

        System.out.println("----------------------");
        System.out.println("Subtotal -> " + subtotal);
        System.out.println("Shipping -> " + shippingAmount);
        System.out.println("Amount -> " + finalTotal);
        System.out.println("----------------------");
        System.out.println("Customer current balance -> " + customer.getBalance());
    }
}
