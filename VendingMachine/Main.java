package VendingMachine;

import VendingMachine.VendingStates.State;

public class Main {
    public static void main(String args[]){
        VendingMachine vendingMachine = new VendingMachine();
        try{
            System.out.println("==== Filling up the inventory ====");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("===== Clicking on insert coin button =======");
            State vendingMachineState =  vendingMachine.getVendingMachineState();
            vendingMachineState.clickOnInsertCoinButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.insertCoin(vendingMachine, Coin.ONE);
            vendingMachineState.insertCoin(vendingMachine, Coin.FIVE);
            vendingMachineState.insertCoin(vendingMachine, Coin.TWO);

            System.out.println("====== Clicking on product selection button ======");
            vendingMachineState.clickOnStartProductSelectionButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] itemShelves = vendingMachine.getInventory().getInventory();
        for(int i = 0; i < itemShelves.length; i++){
            Item newItem = new Item();
            if(i<3){
                newItem.setType(ItemType.COKE);
                newItem.setPrice(5);
            } else if (i < 7) {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(4);
            } else {
                newItem.setType(ItemType.WATER);
                newItem.setPrice(2);
            }

            itemShelves[i].setItem(newItem);
            itemShelves[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){
        ItemShelf[] shelves = vendingMachine.getInventory().getInventory();
        for(int i = 0; i < shelves.length; i++){
            System.out.println();
            System.out.println("CodeNumber: " + shelves[i].getCode());
            System.out.println("Item: " + shelves[i].getItem().getType().name());
            System.out.println("Price: " + shelves[i].getItem().getPrice());
            System.out.println("isAvailable: " + !shelves[i].isSoldOut());
        }
    }
}
