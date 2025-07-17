package ATM.ATMProcessor;

public class TwoHundredCashProcessor extends CashProcessor {
    public TwoHundredCashProcessor (CashProcessor cashProcessor) {
        super(cashProcessor);
    }

    @Override
    public int returnCash(int cashLevel, int amount) {
        if (cashLevel == CASH200) {
            return (int) amount / 200;
        } else {
            return super.returnCash(cashLevel, amount);
        }
    }
}
