package org.example.vendingmachine;

import org.example.vendingmachine.state.IdleState;
import org.example.vendingmachine.state.VendingMachineState;

import java.util.*;

public class VendingMachine {

    private VendingMachine(){}
    List<Product> products = new ArrayList<>();
    private Inventory inventory = new Inventory();

    private VendingMachineState vendingMachineState = new IdleState(this);
    public double totalAmount =0 ;
    public Product selectedProduct;

    private  static VendingMachine instance ;

    public static VendingMachine getVendingMachineInstance() {
        if(instance  == null) {
            instance = new VendingMachine();
        }

        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void addProduct(Product product , int quantity) {
        inventory.addProduct(product, quantity);
        products.add(product);
    }

    public void selectProduct(Product product, int quantity) {
        this.selectedProduct = product;
        this.vendingMachineState.selectProduct(product, quantity);
    }

    public void dispenseProduct(){
        this.vendingMachineState.dispenseProduct();
    }

    public void cancelSelection(){
        this.vendingMachineState.cancelSelection();
    }

    public void returnCoins(){
        this.vendingMachineState.returnCoins();
    }

    public void insertCoin(Coin coin){
        this.vendingMachineState.insertCoin(coin);
    }

    public void reset() {
        this.totalAmount = 0;
        this.selectedProduct = null;
        this.vendingMachineState = new IdleState(this);
    }

}
