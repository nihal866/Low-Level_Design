package ATM.ATMState.implementations;

import ATM.AtmMachine;
import ATM.Card;
import ATM.ATMState.State;

public class IdleState implements State {

    public IdleState() {
        System.out.println("ATM is in idle state.");
    }

    public IdleState(AtmMachine atmMachine) {
        System.out.println("ATM is in idle state.");
        atmMachine.setRequestedMoney(0);
    }

    @Override
    public void insertCard(AtmMachine atmMachine) throws Exception {
        atmMachine.setAtmState(new HasCardState());
    }

    @Override
    public void authenticarePin(AtmMachine atmMachine, Card card, String pin) throws Exception {
        throw new UnsupportedOperationException("Insert card first");
    }

    @Override
    public void selectAmount(AtmMachine atmMachine, Card card, double amount) throws Exception {
        throw new UnsupportedOperationException("Insert card first");
    }

    @Override
    public void dispenseCash(AtmMachine atmMachine, Card card) throws Exception {
        throw new UnsupportedOperationException("Insert card first");
    }

    @Override
    public void ejectCard(AtmMachine atmMachine) throws Exception {
        throw new UnsupportedOperationException("Insert card first");
    }

}
