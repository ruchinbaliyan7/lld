package org.example.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    Map<Product, Integer> inventory = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        inventory.put(product, quantity);
    }

    public void reduceInventory(Product product, int quantity) {
        inventory.put(product, inventory.get(product) - quantity);
    }

    public boolean hasEnoughInventory(Product product, int quantity) {
        return inventory.getOrDefault(product, 0) >= quantity;
    }

    public int getInventoryQuantity(Product product) {
        return inventory.getOrDefault(product, 0);
    }
}
