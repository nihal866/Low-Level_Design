package ATM;

import ATM.ATMState.State;

public class Main {
    public static void main(String[] args) {
        AtmMachine atmMachine = new AtmMachine();

        try{
            System.out.println("======== Creating User Bank Details =======");
            BankAccount bankAccount = new BankAccount("Nihal Dwivedi", 1900, "978456846512");
            Card card = new Card("4202-5614-2258-9514", bankAccount, "4529");

            displayBankDetails(card);

            System.out.println("====== Inserting card in ATM =========");
            State atmMachineState = atmMachine.getAtmState();
            atmMachineState.insertCard(atmMachine);

            System.out.println("===== Authentication with pin =======");
            atmMachineState = atmMachine.getAtmState();
            atmMachineState.authenticarePin(atmMachine, card, "4529");

            System.out.println("====== Inserting cash to withdraw ========");
            atmMachineState = atmMachine.getAtmState();
            atmMachineState.selectAmount(atmMachine, card, 1356);

            displayBankDetails(card);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private static void displayBankDetails(Card card) {
        System.out.println("======== Showing user bank details =============");
        System.out.println("Name: " + card.getAccount().getName());
        System.out.println("Account No: " + card.getAccount().getAccountNumber());
        System.out.println("Card No: " + card.getCardNumber());
        System.out.println("Balance: " + card.getAccount().getBalance());
    }
}
