package bookmyshow;

import bookmyshow.Enums.BookingStatus;

public class Payment {
    String paymentId;
    int bill;
    boolean paid;
    BookingStatus status;
    public BookingStatus getStatus() {
        return status;
    }
    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    public int getBill() {
        return bill;
    }
    public void setBill(int bill) {
        this.bill = bill;
    }
    public boolean isPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
