package ATM.ATMProcessor;

public abstract class CashProcessor {
    public static int CASH500 = 1;
    public static int CASH200 = 2;
    public static int CASH100 = 3;

    CashProcessor nextCashProcessor;

    CashProcessor(CashProcessor processor){
        this.nextCashProcessor = processor;
    }

    public int returnCash(int cashLevel, int amount){
        if(nextCashProcessor != null){
            return nextCashProcessor.returnCash(cashLevel, amount);
        }
        return 0;
    }
}
