package org.example.vendingmachine.state;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Product;
import org.example.vendingmachine.VendingMachine;

public class IdleState extends VendingMachineState {
    public IdleState(VendingMachine machine) {
        super(machine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select a product first");
    }

    @Override
    public void selectProduct(Product product, int quantity) {

        if(machine.getInventory().hasEnoughInventory(product, quantity)){
            machine.setVendingMachineState(new InsertCoinState(machine));
            System.out.println("Selected product: " + product.name);
        }

        else {
            System.out.println("Insufficient inventory for selected product");
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first");
    }

    @Override
    public void cancelSelection() {
        System.out.println("Please select a product first");
    }

    @Override
    public void returnCoins() {
        System.out.println("Please select a product first");
    }
}
