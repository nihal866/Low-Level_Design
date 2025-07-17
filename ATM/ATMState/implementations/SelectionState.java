package ATM.ATMState.implementations;

import ATM.AtmMachine;
import ATM.Card;
import ATM.ATMState.State;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Moving into selection state!");
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
        if(amount%100 != 0){
            throw new Exception("Insert Cash in the multiples of 100.");
        }
        atmMachine.setRequestedMoney((int) amount);
        atmMachine.setAtmState(new DispenseState(atmMachine, card));
    }

    @Override
    public void dispenseCash(AtmMachine atmMachine, Card card) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'dispenseCash'");
    }

}
