package CabBooking.Entity;

import CabBooking.Enum.PaymentStatus;

public class Payment {
    private int paymentId;
    private Trip trip;
    private double fare;
    private PaymentStatus status;

    public Payment(int paymentId, double fare, Trip trip){
        this.paymentId = paymentId;
        this.fare = 100.0;
        this.status = PaymentStatus.PENDING;
        this.trip = trip;
    }

    public void setStatus(){
        this.status = PaymentStatus.SUCCESSFUL;
    }
}
