package ATM.ATMState;

import ATM.AtmMachine;
import ATM.Card;

public interface State {
    public void insertCard(AtmMachine atmMachine) throws Exception;

    public void ejectCard(AtmMachine atmMachine) throws Exception;

    public void authenticarePin(AtmMachine atmMachine, Card card, String pin) throws Exception;

    public void selectAmount(AtmMachine atmMachine, Card card, double amount) throws Exception;

    public void dispenseCash(AtmMachine atmMachine, Card card) throws Exception;
}
