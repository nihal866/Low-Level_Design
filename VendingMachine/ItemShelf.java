package VendingMachine;

public class ItemShelf {
    int code;
    boolean soldOut;
    Item item;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public boolean isSoldOut() {
        return soldOut;
    }
    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
