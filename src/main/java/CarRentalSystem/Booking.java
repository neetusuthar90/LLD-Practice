package CarRentalSystem;

import CarRentalSystem.Enum.Status;

import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private User user;
    private int carId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int totalCost;
    private Status status;

    public Booking(int bookingId, User user, int carId, LocalDateTime startTime, LocalDateTime endTime, int totalCost) {
        this.bookingId = bookingId;
        this.user = user;
        this.carId = carId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalCost = totalCost;
        this.status = Status.INPROGRESS;
    }

    public int getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public int getCarId() {
        return carId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Booking{id=%d, username=%s, carId=%d, start=%s, end=%s, cost=%d, status=%s}",
                bookingId, user.getUsername(), carId, startTime, endTime, totalCost, status);
    }
}
