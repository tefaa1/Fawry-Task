# E-Commerce System (Java)

This project is a simple console-based E-Commerce simulation built in Java as part of a coding challenge. It supports core product operations, cart management, and a checkout system with shipping logic and expiration checks.

## Features

- Define different types of products:
  - Regular products
  - Expirable products (e.g. Cheese, Biscuits)
  - Shippable products (e.g. TV, Cheese)
  - Both Expirable & Shippable
- Add products to cart with specific quantity (not exceeding stock)
- Checkout process with:
  - Expiry checks
  - Out of stock validation
  - Customer balance validation
  - Shipping calculation
  - Receipt printing

## Checkout Example Output

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.10kg

** Checkout receipt **
2x Cheese -> 200.0
1x Biscuits -> 150.0
----------------------
Subtotal -> 350.0
Shipping -> 30.0
Amount -> 380.0
Customer remaining balance: 620.0
```

## ShippingService

If any product in the cart is shippable, it's sent to the `ShippingService` which accepts a list of items implementing:

```java
public interface Shippable {
    String getName();
    double getWeight();
}
```

## Project Structure

```
model/
  ├── Product.java
  ├── ExpirableProduct.java
  ├── ShippableProduct.java
  ├── ExpirableAndShippableProduct.java
  ├── CartItem.java
  ├── Cart.java
  └── Customer.java

service/
  ├── CheckoutService.java
  └── ShippingService.java

Main.java
```

## Run Examples

The `Main` class contains example test cases including:

- Adding valid/invalid products
- Checking out with expired items
- Insufficient balance
- Empty cart
- Successful checkout

---

## Notes

- The code uses basic OOP principles: inheritance, interfaces, encapsulation.
- All edge cases are handled with exceptions and validations.
