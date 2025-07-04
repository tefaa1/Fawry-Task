package service;

import model.CartItem;
import model.Product;
import model.Shippable;

import java.util.List;

public class ShippingService {

    public static void shipmentNotice(List<CartItem> shippableList) {

        if (shippableList.isEmpty()) return;

        System.out.println("\n** Shipment notice **");

        double totalWeight = 0;
        for (CartItem item : shippableList) {

            Shippable shippable = (Shippable) item.getProduct();

            double itemWeight = shippable.getWeight();
            int itemQuantity = item.getQuantity();

            double curTotalWeight = itemWeight * itemQuantity;
            totalWeight += curTotalWeight;
            System.out.println(itemQuantity + "x " + shippable.getName() + " -> " + curTotalWeight + "g");
        }
        System.out.println("Total package weight " + totalWeight / 1000 + "kg");
    }
}
