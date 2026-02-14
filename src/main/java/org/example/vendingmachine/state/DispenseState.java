package org.example.vendingmachine.state;

import org.example.vendingmachine.Coin;
import org.example.vendingmachine.Product;
import org.example.vendingmachine.VendingMachine;

public class DispenseState extends   VendingMachineState  {

    public  DispenseState(VendingMachine machine){
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("currently dispensing product , please wait");
    }

    @Override
    public void selectProduct(Product product, int quantity) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void dispenseProduct() {
    }

    @Override
    public void cancelSelection() {
        System.out.println("Dispensing in progress. Refund not allowed.");
    }

    @Override
    public void returnCoins() {
        machine.setVendingMachineState(new ReturnCoinState(machine));
        machine.returnCoins();
    }
}
