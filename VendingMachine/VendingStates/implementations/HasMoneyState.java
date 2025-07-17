package VendingMachine.VendingStates.implementations;

import java.util.List;

import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.err.println("Moving into Has Money State!!!");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.err.println("Accepting coin: " + coin.name());
        vendingMachine.getCoinList().add(coin);
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
        System.err.println("Returned the full amount in coin change trash!!!");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
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
