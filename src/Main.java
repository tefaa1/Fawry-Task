import model.*;
import service.CheckoutService;
import service.ShippingService;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product cheese = new ExpirableAndShippableProduct("Cheese", 100, 5, LocalDate.of(2025, 8, 1),200);
        Product biscuits = new ExpirableAndShippableProduct("Biscuits", 150, 2, LocalDate.of(2025, 8, 1),700);
        Product scratchCard = new ExpirableProduct("Scratch Card", 50, 10,LocalDate.of(2025, 10, 1));
        Product tv = new ShippableProduct("Samsung TV", 200, 3, 5000);

        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(tv,3);
        cart.add(scratchCard, 1);
        cart.add(biscuits,1);

        Customer customer = new Customer("Mohamed abdellatif", 2000);
        checkout(customer, cart);

        // I also updated the products quantity after the checkout
    }

    public static void checkout(Customer customer, Cart cart) {

        if(cart.isEmpty()){
            throw new IllegalArgumentException("The cart is empty");
        }
        List<CartItem>shippableItems = cart.getShippableItems();
        ShippingService.shipmentNotice(shippableItems);

        boolean hasShippable = !shippableItems.isEmpty();
        CheckoutService.checkoutReceipt(cart.getItmes(), customer, hasShippable);
    }
}