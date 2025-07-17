package ATM;

import ATM.ATMState.State;
import ATM.ATMState.implementations.IdleState;

public class AtmMachine {
    State atmState;
    int totalMoney;
    int requestedMoney;

    public AtmMachine(){
        this.atmState = new IdleState();
        this.totalMoney = 20000;
        requestedMoney = 0;
    }

    public State getAtmState() {
        return atmState;
    }

    public void setAtmState(State atmState) {
        this.atmState = atmState;
    }

    public int getTotalMoney() {
        return totalMoney;
    }
    
    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getRequestedMoney() {
        return requestedMoney;
    }

    public void setRequestedMoney(int requestedMoney) {
        this.requestedMoney = requestedMoney;
    }

    public void updateTotalMoney(){
        setTotalMoney(totalMoney - requestedMoney);
    }
}
