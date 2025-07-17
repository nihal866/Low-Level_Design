package VendingMachine.VendingStates.implementations;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;

public class IdleState implements State {

    public IdleState() {
        System.err.println("Moving into Idle State!!!");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.err.println("Moving into Idle State!!!");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Click on insert coin button...");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Can not insert coin in idle state...");
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        throw new Exception("Unimplemented method 'getChange'");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Unimplemented method 'dispenseProduct'");
    }

    @Override
    public List<Coin> retfundAllMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Unimplemented method 'retfundAllMoney'");
    }

    @Override
    public void updateInventory() throws Exception {
        throw new Exception("Unimplemented method 'updateInventory'");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'chooseProduct'");
    }

}
