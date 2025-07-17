package VendingMachine.VendingStates.implementations;

import java.util.List;

import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.VendingMachine;
import VendingMachine.VendingStates.State;

public class SelectionState implements State {

    public SelectionState() {
        System.err.println("Moving to Selection State!!!");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Unimplemented method 'clickOnInsertCoinButton'");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Unimplemented method 'insertCoin'");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);

        int amountPaid = 0;
        for (Coin coin : vendingMachine.getCoinList()) {
            amountPaid += coin.value;
        }

        // comparing amount paid and product price
        if (amountPaid < item.getPrice()) {
            System.err.println("Insufficient Money, price of the choosen product is: " + item.getPrice());
            retfundAllMoney(vendingMachine);
            throw new Exception("Insufficient money :(");
        } else {
            if (amountPaid > item.getPrice()) {
                getChange(amountPaid - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, codeNumber));
        }
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        System.err.println("Returning the remaining amount in cash change tray: " + extraMoney);
        return extraMoney;
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

}
