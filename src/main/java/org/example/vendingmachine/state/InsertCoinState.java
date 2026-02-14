package org.example.vendingmachine.state;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Product;
import org.example.vendingmachine.VendingMachine;

public class InsertCoinState extends VendingMachineState {

    public InsertCoinState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("already inserted coins");

    }

    @Override
    public void selectProduct(Product product, int quantity) {
        System.out.println("Product is already selected");
    }

    @Override
    public void dispenseProduct() {
        machine.setVendingMachineState(new DispenseState(machine));
        machine.dispenseProduct();
    }

    @Override
    public void cancelSelection() {

    }

    @Override
    public void returnCoins() {

    }
}
