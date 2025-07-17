package ATM.ATMProcessor;

public class OneHundredCashProcessor extends CashProcessor {
    public OneHundredCashProcessor(CashProcessor cashProcessor) {
        super(cashProcessor);
    }

    @Override
    public int returnCash(int cashLevel, int amount) {
        if (cashLevel == CASH100) {
            return (int) amount / 100;
        } else {
            return super.returnCash(cashLevel, amount);
        }
    }
}
