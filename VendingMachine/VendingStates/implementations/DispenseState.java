package VendingMachine.VendingStates.implementations;

import java.util.List;

import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;

public class DispenseState implements State{

    public DispenseState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.err.println("Moving into Dispense State");
        dispenseProduct(vendingMachine, codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'clickOnInsertCoinButton'");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'clickOnStartProductSelectionButton'");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'chooseProduct'");
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getChange'");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.err.println("Dispensing product with code number: " + codeNumber);
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public List<Coin> retfundAllMoney(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'retfundAllMoney'");
    }

    @Override
    public void updateInventory() throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'updateInventory'");
    }
    
}
