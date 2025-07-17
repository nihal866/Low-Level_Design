package VendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int itemCount){
        inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    private void initializeEmptyInventory(){
        int startCode = 101;
        for(int i = 0; i < inventory.length; i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                if(itemShelf.isSoldOut()){
                    System.out.println("Item is already sold out: " + itemShelf.getItem().getType().name());
                } else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Item not found with code number: " + codeNumber);
    }

    public void updateSoldOutItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
                return;
            }
        }
        throw new Exception("Item not found with code number: " + codeNumber);
    }
}
