package org.example.vendingmachine;

public class VendingMachineApplication {

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getVendingMachineInstance();

        vendingMachine.addProduct(new Product("Coke", 1.5), 10);
        vendingMachine.addProduct(new Product("Pepsi", 1.75), 5);
        vendingMachine.addProduct(new Product("Sprite", 1.25), 8);

        vendingMachine.selectProduct(new Product("Coke", 1.5), 3);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.dispenseProduct();
        vendingMachine.returnCoins();

        vendingMachine.selectProduct(new Product("Pepsi", 1.75), 2);
        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.dispenseProduct();
    }
}
