package VendingMachine;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.VendingStates.State;
import VendingMachine.VendingStates.implementations.IdleState;

public class VendingMachine {
    List<Coin> coinList;
    State vendingMachineState;
    Inventory inventory;

    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
