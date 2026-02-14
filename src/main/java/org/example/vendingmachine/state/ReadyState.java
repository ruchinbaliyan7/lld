package org.example.vendingmachine.state;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Product;
import org.example.vendingmachine.VendingMachine;

public class ReadyState extends VendingMachineState {
    public ReadyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {

        machine.totalAmount += coin.getValue();
        System.out.println("You inserted: " + coin.getValue() + " euros");
        if(machine.selectedProduct.price <= machine.totalAmount) {
            System.out.println("Sufficient money received.");
            machine.setVendingMachineState(new InsertCoinState(machine));
        }
    }

    @Override
    public void selectProduct(Product product, int quantity) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void cancelSelection() {
        System.out.println("Returning coins...");
    }

    @Override
    public void returnCoins() {

    }
}
