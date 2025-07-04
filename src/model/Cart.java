package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem>cartItems = new ArrayList<>();

    public List<CartItem>getItmes(){
        return cartItems;
    }

    public boolean isEmpty(){
        return cartItems.isEmpty();
    }

    public void add(Product product,int quantity) {

        CartItem cartItem = new CartItem(product, quantity);
        cartItems.add(cartItem);
    }

    public List<CartItem> getShippableItems() {

        List<CartItem> cartItemList = new ArrayList<>();

        for (CartItem item : cartItems) {

            Product product = item.getProduct();
            if (product instanceof Shippable) {
                cartItemList.add(item);
            }
        }
        return cartItemList;
    }
}
