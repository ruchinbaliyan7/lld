package org.example.vendingmachine.state;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Product;
import org.example.vendingmachine.VendingMachine;

public abstract class VendingMachineState {
    VendingMachine machine;

    VendingMachineState(VendingMachine machine) {
        this.machine = machine;
    }
    public abstract void insertCoin(Coin coin);
    public abstract void selectProduct(Product product, int quantity);
    public abstract void dispenseProduct();
    public abstract void cancelSelection();
    public abstract void returnCoins();
}
