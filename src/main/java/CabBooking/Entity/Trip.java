package CabBooking.Entity;

import java.time.LocalDateTime;

public class Trip {
    private int tripId;
    private Driver driver;
    private Rider rider;
    private Location source;
    private Location destination;
    private LocalDateTime localDateTime;

    public Trip(int tripId, Driver driver, Rider rider, Location source, Location destination) {
        this.tripId = tripId;
        this.driver = driver;
        this.rider = rider;
        this.source = source;
        this.destination = destination;
        this.localDateTime = LocalDateTime.now();
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }
}
