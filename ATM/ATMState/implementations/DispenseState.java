package ATM.ATMState.implementations;

import ATM.AtmMachine;
import ATM.Card;
import ATM.ATMProcessor.CashProcessor;
import ATM.ATMProcessor.FiveHundreshCashProcessor;
import ATM.ATMProcessor.OneHundredCashProcessor;
import ATM.ATMProcessor.TwoHundredCashProcessor;
import ATM.ATMState.State;

public class DispenseState implements State {

    CashProcessor cashProcessor;

    public DispenseState(AtmMachine atmMachine, Card card) throws Exception {
        System.out.println("Moving into Dispense state");
        cashProcessor = new FiveHundreshCashProcessor(
                new TwoHundredCashProcessor(
                        new OneHundredCashProcessor(null)));
        dispenseCash(atmMachine, card);
    }

    @Override
    public void insertCard(AtmMachine atmMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'clickOnInsertCardButton'");
    }

    @Override
    public void ejectCard(AtmMachine atmMachine) throws Exception {
        System.out.println("Ejecting your card, please collect it.");
        atmMachine.setAtmState(new IdleState(atmMachine));
    }

    @Override
    public void authenticarePin(AtmMachine atmMachine, Card card, String pin) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'authenticarePin'");
    }

    @Override
    public void selectAmount(AtmMachine atmMachine, Card card, double amount) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'selectAmount'");
    }

    @Override
    public void dispenseCash(AtmMachine atmMachine, Card card) throws Exception {
        if (atmMachine.getRequestedMoney() > card.getAccount().getBalance()) {
            throw new Exception("Insufficient balance in your bank account.");
        }
        if (atmMachine.getRequestedMoney() > atmMachine.getTotalMoney()) {
            throw new Exception("Insufficient balance in ATM Machine.");
        }
        dispenseNotes(atmMachine.getRequestedMoney());
        System.out.println("Dispensing cash: " + atmMachine.getRequestedMoney());
        atmMachine.updateTotalMoney();
        card.getAccount().updateBalance(atmMachine.getRequestedMoney());
        atmMachine.setAtmState(new IdleState(atmMachine));
    }

    private void dispenseNotes(int amount) {
        System.out.println("========== Dispensing cash notes from ATM =========");
        int notes = cashProcessor.returnCash(CashProcessor.CASH500, amount);
        System.out.println("Total 500 notes to be displayed: " + notes);
        amount = amount % 500;
        notes = cashProcessor.returnCash(CashProcessor.CASH200, amount);
        System.out.println("Total 200 notes to be displayed: " + notes);
        amount = amount % 200;
        notes = cashProcessor.returnCash(CashProcessor.CASH100, amount);
        System.out.println("Total 500 notes to be displayed: " + notes);
    }
}
