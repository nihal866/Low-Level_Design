package bookmyshow;

import bookmyshow.Enums.SeatCategory;

public class Seat {
    int seatId;
    SeatCategory category;
    int price;
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public SeatCategory getCategory() {
        return category;
    }
    public void setCategory(SeatCategory category) {
        this.category = category;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
