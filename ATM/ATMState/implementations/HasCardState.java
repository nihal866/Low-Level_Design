package ATM.ATMState.implementations;

import ATM.AtmMachine;
import ATM.Card;
import ATM.ATMState.State;

public class HasCardState implements State {

    public HasCardState() {
        System.out.println("Moving into has card state");
    }

    @Override
    public void insertCard(AtmMachine atmMachine) throws Exception {
        throw new UnsupportedOperationException("Card already inserted.");
    }

    @Override
    public void ejectCard(AtmMachine atmMachine) throws Exception {
        System.out.println("Ejecting your card, please collect it.");
        atmMachine.setAtmState(new IdleState(atmMachine));
    }

    @Override
    public void authenticarePin(AtmMachine atmMachine, Card card, String pin) throws Exception {
        if (pin.equals(card.getPin())) {
            System.out.println("ATM PIN Verified.");
            atmMachine.setAtmState(new SelectionState());
        } else {
            throw new Exception("Wrong Card Pin. Authentication failed, try again.");
        }
    }

    @Override
    public void selectAmount(AtmMachine atmMachine, Card card, double amount) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'selectAmount'");
    }

    @Override
    public void dispenseCash(AtmMachine atmMachine, Card card) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'dispenseCash'");
    }

}
