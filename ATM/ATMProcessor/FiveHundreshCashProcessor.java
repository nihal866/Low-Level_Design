package ATM.ATMProcessor;

public class FiveHundreshCashProcessor extends CashProcessor {
    public FiveHundreshCashProcessor(CashProcessor cashProcessor){
        super(cashProcessor);
    }

    @Override
    public int returnCash(int cashLevel, int amount){
        if(cashLevel == CASH500){
            return (int)amount/500;
        } else {
            return super.returnCash(cashLevel, amount);
        }
    }
}
