package model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        validate();
    }
    private void validate(){
        if(quantity > product.getQuantity()){
            throw new IllegalArgumentException("Quantity exceeds the available stock quantity");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }

    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
