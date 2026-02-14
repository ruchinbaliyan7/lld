package org.example.vendingmachine.state;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Product;
import org.example.vendingmachine.VendingMachine;

public class ReturnCoinState extends  VendingMachineState {

    public ReturnCoinState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("in return coin state, cannot insert coins");
    }


    @Override
    public void selectProduct(Product product,int quantity) {
        System.out.println("in return coin state");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("in return coin state");
    }

    @Override
    public void cancelSelection() {
        System.out.println("in return coin state");
    }

    @Override
    public void returnCoins() {
        System.out.println("Returning coins...");
        machine.totalAmount = 0;
        machine.setVendingMachineState(new IdleState(machine));
    }
}
